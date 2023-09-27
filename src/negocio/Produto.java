package negocio;

import java.util.ArrayList;

import persistencia.ProdutoDAO;

public class Produto extends Entidade {
	// Propriedades da classe
	private String nome = "";
	private double preco = 0;
	
	// Métodos construtores da classe
	public Produto() {
		super();
	}

	public Produto(int id, String nome, double preco) {
		super(id);
		this.nome = nome;
		this.preco = preco;
	}

	// Métodos get/set da classe
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	// Métodos da classe
	public static ArrayList<Produto> getTodos() throws Exception {
		return new ProdutoDAO().getTodos();
	}
}