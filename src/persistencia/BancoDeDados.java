package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	// Propriedades da classe
	private Connection objConexao = null;
	
	// Métodos da classe
	Connection getObjConexao() {
		return objConexao;
	}
	
	void conectar() throws Exception {
		objConexao = DriverManager.getConnection(
		"jdbc:oracle:thin:@//fusca:1521/xe?user=auto&password=auto");
	}
	
	void desconectar() throws Exception {
		objConexao.close();
	}
}