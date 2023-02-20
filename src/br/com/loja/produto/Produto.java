package br.com.loja.produto;

public class Produto {
	
	private Integer id;
	private String nome;
	private double preco;
	
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
	
	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("O produto é: %s no valor de R$%.2f.",
				this.nome, 
				this.preco);
	}
}
