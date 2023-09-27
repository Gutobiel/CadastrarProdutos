package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Compra;

public class CompraDAO {
	// Propriedades da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	// Métodos da classe
	private int getProximoID() throws Exception {
		int retorno = 0;
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
							"SELECT MAX(CMP_ID) FROM CMP_COMPRA");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			retorno = objCursor.getInt(1);
		}
		retorno++;
		
		objBanco.desconectar();
		
		return retorno;
	}
	
	public void persistir(Compra objCompra) throws Exception {
		objCompra.setId(getProximoID());
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
"INSERT INTO CMP_COMPRA " +
"(CMP_ID, CMP_IDPRODUTO, CMP_IDCLIENTE, CMP_DATA, CMP_QUANTIDADE) " +
"VALUES " +
"(?, ?, ?, ?, ?)");
		objExecucao.setInt(1, objCompra.getId());
		objExecucao.setInt(2, objCompra.getObjProduto().getId());
		objExecucao.setInt(3, objCompra.getObjCliente().getId());
		objExecucao.setString(4, objCompra.getDataTexto());
		objExecucao.setInt(5, objCompra.getQuantidade());
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
}