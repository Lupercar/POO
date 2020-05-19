package ooEscuelaIT;

//crearemos las cabeceras de la clase Intervalo
//las clases tienen que ser responsable de sus operaciones evitar get/set
class Intervalo {
	
	//se llaman constructores pq se ejecutan cuando se construye un objeto
// 	los constructores no construyen nada, lo que hacen es inicializar
	public Intervalo(double superior, double inferior) {
		
	}
	public Intervalo(double superior) {
		//inferior a cero
	}
//	public Intervalo(float inferior) //superior a cero, nunca hagais esto es CONFUSO
	public Intervalo(Intervalo intervalo) {
		//esto es perfectamente valido, creas una copia de uno ya existente pero aqui lo vuelves a crear
	}
	public Intervalo() {
		
	}
	
	//hago un clon de un Intervalo que ya existe
	public Intervalo clon() {
		
	}

	//no tiene parametros porque desde fuera nadie me tiene que dar la información de los limite max y min
	public double longitud() {
		
	}
	
	//quiero desplazar el intervalo, es una orden por tanto no devuelve nada
	public void desplazar(double desplazamiento) {
		
	}
	
	//como serias desplazado? 
	public Intervalo desplazado(double desplazamiento) {
		
	}
	
//	quiero saber si incluyes un punto en tu intervalo y necesito informacion del exterior (pregunta siempre si lo incluye en este caso)
	public boolean incluye(double valor) {
		
	}
	public boolean incluye(Intervalo intervalo) {
		//sobrecarga pregunta si incluye este intervalo
	}
	
	//ver si eres igual a otro intervalo
	public boolean equals(Intervalo intervalo) {
		
	}
	
// Interseccion entre 2 intervalos, si no hay interseccion le meto un assert y que reviente el programa
	public Intervalo interseccion (Intervalo intervalo) {
		
	}
	
//	mirar si 2 intervalos intersectan
	public boolean intesecta(Intervalo intervalo) {
		
	}
	
//	el intervalo 8,12 va al 12,8
	public void oponer() {
		
	}
	
//	doblar el intervalo respetando el punto medio
	public void doblar() {
		
	}
	
//	recoger los datos que te de el usuario
	public void recoger() {
		
	}
	
//	mostrar el intervalo
	public void mostrar() {
		
	}
	
//	trozear intervalo y devolverme los trozos, no es void porque pregunto como serias tu trozeado 
	public Intervalo[] trocear(int trozos) {
		
	}
	
}

class Coordenada{
	public void recoger() {
		
	}
	public void mostrar() {
		
	}
	
}
