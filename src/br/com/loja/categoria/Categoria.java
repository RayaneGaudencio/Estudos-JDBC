package br.com.loja.categoria;

public class Categoria {
	
	private int id;
	private String nome;
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
