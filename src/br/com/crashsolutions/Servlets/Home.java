package br.com.crashsolutions.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crashsolutions.DAO.ProdutoDAO;
import br.com.crashsolutions.SG.ProdutoSG;

@WebServlet("/Home") 
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DAO INSTANCIADOS
		ProdutoDAO dao = new ProdutoDAO();
		
		ArrayList<ProdutoSG> lista_tamanho = null;
		String referencia = null;
		
		try {
			
			ArrayList<ProdutoSG> lista = dao.buscaTodasReferencias();
			
			for(ProdutoSG sg: lista) {
				
				referencia = sg.getReferencia();
				lista_tamanho = dao.consultarTamanho(referencia);
			}
			
			request.setAttribute("lista_produto", lista);
			request.setAttribute("lista_tamanho", lista_tamanho);
			
		} catch (SQLException e) {
			System.out.println("Erro na lista do Home: "+ e);
		}  
		
		RequestDispatcher enviar = request.getRequestDispatcher("index.jsp");
		enviar.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
