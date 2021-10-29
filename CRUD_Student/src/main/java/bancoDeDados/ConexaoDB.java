package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; //Classe para usar lista em Java.

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import estudante.Estudante;

public class ConexaoDB {
	
	Connection conn;
	Statement statement;
	ResultSet set;
	
	private String url;
	private String user;
	private String password;
	
	public boolean conexaoComDatabase() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados realizada com sucesso!");
		} catch (Exception ex) {
			
			System.out.println("Houve um erro na conexão com banco de dados!");
			return false;
		}
		return true;
	}
	
	public List<Estudante> retornaDados(String query){
	      
		List<Estudante> lista = new ArrayList<Estudante>();
		
		try {
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			statement = conn.createStatement();
            set = statement.executeQuery(query);
            
            while ( set.next() ) {
            	
            	int id = set.getInt("id_aluno");
            	String nome = set.getString("nome");
            	String ra = String.valueOf(set.getInt("ra"));
            	
            	Estudante est = new Estudante(id, nome, ra);
            	
            	lista.add(est);
            }
            
            System.out.println(lista.size());
            
		} catch ( Exception ex ) {
			lista.clear();
			return lista;
		}
	       
		return lista;
	                          
	}
	
	public int cadastrarEst(String nome, String ra) {
		
		if (nome.isEmpty()) return 400;
		if (ra.isEmpty() || ra.length() > 8 ) return 400;
		
		int raInteger = 0;
		//Caso de algum erro de CASTING.
		try {
			raInteger = Integer.parseInt(ra);
		} catch (Exception ex) { return 400; }
		
		String query = "INSERT INTO tb_aluno (ra, nome) VALUES (" + raInteger + ", '" + nome + "')";
		
		try {
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			statement = conn.createStatement();
			statement.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return 400;
		}
		
		return 200;
	}
	
	public ConexaoDB(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

}
