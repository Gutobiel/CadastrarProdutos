package negocio;

public abstract class Entidade {
	// Propriedades da classe
	private int id = 0;

	// Métodos construtores da classe
	public Entidade() {
		super();
	}

	public Entidade(int id) {
		super();
		this.id = id;
	}

	// Métodos get/set da classe
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}