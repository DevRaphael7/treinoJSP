<%@page import="login_cadastro_jdbc.ConexaoDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<% 
	ConexaoDB conexao = new ConexaoDB();

	String teste = conexao.fazendoConexao();
	
	if ( teste.equals("Conexão com banco de dados realizada.")  ) {
		out.println("<h2>Bem-vindo!!</h2><br><br><hr>");
		out.println("<form method='POST' action='cadastrar.jsp'>");
		out.println("<div>");
		out.println("<label>Nome:</label>");
		out.println("<input type='text' name='nome' placeholder='Seu nome'>");
		out.println("</div>");
		out.println("<br><br>");
		out.println("<div>");
		out.println("<label>Senha:</label>");
		out.println("<input type='text' name='senha' placeholder='Sua senha'>");
		out.println("</div>");
		out.println("<br><br>");
		out.println("<div>");
		out.println("<label>Email:</label>");
		out.println("<input type='text' name='email' placeholder='Seu email'>");
		out.println("</div>");
		out.println("<br><br>");
		out.println("<input type='submit' name='btn' value='Cadastrar'>");
		out.println("</form>");
		out.println("<br><br>");
		out.println("<a href='Páginas.jsp'><h3>Voltar</h3></a>");
	} else {
		out.println("<h1>Erro ao conectar com o Banco de dados!</h1>");
	}
%>
</body>
</html>