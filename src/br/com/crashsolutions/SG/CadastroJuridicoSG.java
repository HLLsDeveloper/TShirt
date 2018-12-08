package br.com.crashsolutions.SG;

import java.io.Serializable;

public class CadastroJuridicoSG implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer idempresa = 0;
	private String email = null;
	private String senha = null;
	private String cnpj = null;
	private String razao = null;
	private String nomefantasia = null;
	private String destinatario = null;
	private String ie = null;
	private Integer idendereco = 0;
	private Integer idenderecojuridico = 0;
	private String nomeendereco = null;
	private String endereco = null;
	private Integer numero = 0;
	private String complemento = null;
	private String bairro = null;
	private String cidade = null;
	private String estado = null;
	private String cep = null;
	private String telefone = null;
	private String celular = null;
	private String condicao = null;
	private String logo = null;
	
	public Integer getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getNomefantasia() {
		return nomefantasia;
	}
	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getIe() {
		return ie;
	}
	public void setIe(String ie) {
		this.ie = ie;
	}
	public Integer getIdendereco() {
		return idendereco;
	}
	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}
	public Integer getIdenderecojuridico() {
		return idenderecojuridico;
	}
	public void setIdenderecojuridico(Integer idenderecojuridico) {
		this.idenderecojuridico = idenderecojuridico;
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
	public void setTelefone(String telefone2) {
		this.telefone = telefone2;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
	