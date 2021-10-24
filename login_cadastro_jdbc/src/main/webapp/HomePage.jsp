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

	String nome = request.getParameter("nome");
	String senha = request.getParameter("senha");
	
	ConexaoDB conn = new ConexaoDB();

	String resultado = conn.login("SELECT nome, senha FROM user" , nome, senha);
	out.println(resultado);
	out.println("<a href='Login.jsp'><input type='submit' value='voltar a página inical'></a>");

%>
</body>
</html>