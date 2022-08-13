package com.mycompany.model;

import java.util.Set;

public class Usuario {

	private String nome;
	private String perfil;
	private String nomeUsuario;
	private String senha;
	private boolean autorizado;
	private boolean autenticado;
	private Set<String> autorizacoes;

	public Usuario( String nome, String perfil, String usuario, String senha ) {
		this.nome = nome;
		this.perfil = perfil;
		this.nomeUsuario = usuario;
		this.senha = senha;
		this.autorizado = false;
		this.autenticado = false;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	void setAutorizado( boolean autorizado ) {
		this.autorizado = autorizado;
	}

	void setAutenticado( boolean autenticado ) {
		this.autenticado = autenticado;
	}

	public Set<String> getAutorizacoes() {
		return autorizacoes;
	}

	void add( String autorizacao ) {
		autorizacoes.add( autorizacao );
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil( String perfil ) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario{" + "nome=" + nome + ", perfil=" + perfil + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", autorizado=" + autorizado + ", autenticado=" + autenticado + ", autorizacoes=" + autorizacoes + '}';
	}

}
