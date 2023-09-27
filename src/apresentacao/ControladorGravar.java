package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class ControladorGravar implements ActionListener {
	// Propriedades da classe
	private JComboBox<String> cboProduto = null;
	private ArrayList<Produto> colecaoProduto = null;
	private JComboBox<String> cboCliente = null;
	private ArrayList<Cliente> colecaoCliente = null;
	private JTextField txtData = null;
	private JTextField txtQuantidade = null;

	// M�todo construtor cheio da classe
	public ControladorGravar(JComboBox<String> cboProduto, ArrayList<Produto> colecaoProduto,
			JComboBox<String> cboCliente, ArrayList<Cliente> colecaoCliente, JTextField txtData,
			JTextField txtQuantidade) {
		super();
		this.cboProduto = cboProduto;
		this.colecaoProduto = colecaoProduto;
		this.cboCliente = cboCliente;
		this.colecaoCliente = colecaoCliente;
		this.txtData = txtData;
		this.txtQuantidade = txtQuantidade;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Compra objCompra = new Compra();
			
			objCompra.setObjProduto(colecaoProduto.get(
							cboProduto.getSelectedIndex() - 1));
			objCompra.setObjCliente(colecaoCliente.get(
							cboCliente.getSelectedIndex() - 1));
			objCompra.setDataTexto(txtData.getText());
			objCompra.setQuantidade(Integer.parseInt(
							txtQuantidade.getText()));
			
			objCompra.persistir();
			
			JOptionPane.showMessageDialog(null,
							"Gravação realizada com sucesso !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}