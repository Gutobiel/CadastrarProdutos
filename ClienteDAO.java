package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Cliente;

public class ClienteDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	// Métodos da classe
	public ArrayList<Cliente> getTodos() throws Exception {
		ArrayList<Cliente> colecao = new ArrayList<Cliente>();
		
		objBanco.conectar();

		objExecucao = objBanco.getObjConexao().prepareStatement(
									"SELECT * FROM CLI_CLIENTE");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			colecao.add(new Cliente(objCursor.getInt("CLI_ID"),
									objCursor.getString("CLI_NOME"),
									objCursor.getString("CLI_CARTAO")));
		}
		
		objBanco.desconectar();
		
		return colecao;
	}
}