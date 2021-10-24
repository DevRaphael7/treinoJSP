<%@page import="java.text.DecimalFormat"%>
<% 
	
	DecimalFormat format = new DecimalFormat(".00");
	double height = 0;
	double peso = 0;
	double imc = 0;
	String mensagem = "";
	
	try {

		height = Double.parseDouble(request.getParameter("altura").replace(",", "."));
		peso = Double.parseDouble(request.getParameter("peso").replace(",", ".")); 
		
		imc = peso / (height * height);
		
	} catch(Exception ex) {
		
		mensagem = "Houve um erro de conversão de valores!";
		
	}
	
	if (! mensagem.equals("")) {
		
		out.println("<h2>" + mensagem + "</h2>");
		
	} else {
		
		if ( imc < 18.5 ) {
			mensagem = "MAGREZA";
		} else if ( imc < 24.9 ) {
			mensagem = "Normal";
		} else if ( imc < 29.9 ){
			mensagem = "Sobrepeso";
		} else if ( imc  < 39.0 ){
			mensagem = "Obesidade";
		} else if ( imc < 40.0 ){
			mensagem = "Obesidade Grave";
		}
		
		out.println("<h2>Resultado: " + format.format(imc) + "</h2><br>");
		out.println("<strong>Classificação: </strong>" + mensagem);
		
	}
%>