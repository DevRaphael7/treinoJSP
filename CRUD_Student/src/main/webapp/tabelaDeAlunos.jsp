<%@page import="java.util.ArrayList"%>
<%@page import="estudante.Estudante"%>
<%@page import="java.util.List"%>
<%@page import="bancoDeDados.ConexaoDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="style/style.css">
	</head>
<body>
	<% 
		List<Estudante> est = new ArrayList();	
		ConexaoDB conection = new ConexaoDB("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
	%>
	
	<% if ( conection.conexaoComDatabase() == true){ %>
	
	<center><h1>Conectado com banco de dados</h1></center>
	
		<% 
		
			est = conection.retornaDados("SELECT * FROM tb_aluno");  
			out.println(est.size());
		%>
	<center>
		<div>
			<a href="Add, update and delete/addPage.html"><button>Adicionar</button></a>
			<a href="#"><button>Update</button></a>
		</div>
		<table>
			<caption>tb_aluno</caption>
			<tr> <!-- A tag TR cria uma linha -->
				<th>Nome</th>
				<th>RA</th>
				<th>Id</th>
			</tr>
			
		<% for(Estudante estudante : est) { %>
			<tr> <!-- Dados das colunas -->
				<td><%= estudante.getNome() %></td>
				<td><%= estudante.getRa() %></td>
				<td><%= estudante.getId() %></td>
			</tr>
		<% } %>
		</table>
	</center>
		

	<% 				
		} else {
			out.println("<center><h1>Não foi possível conectar com banco de dados :( </h1></center>");
		}
	%>
</body>
</html>