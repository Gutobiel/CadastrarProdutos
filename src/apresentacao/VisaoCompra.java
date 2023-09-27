package apresentacao;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Produto;

public class VisaoCompra extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JPanel objPainel = new JPanel();
	
	private JLabel lblProduto = new JLabel("Produto");
	private JComboBox<String> cboProduto = new JComboBox<String>();
	private ArrayList<Produto> colecaoProduto = null;
	
	private JLabel lblCliente = new JLabel("Cliente");
	private JComboBox<String> cboCliente = new JComboBox<String>();
	private ArrayList<Cliente> colecaoCliente = null;
	
	private JLabel lblData = new JLabel("Data");
	private JTextField txtData = new JTextField();
	
	private JLabel lblQuantidade = new JLabel("Quantidade");
	private JTextField txtQuantidade = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new VisaoCompra().setVisible(true);
	}
	
	// Método construtor da classe
	public VisaoCompra() {
		// Configuração da janela
		setTitle("AMAZON :-)");
		setSize(400, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Configuração do painel
		objPainel.setLayout(null);
		setContentPane(objPainel);
		
		// Produto
		lblProduto.setBounds(20, 20, 200, 20);
		objPainel.add(lblProduto);
		cboProduto.setBounds(20, 40, 340, 20);
		objPainel.add(cboProduto);
		cboProduto.addItem("");
		try {
			colecaoProduto = Produto.getTodos();
			for (Produto objProduto : colecaoProduto) {
				cboProduto.addItem(objProduto.getNome() + " (R$ " +
								   objProduto.getPreco() + ")");
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Cliente
		lblCliente.setBounds(20, 80, 200, 20);
		objPainel.add(lblCliente);
		cboCliente.setBounds(20, 100, 240, 20);
		objPainel.add(cboCliente);
		cboCliente.addItem("");
		try {
			colecaoCliente = Cliente.getTodos();
			for (Cliente objCliente : colecaoCliente) {
				cboCliente.addItem(objCliente.getNome());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Data
		lblData.setBounds(20, 140, 200, 20);
		objPainel.add(lblData);
		txtData.setBounds(20, 160, 100, 20);
		objPainel.add(txtData);
		
		// Quantidade
		lblQuantidade.setBounds(20, 200, 200, 20);
		objPainel.add(lblQuantidade);
		txtQuantidade.setBounds(20, 220, 50, 20);
		objPainel.add(txtQuantidade);
		
		// Botões
		btnGravar.setBounds(30, 260, 100, 30);
		btnGravar.addActionListener(new ControladorGravar
			(cboProduto, colecaoProduto, cboCliente, colecaoCliente,
			 txtData, txtQuantidade));
		objPainel.add(btnGravar);
		
		btnLimpar.setBounds(140, 260, 100, 30);
		btnLimpar.addActionListener(new ControladorLimpar
				(cboProduto, cboCliente, txtData, txtQuantidade));
		objPainel.add(btnLimpar);
		
		btnSair.setBounds(250, 260, 100, 30);
		btnSair.addActionListener(new ControladorSair());
		objPainel.add(btnSair);
	}
}