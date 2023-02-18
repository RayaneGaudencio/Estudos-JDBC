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

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("O produto criado foi: %s no valor de R$%.2f.",
				this.nome, 
				this.preco);
	}
}
