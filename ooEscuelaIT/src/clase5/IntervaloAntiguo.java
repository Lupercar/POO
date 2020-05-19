package clase5;

class IntervaloAntiguo {
	
	private double superior;
	private double inferior;
	
	//se llaman constructores pq se ejecutan cuando se construye un objeto
// 	los constructores no construyen nada, lo que hacen es inicializar
	public IntervaloAntiguo(double superior, double inferior) {
		//doy por hecho de que inferior es menor que superior, sino el assert LO REVIENTA
		assert inferior <= superior : "El inferior no es inferior al superior"; 
		this.superior = superior; 
		this.inferior = inferior; 
	}
	public IntervaloAntiguo(double superior) {
		//inferior a cero
		//aqui no tenemo que hacer el assert pq ya llamo al constructor superior
		this(superior,0); 
	}
//	public Intervalo(float inferior) //superior a cero, nunca hagais esto es CONFUSO
	public IntervaloAntiguo(IntervaloAntiguo intervalo) {
		//esto es perfectamente valido, creas una copia de uno ya existente pero aqui lo vuelves a crear
//		superior = intervalo.superior; 
//		inferior = intervalo.inferior; 
//		haciendolo así estoy repiendo codigo mejor
		this(intervalo.superior, intervalo.inferior); 
	}
	public IntervaloAntiguo() {
		this(0, 0); 
	}
	
	//hago un clon de un Intervalo que ya existe
	public IntervaloAntiguo clone() {
		//podeos poner esto return new Intervalo(superior, inferior);  o mejore 
		return new IntervaloAntiguo(this); 
	}

	//no tiene parametros porque desde fuera nadie me tiene que dar la información de los limite max y min
	public double longitud() {
		return superior - inferior; 
	}
	
	//quiero desplazar el intervalo, es una orden por tanto no devuelve nada es un cambio de estado
	public void desplazar(double desplazamiento) {
		superior += desplazamiento;
		inferior += desplazamiento;
	}
	
	//como serias desplazado?, creamos un nuevo intervalo
	public IntervaloAntiguo desplazado(double desplazamiento) {
//		1 solucion
//		return new Intervalo(superior+desplazamiento, inferior+desplazamiento); 
		
//		2solucion me creo un intervalo con clone(), no existe repetición de código y reutiliza el código.
		IntervaloAntiguo intervalo = this.clone(); 
		intervalo.desplazar(desplazamiento);
		return intervalo; 
	}
	
//	quiero saber si incluyes un punto en tu intervalo y necesito informacion del exterior (pregunta siempre si lo incluye en este caso)
	public boolean incluye(double valor) {
		return inferior <= valor && superior >= valor; 
	}
	public boolean incluye(IntervaloAntiguo intervalo) {
		//sobrecarga pregunta si incluye este intervalo
		
//		Muchos lo harían así pero estamos repitiendo código
//		return inferior <= intervalo.inferior && superior >= intervalo.superior; 
//		mejor reutilizamos el codigo de incluye con parametro de valor
		assert intervalo!=null; //con assert obligo a que me pasen algo distinto de nulo
		return this.incluye(intervalo.inferior) && this.incluye(intervalo.superior); 
	}
	
	//ver si eres igual a otro intervalo
	public boolean equals(IntervaloAntiguo intervalo) {
		assert intervalo!=null;
		return inferior == intervalo.inferior && superior == intervalo.superior; 
	}
	
// Interseccion entre 2 intervalos, si no hay interseccion le meto un assert y que reviente el programa
	public IntervaloAntiguo interseccion (IntervaloAntiguo intervalo) {
		assert intervalo!=null;
		assert this.intesecta(intervalo); //doy por hecho que intersecta sino PETO
		if(this.incluye(intervalo)) {
			//si el intervalo que me pasan esta incluido en el que tengo devuelvo una copia de el
			return intervalo.clone(); 
		}else if(intervalo.incluye(this)) {
			//viceversa
			return this.clone(); 
		}else if(this.incluye(intervalo.inferior)){
			//estamos solapados
			return new IntervaloAntiguo(superior, intervalo.inferior); 
		}else {
			//estamos solapados
			//este caso else if(this.incluye(intervalo.inferior))
			return new IntervaloAntiguo(intervalo.superior, inferior);
		}
	}
	
//	mirar si 2 intervalos intersectan
	public boolean intesecta(IntervaloAntiguo intervalo) {
		//intervalo.incluye(this) si el me incluye a mi
		assert intervalo!=null;
		return  this.incluye(intervalo.inferior) || 
				this.incluye(intervalo.superior) || 
				intervalo.incluye(this); 
	}
	
//	el intervalo 8,12 va al -12,-8
	public void oponer() {
		double inferiorIncial = inferior; 
		double superiorIncial = superior; 
		inferior = - superiorIncial; 
		superior = - inferiorIncial; 
	}
	
//	doblar el intervalo respetando el punto medio
	public void doblar() {
		//me hago un variable local pq sino variará la longitud en cuanto cambie inferior o superior
		double longitudInicial  = this.longitud(); //estoy repitiendo codigo esto es el método longitud superior - inferior
		inferior -= longitudInicial/2; 
		superior += longitudInicial/2; 
	}
	
//	recoger los datos que te de el usuario
	public void recoger() {
		GestorIO gestorIO = new GestorIO(); 
		gestorIO.out("Inferior?");
		inferior = gestorIO.inDouble(); 
		
		gestorIO.out("Superior?");
		superior = gestorIO.inDouble(); 
	}
	
//	mostrar el intervalo
	public void mostrar() {
//		GestorIO gestorIO = new GestorIO(); 
//		gestorIO.ou('[');
//		gestorIO.ou(inferior);
//		gestorIO.ou(',');
//		gestorIO.ou(superior);
//		gestorIO.ou(']');
		
//		GestorIO gestorIO = new GestorIO(); 
//		String salida = "[" + inferior + "," + superior + "]"; 
//		gestorIO.ou(salida);
		
//		GestorIO gestorIO = new GestorIO(); 
//		gestorIO.ou("[" + inferior + "," + superior + "]");
		
		new GestorIO().out("[" + inferior + "," + superior + "]");
	}
	
//	trozear intervalo y devolverme los trozos, no es void porque pregunto como serias tu trozeado 
	public IntervaloAntiguo[] trocear(int trozos) {
		return null; 
	}
	
}

class Coordenada{
	public void recoger() {
		
	}
	public void mostrar() {
		
	}
	
}
