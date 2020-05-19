package ooEscuelaIT;

class Intervalo2 {
	
	//puedes coger los atributos que te de la gana, no tienes pq coger superior e inferior como atributos
	private double puntoMedio;
	private double longitud;
	
	public Intervalo2(double superior, double inferior) {
		longitud = superior - inferior; 
		puntoMedio = inferior + longitud/2; 
	}
	public Intervalo2(double superior) {
		//inferior a cero
	}
//	public Intervalo(float inferior) //superior a cero, nunca hagais esto es CONFUSO
	public Intervalo2(Intervalo2 intervalo) {
		//esto es perfectamente valido, creas una copia de uno ya existente pero aqui lo vuelves a crear
	}
	public Intervalo2() {
		
	}
	
	//hago un clon de un Intervalo que ya existe
	public Intervalo2 clon() {
		
	}

	//no tiene parametros porque desde fuera nadie me tiene que dar la información de los limite max y min
	public double longitud() {
		return longitud; 
	}
	
	//quiero desplazar el intervalo, es una orden por tanto no devuelve nada
	public void desplazar(double desplazamiento) {
		puntoMedio += desplazamiento; 
	}
	
	//como serias desplazado? 
	public Intervalo2 desplazado(double desplazamiento) {
		
	}
	
//	quiero saber si incluyes un punto en tu intervalo y necesito informacion del exterior (pregunta siempre si lo incluye en este caso)
	public boolean incluye(double valor) {
		//al valor que me pasan le resto el punto medio, si es menor que la mitad de la longitud NO SE HA PASADO DE MADRE
		//tiene que ser en valor absolutopor eso empleo la clase Math
		return Math.abs(valor - puntoMedio) < longitud/2; 
	}
	public boolean incluye(Intervalo2 intervalo) {
		//sobrecarga pregunta si incluye este intervalo
	}
	
	//ver si eres igual a otro intervalo
	public boolean equals(Intervalo2 intervalo) {
		
	}
	
// Interseccion entre 2 intervalos, si no hay interseccion le meto un assert y que reviente el programa
	public Intervalo2 interseccion (Intervalo2 intervalo) {
		
	}
	
//	mirar si 2 intervalos intersectan
	public boolean intesecta(Intervalo2 intervalo) {
		
	}
	
//	el intervalo 8,12 va al 12,8
	public void oponer() {
		
	}
	
//	doblar el intervalo respetando el punto medio
	public void doblar() {
		longitud *= 2; 
	}
	
//	recoger los datos que te de el usuario
	public void recoger() {
		
	}
	
//	mostrar el intervalo
	public void mostrar() {
		
	}
	
//	trozear intervalo y devolverme los trozos, no es void porque pregunto como serias tu trozeado 
	public Intervalo2[] trocear(int trozos) {
		
	}
	
}

class Coordenada{
	public void recoger() {
		
	}
	public void mostrar() {
		
	}
	
}
