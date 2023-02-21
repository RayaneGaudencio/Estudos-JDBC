package br.com.loja.produto;

import br.com.loja.categoria.Categoria;

public class Produto {
	
	private Integer id;
	private String nome;
	private double preco;
	private Categoria categoria;
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto(int id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto(String nome, double preco, Integer id, int idCategoria, String nomeCategoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.id = id;
		categoria = new Categoria(idCategoria, nomeCategoria);
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public Integer getId() {
		return id;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return String.format("O produto é: %s no valor de R$%.2f.",
				this.nome, 
				this.preco);
	}
}
