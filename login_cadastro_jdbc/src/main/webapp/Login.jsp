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
	
	if ( teste.equals("Conexão com banco de dados realizada.") ){
		out.println("<form method='POST' action='HomePage.jsp'>");
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
		out.println("<input type='submit' name='btn' value='Login'>");
		out.println("</form>");
		out.println("<br><br>");
		out.println("<a href='Páginas.jsp'><h3>Voltar</h3></a>");
	} else {
		out.println("<h1>Não foi possível conectar com o banco de dados :( </h1>");
	}
%>

</body>
</html>