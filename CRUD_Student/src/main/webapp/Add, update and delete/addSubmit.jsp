<%@page import="bancoDeDados.ConexaoDB"%>
<%
	
	String nome = request.getParameter("txtNome");
	String ra = request.getParameter("txtRa");
	
	if ( nome.isEmpty() || ra.isEmpty() ){
		response.sendRedirect("addPage.html");
		return;
	}
	
	ConexaoDB conn = new ConexaoDB("jdbc:mysql://localhost:3306/j_lan", "DevRaphael7", "123");
	
	if ( conn.conexaoComDatabase() == false){
		out.println("<center><h2>Erro na conexão com banco de dados :(</h2></center>");
		return;
	}
	
	if ( conn.cadastrarEst(nome, ra) != 200 ){
		out.println("<center><h2> Erro no update do usuário</h2></center>");
		return;
	}
	
	out.println("<center><h2>Usuário cadastrado com sucesso!</h2></center>");
	out.println("<center><a href='../tabelaDeAlunos.jsp'><button>Voltar</button></a></center>");
	
%>