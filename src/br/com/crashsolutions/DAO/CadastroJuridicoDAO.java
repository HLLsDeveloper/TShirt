package br.com.crashsolutions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crashsolutions.SG.CadastroJuridicoSG;
import br.com.crashsolutions.Conexao.Factory;

public class CadastroJuridicoDAO {

	private String sql;
	private Connection con;
	private CadastroJuridicoSG retornoLista;
	private PreparedStatement stmtCadastrar, stmtConsultar, stmtInserir;
	private ResultSet respConsulta;
	private Boolean emailencontrado;

	public void CadastrarEmpresa(CadastroJuridicoSG sg) throws SQLException {
		
		con = new Factory().conBD();
		sql = "insert into JURIDICO (email,senha,cnpj,logo,razao,nomefantasia,ie,telefone,celular,condicao) value (?,?,?,?,?,?,?,?,?,'Ativo')";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setString(1, sg.getEmail());
			stmtInserir.setString(2, sg.getSenha());
			stmtInserir.setString(3, sg.getCnpj());
			stmtInserir.setString(4, sg.getLogo());
			stmtInserir.setString(5, sg.getRazao());
			stmtInserir.setString(6, sg.getNomefantasia());
			stmtInserir.setString(7, sg.getIe());
			stmtInserir.setString(8, sg.getTelefone());
			stmtInserir.setString(9, sg.getCelular());
			
			stmtInserir.execute();
			stmtInserir.close();
			con.close();
			
			
		} 
		catch (Exception e) {
			con.close();
			System.out.println("Erro ao inserir o usuário" + e);
		}
	}
	
	public void CadastrarEndereco(CadastroJuridicoSG sg) throws SQLException  {
		
		con = new Factory().conBD();
		sql = "insert into ENDERECO_JURIDICO (idenderecojuridico,nomeendereco,endereco,numero,complemento,bairro,cidade,estado,cep) value (?,?,?,?,?,?,?,?,?)";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setInt(1, sg.getIdenderecojuridico());
			stmtInserir.setString(2, sg.getNomeendereco());
			stmtInserir.setString(3, sg.getEndereco());
			stmtInserir.setInt(4, sg.getNumero());
			stmtInserir.setString(5, sg.getComplemento());
			stmtInserir.setString(6, sg.getBairro());
			stmtInserir.setString(7, sg.getCidade());
			stmtInserir.setString(8, sg.getEstado());
			stmtInserir.setString(9, sg.getCep());
			
			stmtInserir.execute();
			stmtInserir.close();
			con.close();
			
		} catch(Exception e) {
			con.close();
			System.out.println("Erro ao inserir o endereço" + e);
		}
	}
	
	public void cadastrarFavoritos(CadastroJuridicoSG sgjuridico) throws SQLException {
		
		con = new Factory().conBD();
		sql = "insert into FAVORITOSJURIDICO (idfavoritojuridico,idproduto,favoritopers) value (?,?,?)";
		
		try {
			
			stmtCadastrar = con.prepareStatement(sql);
			
			stmtCadastrar.setInt(1, sgjuridico.getIdfavoritojuridico());
			stmtCadastrar.setInt(2, sgjuridico.getIdproduto());
			stmtCadastrar.setString(3, sgjuridico.getFavoritopers());
			
			stmtCadastrar.execute();
			stmtCadastrar.close();
			con.close();
			
		} catch (Exception ex) {
			System.out.println("Erro ao cadastrar "+ ex);
			con.close();
		}
	}
	
	public ArrayList<CadastroJuridicoSG> consultarFavoritos(Integer idempresa) throws SQLException {
		
		con = new Factory().conBD();
		sql = "select JURIDICO.idempresa, FAVORITOSJURIDICO.* from FAVORITOSJURIDICO join JURIDICO on FAVORITOSJURIDICO.idfavoritojuridico = juridico.idempresa where idfavoritojuridico = ?";
		
		ArrayList<CadastroJuridicoSG> lista = new ArrayList<CadastroJuridicoSG>();
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setInt(1, idempresa);
			respConsulta = stmtConsultar.executeQuery();
			
			while(respConsulta.next()) {
				
				retornoLista = new CadastroJuridicoSG();
				retornoLista.setIdfavorito(respConsulta.getInt("idfavorito"));
				retornoLista.setIdfavoritojuridico(respConsulta.getInt("idfavoritojuridico"));
				retornoLista.setIdproduto(respConsulta.getInt("idproduto"));
				retornoLista.setFavoritopers(respConsulta.getString("favoritopers"));
				lista.add(retornoLista);
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch(Exception e) {
			System.out.println("Erro ao consultar os favoritos " + e);
			con.close();
		}
		return lista;
	}
	
	public Boolean verificarFavoritos(String dados, Integer idempresa) throws SQLException {
		
		ArrayList<CadastroJuridicoSG> check = consultarFavoritos(idempresa);
		Boolean encontrado = null;
		
		if(!check.isEmpty()) {
			for(CadastroJuridicoSG sg: check) {
				if(sg.getIdproduto().equals(Integer.parseInt(dados))) {
					encontrado = true;
					return encontrado;
				}
				else {
					encontrado = false;
				}
			}
		}
		else {
			encontrado = false;
		}
	return encontrado;
	}
	
	public CadastroJuridicoSG ConsultarEmpresa(String geral) throws SQLException {
		
		con = new Factory().conBD();
		sql = "select * from JURIDICO where email = ?";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, geral);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista = new CadastroJuridicoSG();
				retornoLista.setIdempresa(respConsulta.getInt("idempresa"));
				retornoLista.setEmail(respConsulta.getString("email"));
				retornoLista.setSenha(respConsulta.getString("senha"));
				retornoLista.setCnpj(respConsulta.getString("cnpj"));
				retornoLista.setLogo(respConsulta.getString("logo"));
				retornoLista.setRazao(respConsulta.getString("razao"));
				retornoLista.setNomefantasia(respConsulta.getString("nomefantasia"));
				retornoLista.setIe(respConsulta.getString("ie"));
				retornoLista.setTelefone(respConsulta.getString("telefone"));
				retornoLista.setCelular(respConsulta.getString("celular"));
				retornoLista.setCondicao(respConsulta.getString("condicao"));
					
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			con.close();
			System.out.println("Erro ao consultar o usuário + doidera " + e);
		}
		return retornoLista;
	}
	
	public ArrayList<CadastroJuridicoSG> listarEnderecos(String geral) throws SQLException {
		
		con = new Factory().conBD();
		sql = "select JURIDICO.idempresa, ENDERECO_JURIDICO.* from ENDERECO_JURIDICO join JURIDICO on endereco_juridico.idenderecojuridico = juridico.idempresa where email = ?";
		
		ArrayList <CadastroJuridicoSG> listartodos = new ArrayList<>();
		
		try {
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, geral);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista = new CadastroJuridicoSG();
				retornoLista.setIdendereco(respConsulta.getInt("endereco_juridico.idendereco"));
				retornoLista.setNomeendereco(respConsulta.getString("endereco_juridico.nomeendereco"));
				retornoLista.setEndereco(respConsulta.getString("endereco_juridico.endereco"));
				retornoLista.setNumero(respConsulta.getInt("endereco_juridico.numero"));
				retornoLista.setComplemento(respConsulta.getString("endereco_juridico.complemento"));
				retornoLista.setBairro(respConsulta.getString("endereco_juridico.bairro"));
				retornoLista.setCidade(respConsulta.getString("endereco_juridico.cidade"));
				retornoLista.setEstado(respConsulta.getString("endereco_juridico.estado"));
				retornoLista.setCep(respConsulta.getString("endereco_juridico.cep"));
				listartodos.add(retornoLista);
	
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception ex) {
			con.close();
			System.out.println("Erro ao cadastrar"+ ex);
		}
		return listartodos;
	}
	
	public ArrayList<CadastroJuridicoSG> listar() throws SQLException {
		
		con = new Factory().conBD();
		
		ArrayList<CadastroJuridicoSG> lista = new ArrayList<>();
		sql = "select * from JURIDICO";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista = new CadastroJuridicoSG();
				retornoLista.setIdempresa(respConsulta.getInt("idempresa"));
				retornoLista.setEmail(respConsulta.getString("email"));
				retornoLista.setSenha(respConsulta.getString("senha"));
				retornoLista.setCnpj(respConsulta.getString("cnpj"));
				retornoLista.setLogo(respConsulta.getString("logo"));
				retornoLista.setRazao(respConsulta.getString("razao"));
				retornoLista.setNomefantasia(respConsulta.getString("nomefantasia"));
				retornoLista.setIe(respConsulta.getString("ie"));
				retornoLista.setCondicao(respConsulta.getString("condicao"));
				lista.add(retornoLista);
				
			}
			
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			con.close();
			System.out.println("Erro ao buscar todos os usuários do bd " + e);
		}
		
		return lista;
	}
	
	//PEGA O ÚLTIMO ID GERADO PELO BANCO DE DADOS
	public CadastroJuridicoSG buscarultimo() throws SQLException {
		
		con = new Factory().conBD();
		sql = "select max(idempresa) from JURIDICO";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoLista = new CadastroJuridicoSG();
				retornoLista.setIdempresa(respConsulta.getInt("max(idempresa)"));
			}
			
			stmtConsultar.close();
			con.close(); 
			
		} catch (Exception e) {
			con.close();
			System.out.println("Erro ao buscar o último dado do banco: "+ e);
		}
		return retornoLista;
	}
	
	public Boolean EncontrarEmail(String email) throws SQLException {
		 
		 // BUSCA NA TABELA FISICO PELO EMAIL E SENHA
		 con = new Factory().conBD();
		 sql = "select email from JURIDICO where email = '" + email + "'";
		 
		 emailencontrado = null;

		 try{

			 stmtConsultar = con.prepareStatement(sql);
			 respConsulta = stmtConsultar.executeQuery();

			 // VALIDAÇÃO DE ACESSO FISICO
			 if(respConsulta.next()) {
				 emailencontrado = true;
			 } else {
				 emailencontrado = false;
			 }

			 stmtConsultar.close();
			 respConsulta.close();
			 con.close();

		 } catch (Exception ex) {
			 System.out.println("Erro no Login: "+ ex);
			 con.close();
		 }
		return emailencontrado;
	 }
}
