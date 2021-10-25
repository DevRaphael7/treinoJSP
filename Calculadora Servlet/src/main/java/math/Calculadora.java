package math;

public class Calculadora {
	
	private String number1;
	private String number2;
	private String operacaoAri;
	
	public String calcular() {
		
		double resultado = 0;
		
		try {
			
			this.number1.replace(",", ".");
			this.number2.replace(",", ".");
			
			double numero1 = Double.parseDouble(this.number1);
			double numero2 = Double.parseDouble(this.number2);
			
			switch (this.operacaoAri) {
				case "+":
					resultado = numero1 + numero2;
				break;
				case "-":
					resultado = numero1 - numero2;
				break;
				case "/":
					resultado = numero1 / numero2;
				break;
				case "*":
					resultado = numero1 * numero2;
				break;
				default:
					return "Nenhuma das opções foi escolhidas";
 			}
			
		} catch (Exception ex) {
			return "Ocorreu um erro!" + ex.getMessage();
		}
		
		return Double.toString(resultado).replace(".", ",");
	}
	
	public Calculadora(String op, String number1, String number2) {
		this.operacaoAri = op;
		this.number1 = number1;
		this.number2 = number2;
	}
	
	
}
