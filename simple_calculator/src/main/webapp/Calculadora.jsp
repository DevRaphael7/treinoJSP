<%
		int numero1 = 0;
		int numero2 = 0;
		
		String mensagem = "Calculo feito com sucesso!";
		
		//Esse try é para casos de haver letras nos campos dos números.
		try {
			numero1 = Integer.parseInt(request.getParameter("number1"));
			numero2 = Integer.parseInt(request.getParameter("number2"));
		} catch(Exception ex){
			mensagem = "0";
		}
		 
		
		String valorDoBotao = mensagem != "0" ?
				
				request.getParameter("btn") 
				: 
				"Não pode ter letras nos campos de números!";
		
		int resultado = 0;
		
		if (valorDoBotao.contains("somar")){
			resultado = numero1 + numero2;
		} else if (valorDoBotao.contains("subtracao")) {
			resultado = numero1 - numero2;
		} else if ( valorDoBotao.contains("divisao") ) {
			resultado = numero1 / numero2;
		} else if ( valorDoBotao.contains("multiplicacao") ) {
			resultado = numero1 * numero2;
		}
		
		out.println("<h1>" + resultado + "</h1>");
		out.println("\n");
		out.println(valorDoBotao);
		out.println("<br>");
%>