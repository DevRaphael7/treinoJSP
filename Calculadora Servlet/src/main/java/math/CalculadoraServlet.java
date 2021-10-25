package math;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CalculadoraServlet extends HttpServlet{
	
	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Ol� tudo bem?</h1>");
	}
	*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Ol� tudo bem?</h1>");
		
		String numero1 = req.getParameter("txtNumber1");
		String numero2 = req.getParameter("txtNumber2");
		String operacao = req.getParameter("btn");
		
		Calculadora calc = new Calculadora(operacao, numero1, numero2);
		
		if ( calc.calcular().equals("Ocorreu um erro!") ) {
			out.println("<h1>Ocorreu um erro na convers�o dos n�meros!</h1>");
			return;
		} else if ( calc.calcular().equals("\"Nenhuma das op��es foi escolhidas\"") ) {
			out.println("<h1>Nenhuma opera��o aritm�tica foi escolhida</h1>");
			return;
		}
		
		out.println("Resultado: " + calc.calcular());
		out.println("<br><hr>");
		out.println("<a href='index.html'>VOLTAR</a>");
	}
	
	
}