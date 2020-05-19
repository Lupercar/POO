package ooEscuelaIT;

public class stringEjemplo {

	public static void main(String[] args) {
		int longitud = "caracteres".length(); 
		String cadena = "caracteres";
		
		//ejemplo de inmutabilidad de String
		boolean verdadero = cadena == "caracteres"; 
		System.out.println(verdadero);
		
		boolean cierto = cadena.equals("caracteres"); 
		System.out.println(cierto);
		
		boolean tambien = "caracteres".equals(cadena); 
		System.out.println(tambien);
		
		StringBuffer buffer = new StringBuffer(cadena); 
		buffer.insert(0, "de ").insert(0, "Cadena "); 
		System.out.println(buffer);
		
		boolean si = ("Cadena de " + cadena).equals(buffer); 
		System.out.println(si); //da false
		
		String serie = (0+1) + ", " + (1+1) + ", " + (2+1)+ ". ";
		System.out.println(serie);
		
		String serie1 = " " +(1+2)+3;
		System.out.println(serie1);
	}

}
