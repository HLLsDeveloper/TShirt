package br.com.crashsolutions.SG;

import java.io.Serializable;

public class CadastroFisicoSG implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private Integer idusuario = 0;
	private String email = null;
	private String senha = null;
	private String cpf = null;
	private String nome = null;
	private String sobrenome = null;
	private String destinatario = null;
	private String datanascimento = null;
	private String sexo = null;
	private Integer idendereco = 0;
	private Integer idenderecofisico = 0;
	private String nomeendereco = null;
	private String endereco = null;
	private Integer numero = 0;
	private String complemento = null;
	private String bairro = null;
	private String cidade = null;
	private String estado  = null;
	private String cep = null;
	private String telefone = null;
	private String celular = null;
	private String condicao = null;
	private String imagem = null;
	private Integer idfavorito = 0;
	private Integer idfavoritofisico = 0;
	private String favoritopers = null;
	private Integer idproduto = 0;

	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getIdendereco() {
		return idendereco;
	}
	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}
	public Integer getIdenderecofisico() {
		return idenderecofisico;
	}
	public void setIdenderecofisico(Integer idenderecofisico) {
		this.idenderecofisico = idenderecofisico;
	}
	public String getNomeendereco() {
		return nomeendereco;
	}
	public void setNomeendereco(String nomeendereco) {
		this.nomeendereco = nomeendereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCondicao() {
		return condicao;
	}
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Integer getIdfavorito() {
		return idfavorito;
	}
	public void setIdfavorito(Integer idfavorito) {
		this.idfavorito = idfavorito;
	}
	public Integer getIdfavoritofisico() {
		return idfavoritofisico;
	}
	public void setIdfavoritofisico(Integer idfavoritofisico) {
		this.idfavoritofisico = idfavoritofisico;
	}
	public String getFavoritopers() {
		return favoritopers;
	}
	public void setFavoritopers(String favoritopers) {
		this.favoritopers = favoritopers;
	}
	public Integer getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}
}
