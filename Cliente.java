package negocio;

import java.util.ArrayList;

import persistencia.ClienteDAO;

public class Cliente extends Entidade {
	// Propriedades da classe
	private String nome = "";
	private String cartao = "";
	
	// Métodos construtores da classe
	public Cliente() {
		super();
	}
	
	public Cliente(int id, String nome, String cartao) {
		super(id);
		this.nome = nome;
		this.cartao = cartao;
	}

	// Métodos get/set da classe
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	
	// Métodos da classe
	public static ArrayList<Cliente> getTodos() throws Exception {
		return new ClienteDAO().getTodos();
	}
}