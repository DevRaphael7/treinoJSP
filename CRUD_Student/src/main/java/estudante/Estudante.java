package estudante;

import java.util.List;

public class Estudante {
	
	private int id;
	private String nome;
	private String ra;
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRa() {
		return ra;
	}

	public String mostrarEstudantes() {
		String mostrar = "ID: " + id + "\nNome: " + nome + "\nRA: " + ra;
		return mostrar;
	}
	
	public Estudante ( int id, String nome, String ra ) {
		this.id = id;
		this.nome = nome;
		this.ra = ra;
	}
}
