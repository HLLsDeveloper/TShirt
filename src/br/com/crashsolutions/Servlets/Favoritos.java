package br.com.crashsolutions.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.DAO.CadastroJuridicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;
import br.com.crashsolutions.SG.CadastroJuridicoSG;

@WebServlet("/Favoritos")
public class Favoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Boolean encontrado;
	
    public Favoritos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("Home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession sessao = request.getSession();
			CadastroFisicoDAO cadastrofdao = new CadastroFisicoDAO();
			CadastroJuridicoDAO cadastrojdao = new CadastroJuridicoDAO();
			CadastroFisicoSG fisicosg = new CadastroFisicoSG();
			CadastroJuridicoSG juridicosg = new CadastroJuridicoSG();
			
			Integer idusuario = 0;
			Integer idempresa = 0;
			encontrado = null;
			
			String[] tamanhos = request.getParameterValues("idtamanho");
			
			if(sessao.getAttribute("idusuariouser") != null) {
				
				idusuario = (Integer) sessao.getAttribute("idusuariouser");
				
				for(int i = 0; i < tamanhos.length; i++) {
					
					encontrado = cadastrofdao.verificarFavoritos(tamanhos[i].toString(), idusuario);
					
					if(encontrado == false) {
						
						fisicosg.setIdfavoritofisico((Integer) sessao.getAttribute("idusuariouser"));
						fisicosg.setIdproduto(Integer.parseInt(tamanhos[i].toString()));
						fisicosg.setFavoritopers("Meus favoritos");
						
						cadastrofdao.cadastrarFavoritos(fisicosg);
					}
				}
			}
			
			else if(sessao.getAttribute("idempresauser") != null) {
				
				idempresa = (Integer) sessao.getAttribute("idempresauser");
				
				for(int i = 0; i < tamanhos.length; i++) {
					
					encontrado = cadastrojdao.verificarFavoritos(tamanhos[i].toString(), idempresa);
					
					if(encontrado == false) {
						
						juridicosg.setIdfavoritojuridico((Integer) sessao.getAttribute("idempresauser"));
						juridicosg.setIdproduto(Integer.parseInt(tamanhos[i].toString()));
						juridicosg.setFavoritopers("Meus favoritos");
						
						cadastrojdao.cadastrarFavoritos(juridicosg);
					}
				}
			}
			
			request.setAttribute("mensagem", "Adicionado ao favoritos com sucesso!");
			
			doGet(request, response);
			
		} catch(Exception e) {
			request.setAttribute("mensagem", "Ocorreu um erro ao adicionar nos favoritos!");
		}
	}
}
