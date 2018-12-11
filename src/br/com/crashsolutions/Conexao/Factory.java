package br.com.crashsolutions.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

	Connection conBD;

	public Connection conBD(){
		if(conBD == null){
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				conBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt_games_web_1", "root", "1234");
			} catch  (Exception e){
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		return conBD;
	}
}
