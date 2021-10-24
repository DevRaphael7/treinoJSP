<%@page import="login_cadastro_jdbc.ConexaoDB"%>
<% 
	ConexaoDB conn = new ConexaoDB();
	
	String nome = request.getParameter("nome");
	String senha = request.getParameter("senha");
	String email = request.getParameter("email");
	
	String query = 
			"INSERT INTO user (nome, senha, email) VALUES ('" + nome  + "','" + senha + "', '" + email + "')";
	
	out.println("<h1>" + conn.cadastrarUsuario(nome, senha, email, query) + "</h1>");
	out.println("<a href='Páginas.jsp'><h3>Voltar</h3></a>");

%>
