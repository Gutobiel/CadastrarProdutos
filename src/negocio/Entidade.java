package negocio;

public abstract class Entidade {
	// Propriedades da classe
	private int id = 0;

	// M�todos construtores da classe
	public Entidade() {
		super();
	}

	public Entidade(int id) {
		super();
		this.id = id;
	}

	// M�todos get/set da classe
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}