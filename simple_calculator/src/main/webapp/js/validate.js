var campo1 = document.getElementById("numero1");
var campo2 = document.getElementById("numero2");

var btn = document.formulario.btn;

btn.forEach((value, index) => {
	
	value.addEventListener("click", () => {
		
		if ( campo1.value == null || campo2.value == null || campo1.value == "" || campo2.value == ""){
			alert("Campos vazios!")
			document.formulario.action = ""
			return
		}  
		
		console.log("Os campos não estão vazios, q bom :)");
		document.formulario.action = "./Calculadora.jsp"
	})
	
})