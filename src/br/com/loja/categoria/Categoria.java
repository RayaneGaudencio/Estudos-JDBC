package br.com.loja.categoria;

public class Categoria {
	
	private int id;
	private String nome;
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
