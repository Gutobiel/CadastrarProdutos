package negocio;

import java.util.Calendar;
import java.util.Date;

import persistencia.CompraDAO;

public class Compra extends Entidade {
	// Propriedades da classe
	private Produto objProduto = null;
	private Cliente objCliente = null;
	private Date data = null;
	private int quantidade = 0;
	
	// Métodos construtores da classe
	public Compra() {
		super();
	}

	public Compra(int id, Produto objProduto, Cliente objCliente, Date data, int quantidade) {
		super(id);
		this.objProduto = objProduto;
		this.objCliente = objCliente;
		this.data = data;
		this.quantidade = quantidade;
	}

	// Métodos get/set da classe
	public Produto getObjProduto() {
		return objProduto;
	}

	public void setObjProduto(Produto objProduto) {
		this.objProduto = objProduto;
	}

	public Cliente getObjCliente() {
		return objCliente;
	}

	public void setObjCliente(Cliente objCliente) {
		this.objCliente = objCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	// Métodos da classe
	public String getDataTexto() {
		String retorno = "";
		
		Calendar objCalendario = Calendar.getInstance();
		objCalendario.setTime(getData());
		retorno = objCalendario.get(Calendar.DAY_OF_MONTH) + "/" +
				  (objCalendario.get(Calendar.MONTH) + 1) + "/" +
				  objCalendario.get(Calendar.YEAR);
		
		return retorno;
	}
	
	public void setDataTexto(String data) {
		Calendar objCalendario = Calendar.getInstance();
		objCalendario.set(Integer.parseInt(data.substring(6)),
						 (Integer.parseInt(data.substring(3, 5)) - 1),
						  Integer.parseInt(data.substring(0, 2)));
		setData(objCalendario.getTime());
	}
	
	public void persistir() throws Exception {
		new CompraDAO().persistir(this);
	}
}