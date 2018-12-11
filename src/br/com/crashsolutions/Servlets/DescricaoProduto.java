package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crashsolutions.Acoes.CalculoParcelas;
import br.com.crashsolutions.Acoes.Carrinho;
import br.com.crashsolutions.Acoes.FormatarReal;
import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/Descricao")
public class DescricaoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao;
	private Integer referencia;
	
    public DescricaoProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if(request.getParameter("referencia").equals("0") || request.getParameter("referencia").equals(null)) {
			// VARIAVEIS ID E REFERENCIA
			referencia = (Integer) request.getAttribute("referencia");
		} else {
			// VARIAVEIS ID E REFERENCIA
			referencia = Integer.parseInt(request.getParameter("referencia"));
		}
		
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("url", request.getRequestURI()+"?referencia="+referencia);
			
			// FORMATAR VALOR REAL E PARCELS
			FormatarReal fr = new FormatarReal();
			CalculoParcelas cp = new CalculoParcelas();
			
			// INSTANCIA PARA ACESSAR OS TRÊS BANCOS PELA REFERENCIA
			ProdutoDAO dao = new ProdutoDAO(); 
			
			String reference = String.valueOf(referencia);
			ProdutoSG sg = dao.consultar(reference);
			
			// LISTA DE TAMANHOS
			ArrayList<ProdutoSG> listatamanho = dao.consultarTamanho(reference);
			
			request.setAttribute("produto", sg.getProduto());
			request.setAttribute("imagem", sg.getImagem());
			request.setAttribute("descricao", sg.getDescricao());
			request.setAttribute("modelo", sg.getModelo());
			request.setAttribute("cor", sg.getCor());
			request.setAttribute("genero", sg.getGenero());
			request.setAttribute("categoria", sg.getCategoria());
			request.setAttribute("id", sg.getIdproduto());
			request.setAttribute("referencia", sg.getReferencia());
			request.setAttribute("listatamanho", listatamanho);
			request.setAttribute("quantidade", dao.Quantidade);
			
			Float valor = sg.getValor_venda();
			request.setAttribute("valor", fr.formatar(valor));
			request.setAttribute("valorparcelado", fr.formatar(cp.Calcular(valor)));
			request.setAttribute("parcela", cp.Parcela(valor));

			// BUSCA A AÇÃO NO DAO QUE BUSCA OS DADOS DO PRODUTO DO CARD
			ArrayList<ProdutoSG> lista = dao.buscaTodasReferencias();
			request.setAttribute("lista_produto", lista);
								
			RequestDispatcher enviar = request.getRequestDispatcher("DescricaoProduto.jsp");
			enviar.forward(request, response);
			
		} catch(Exception e) {
			System.out.println("Erro na busca da DescriçãoProduto: "+ e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			sessao = request.getSession();
			
			String id = request.getParameter("idtamanho");
						
			// VARIAVEIS PARA ADICIONAR NO CARRINHO
			ProdutoSG colocarcarrinho = new ProdutoSG();
			Float valor = 0f;
			Integer idproduto = 0, quantidade = 0;
			String produto = null, imagem = null, tamanho = null, cor = null, categoria = null; 
			
			ProdutoDAO produtodao = new ProdutoDAO();
			colocarcarrinho = produtodao.consultar(id);
			
			idproduto = colocarcarrinho.getIdproduto();
			produto = colocarcarrinho.getProduto();
			imagem = colocarcarrinho.getImagem();
			tamanho = colocarcarrinho.getTamanho();
			cor = colocarcarrinho.getCor();
			categoria = colocarcarrinho.getCategoria();
			quantidade = colocarcarrinho.getQuantidade();
			valor = colocarcarrinho.getValor_venda();
			
			Carrinho carrinho = new Carrinho();
			
			// PEGA CARRINHO ATUAL E SE PREPARA PARA ADICIONAR O PRÓXIMO PRODUTO
			if(sessao.getAttribute("carrinho") != null) {
				
				@SuppressWarnings("unchecked")
				ArrayList<ProdutoSG> carrinhosessao = (ArrayList<ProdutoSG>) sessao.getAttribute("carrinho");	
				
				for(ProdutoSG sg: carrinhosessao) {
					
					sg.getIdproduto();
					sg.getProduto();
					sg.getImagem();
					sg.getTamanho();
					sg.getCor();
					sg.getCategoria();
					sg.getQuantidade_dig();
					sg.getQuantidade();
					sg.getValor_venda();
					carrinho.AdicionarCarrinho(sg);
				}
			
				Boolean encontrado = carrinho.ProcurarnoCarrinho(idproduto, tamanho);
				
				if(encontrado == false) {
					// ADICIONA NO CARRINHO
					colocarcarrinho.setIdproduto(idproduto);
					colocarcarrinho.setProduto(produto);
					colocarcarrinho.setImagem(imagem);
					colocarcarrinho.setTamanho(tamanho);
					colocarcarrinho.setCor(cor);
					colocarcarrinho.setCategoria(categoria);
					colocarcarrinho.setQuantidade_dig(1);
					colocarcarrinho.setQuantidade(quantidade);
					colocarcarrinho.setValor_venda(valor);
					carrinho.AdicionarCarrinho(colocarcarrinho);
					
					ArrayList<ProdutoSG> carrinhoSessao = carrinho.MostrarCarrinho();
					
					sessao.setAttribute("carrinho", carrinhoSessao);
				} 
			} 
			
			else {
				// ADICIONA NO CARRINHO
				colocarcarrinho.setIdproduto(idproduto);
				colocarcarrinho.setProduto(produto);
				colocarcarrinho.setImagem(imagem);
				colocarcarrinho.setTamanho(tamanho);
				colocarcarrinho.setCor(cor);
				colocarcarrinho.setCategoria(categoria);
				colocarcarrinho.setQuantidade_dig(1);
				colocarcarrinho.setQuantidade(quantidade);
				colocarcarrinho.setValor_venda(valor);
				carrinho.AdicionarCarrinho(colocarcarrinho);
				
				ArrayList<ProdutoSG> carrinhoSessao = carrinho.MostrarCarrinho();
				
				sessao.setAttribute("carrinho", carrinhoSessao);
			}
						
			response.sendRedirect("Carrinho");
			
		} catch(Exception e) {
			System.out.println("Erro na DescriçãoProduto ação de comprar: "+ e);
		}
	}
}
