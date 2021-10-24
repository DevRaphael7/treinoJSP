package login_cadastro_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoDB {
	
	Connection conn;
	Statement statement;
	ResultSet set;
	
	//Essa fun��o que retorna String apenas verifica se a conex�o est� OK.
	public String fazendoConexao() {
		
		String deuOuNaoCerto = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
			
			deuOuNaoCerto = "Conex�o com banco de dados realizada.";
		} catch ( Exception ex ) {
			deuOuNaoCerto = "N�o deu certo :( Sorry\nProblema: " + ex.getMessage();
		}
		
		return deuOuNaoCerto; 
	}
	
	public String login( String query, String nome, String password) {
		
		String resultado = "<h1>Este usu�rio n�o existe no banco de dados.</h1>";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
			
			statement = conn.createStatement();
            set = statement.executeQuery(query);
            
            /*
            O next � uma fun��o boolena, enquanto tiver valor no DB vai 
            continuar a iterar.
            */
            
            while ( set.next() ) {
            	
            	if ( nome.equals(set.getString("nome")) && password.equals(set.getString("senha"))) {
            		
            		resultado = "Este usu�rio existe no DB :)";
            		
            	}
            }
            
		}catch(Exception ex) {
			
			resultado = ex.getMessage();
			
		}
		
		return resultado;
	}
	
	public String cadastrarUsuario(String nome, String senha, String email, String query) {
		
		String mensagem = "";
		if ( nome == null || nome.equals("") || 
				senha == null || senha.equals("") || 
				email == null || email.equals("")) {
			
			System.out.println("N�o pode haver campos vazios!");
			return "N�o pode haver campos vazios!";
		}
		
		if ( email.split("@").length != 2) {
			System.out.println("Este e-mail � inv�lido!");
			return "Este e-mail � inv�lido!"; 
		}
		
		if ( senha.length() < 8) {
			System.out.println("A senha deve possuir pelo menos 8 caracteres!");
			return "A senha deve possuir pelo menos 8 caracteres!"; 
		}
		
		//Cadastrar o novo usu�rio
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
			
			statement = conn.createStatement();
			statement.executeUpdate(query);
			
			System.out.println("Cadastrado com sucesso! :)");
			mensagem = "Cadastrado com sucesso! :)";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			mensagem = ex.getMessage();
		}
		return mensagem;
	}
}
