package login_cadastro_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoDB {
	
	Connection conn;
	Statement statement;
	ResultSet set;
	
	//Essa função que retorna String apenas verifica se a conexão está OK.
	public String fazendoConexao() {
		
		String deuOuNaoCerto = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
			
			deuOuNaoCerto = "Conexão com banco de dados realizada.";
		} catch ( Exception ex ) {
			deuOuNaoCerto = "Não deu certo :( Sorry\nProblema: " + ex.getMessage();
		}
		
		return deuOuNaoCerto; 
	}
	
	public String login( String query, String nome, String password) {
		
		String resultado = "<h1>Este usuário não existe no banco de dados.</h1>";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
			
			statement = conn.createStatement();
            set = statement.executeQuery(query);
            
            /*
            O next é uma função boolena, enquanto tiver valor no DB vai 
            continuar a iterar.
            */
            
            while ( set.next() ) {
            	
            	if ( nome.equals(set.getString("nome")) && password.equals(set.getString("senha"))) {
            		
            		resultado = "Este usuário existe no DB :)";
            		
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
			
			System.out.println("Não pode haver campos vazios!");
			return "Não pode haver campos vazios!";
		}
		
		if ( email.split("@").length != 2) {
			System.out.println("Este e-mail é inválido!");
			return "Este e-mail é inválido!"; 
		}
		
		if ( senha.length() < 8) {
			System.out.println("A senha deve possuir pelo menos 8 caracteres!");
			return "A senha deve possuir pelo menos 8 caracteres!"; 
		}
		
		//Cadastrar o novo usuário
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
