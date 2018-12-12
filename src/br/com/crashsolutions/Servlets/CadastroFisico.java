package br.com.crashsolutions.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.Acoes.Criptografia;
import br.com.crashsolutions.DAO.CadastroFisicoDAO;
import br.com.crashsolutions.SG.CadastroFisicoSG;

@WebServlet("/CadastroFisico")
public class CadastroFisico extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CadastroFisico() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getAttribute("validacao") == "true") {
			
			request.setAttribute("mensagem", "Cadastrado com sucesso!");
			response.sendRedirect("Login");
		}
		else {
			
			request.setAttribute("mensagem", "Dados invalidos! Por favor verifique se foram digitados corretamente.");
			RequestDispatcher enviar = request.getRequestDispatcher("CadastroFisico.jsp");
			enviar.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// INSTANCIA O SG E O DAO
		    CadastroFisicoDAO dao = new CadastroFisicoDAO();
		    CadastroFisicoSG sg = new CadastroFisicoSG();
			
			// BUSCA OS DADOS DO FORM JSP
			String emailuser = request.getParameter("email");
			String senhauser = Criptografia.criptografar(request.getParameter("senha"));
		    String cpfuser = request.getParameter("cpf");
		    String imagemuser = request.getParameter("image");
		    String nomeuser = request.getParameter("nome");
		    String sobrenomeuser = request.getParameter("sobrenome");
		    String datanascimentouser = request.getParameter("datanascimento");
		    String sexouser = request.getParameter("sexo");
		    String telefoneuser = request.getParameter("telefone");
		    String celularuser = request.getParameter("celular");
		    
		    // ENVIA OS DADOS DA PAGINA JSP PARA O SG
		    sg.setEmail(emailuser);
		    sg.setSenha(senhauser);
		    sg.setCpf(cpfuser);
		    sg.setImagem(imagemuser);
		    sg.setNome(nomeuser);
		    sg.setSobrenome(sobrenomeuser);
		    sg.setDatanascimento(datanascimentouser);
		    sg.setSexo(sexouser);
		    sg.setTelefone(telefoneuser);
		    sg.setCelular(celularuser);
		    
		    // UTILIZA O METODO CADASTRARUSUARIO DO DAO
		    dao.cadastrarUsuario(sg);
		    
		    sg = dao.buscarultimo();
		    
		    //PEGA OS DADOS DO JSP PARA GRAVAR NA TABELA ENDERECO
		    String enderecouser = request.getParameter("endereco");
		    Integer numerouser = Integer.parseInt(request.getParameter("numero"));
		    String complementouser = request.getParameter("complemento");
		    String bairrouser = request.getParameter("bairro");
		    String cidadeuser = request.getParameter("cidade");
		    String estadouser = request.getParameter("estado");
		    String cepuser = request.getParameter("cep");
		    
		    sg.setIdenderecofisico(sg.getIdusuario());
		    sg.setEndereco(enderecouser);
		    sg.setNumero(numerouser);
		    sg.setComplemento(complementouser);
		    sg.setBairro(bairrouser);
		    sg.setCidade(cidadeuser);
		    sg.setEstado(estadouser);
		    sg.setCep(cepuser);
		    
		    // UTILIZA O METODO CADASTRARENDERECO DO DAO
		    dao.cadastrarEndereco(sg);
		    
		    request.setAttribute("validacao", "true");
		    
		} catch (Exception ex) {
			request.setAttribute("validacao", "false");
			System.out.println("Erro no CadastroFisico: "+ ex);
		}
		
		doGet(request, response);
	}
}
