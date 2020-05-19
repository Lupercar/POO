package clase5;

public class Intervalo {
	//vamos a cambiar superior e inferior por otros atributos, pero antes hago get/set de estos 2 atributos
	//para que no rompa mucho codigo cuando haga el cambio y todo lo paso a los getter/setter
	//Y ahora cambiamos los atributos superior e inferior por estos otros y solo hay que corregir los getter/setter
//	private double superior;
//	private double inferior;
	
	private double puntoMedio;
	private double longitud;
	
	//se llaman constructores pq se ejecutan cuando se construye un objeto
// 	los constructores no construyen nada, lo que hacen es inicializar
	public Intervalo(double superior, double inferior) {
		//doy por hecho de que inferior es menor que superior, sino el assert LO REVIENTA
		assert inferior <= superior : "El inferior no es inferior al superior"; 
		this.setSuperior(superior); 
		this.setInferior(inferior); 
	}
	public Intervalo(double superior) {
		//inferior a cero
		//aqui no tenemo que hacer el assert pq ya llamo al constructor superior
		this(superior,0); 
	}
//	public Intervalo(float inferior) //superior a cero, nunca hagais esto es CONFUSO
	public Intervalo(Intervalo intervalo) {
		//esto es perfectamente valido, creas una copia de uno ya existente pero aqui lo vuelves a crear
//		superior = intervalo.superior; 
//		inferior = intervalo.inferior; 
//		haciendolo así estoy repiendo codigo mejor
		this(intervalo.getSuperior(), intervalo.getInferior()); 
	}
	
	public Intervalo() {
		this(0, 0); 
	}
	
	private double getSuperior() {
		return puntoMedio + longitud/2;
	}
	private void setSuperior(double superior) {
		longitud = superior - this.getInferior(); 
		puntoMedio = superior - longitud/2; 
	}
	private double getInferior() {
		return puntoMedio - longitud/2;
	}
	private void setInferior(double inferior) {
//		double superior = this.getSuperior(); 
//		longitud = superior - inferior; 
//		puntoMedio = inferior + longitud/2; 
		
		longitud = this.getSuperior() - inferior; 
		puntoMedio = inferior + longitud/2; 
	}
	
	//hago un clon de un Intervalo que ya existe
	public Intervalo clone() {
		//podeos poner esto return new Intervalo(superior, inferior);  o mejore 
		return new Intervalo(this); 
	}

	//no tiene parametros porque desde fuera nadie me tiene que dar la información de los limite max y min
	public double longitud() {
		return getSuperior() - getInferior(); 
	}
	
	//quiero desplazar el intervalo, es una orden por tanto no devuelve nada es un cambio de estado
	public void desplazar(double desplazamiento) {
		setSuperior(getSuperior() + desplazamiento);
		setInferior(getInferior() + desplazamiento);
	}
	
	//como serias desplazado?, creamos un nuevo intervalo
	public Intervalo desplazado(double desplazamiento) {
//		1 solucion
//		return new Intervalo(superior+desplazamiento, inferior+desplazamiento); 
		
//		2solucion me creo un intervalo con clone(), no existe repetición de código y reutiliza el código.
		Intervalo intervalo = this.clone(); 
		intervalo.desplazar(desplazamiento);
		return intervalo; 
	}
	
//	quiero saber si incluyes un punto en tu intervalo y necesito informacion del exterior (pregunta siempre si lo incluye en este caso)
	public boolean incluye(double valor) {
		return getInferior() <= valor && getSuperior() >= valor; 
	}
	public boolean incluye(Intervalo intervalo) {
		//sobrecarga pregunta si incluye este intervalo
		
//		Muchos lo harían así pero estamos repitiendo código
//		return inferior <= intervalo.inferior && superior >= intervalo.superior; 
//		mejor reutilizamos el codigo de incluye con parametro de valor
		assert intervalo!=null; //con assert obligo a que me pasen algo distinto de nulo
		return this.incluye(intervalo.getInferior()) && this.incluye(intervalo.getSuperior()); 
	}
	
	//ver si eres igual a otro intervalo
	public boolean equals(Intervalo intervalo) {
		assert intervalo!=null;
		return getInferior() == intervalo.getInferior() && getSuperior() == intervalo.getSuperior(); 
	}
	
// Interseccion entre 2 intervalos, si no hay interseccion le meto un assert y que reviente el programa
	public Intervalo interseccion (Intervalo intervalo) {
		assert intervalo!=null;
		assert this.intesecta(intervalo); //doy por hecho que intersecta sino PETO
		if(this.incluye(intervalo)) {
			//si el intervalo que me pasan esta incluido en el que tengo devuelvo una copia de el
			return intervalo.clone(); 
		}else if(intervalo.incluye(this)) {
			//viceversa
			return this.clone(); 
		}else if(this.incluye(intervalo.getInferior())){
			//estamos solapados
			return new Intervalo(getSuperior(), intervalo.getInferior()); 
		}else {
			//estamos solapados
			//este caso else if(this.incluye(intervalo.inferior))
			return new Intervalo(intervalo.getSuperior(), getInferior());
		}
	}
	
//	mirar si 2 intervalos intersectan
	public boolean intesecta(Intervalo intervalo) {
		//intervalo.incluye(this) si el me incluye a mi
		assert intervalo!=null;
		return  this.incluye(intervalo.getInferior()) || 
				this.incluye(intervalo.getSuperior()) || 
				intervalo.incluye(this); 
	}
	
//	el intervalo 8,12 va al -12,-8
	public void oponer() {
		double inferiorIncial = getInferior(); 
		double superiorIncial = getSuperior(); 
		setInferior(- superiorIncial); 
		setSuperior(- inferiorIncial); 
	}
	
//	doblar el intervalo respetando el punto medio
	public void doblar() {
		//me hago un variable local pq sino variará la longitud en cuanto cambie inferior o superior
		double longitudInicial  = this.longitud(); //estoy repitiendo codigo esto es el método longitud superior - inferior
		setInferior(getInferior() - longitudInicial/2); 
		setSuperior(getSuperior() + longitudInicial/2); 
	}
	
//	recoger los datos que te de el usuario
	public void recoger() {
		GestorIO gestorIO = new GestorIO(); 
		gestorIO.out("Inferior?");
		setInferior(gestorIO.inDouble()); 
		
		gestorIO.out("Superior?");
		setSuperior(gestorIO.inDouble()); 
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
		
		new GestorIO().out("[" + getInferior() + "," + getSuperior() + "]");
	}
	
//	trozear intervalo y devolverme los trozos, no es void porque pregunto como serias tu trozeado 
	public Intervalo[] trocear(int trozos) {
		return null; 
	}
	
	public static void main(String[] args) {
		Intervalo intervalo = new Intervalo(); 
		intervalo.recoger();
		intervalo.mostrar();
		new GestorIO().out("\nLongitud " + intervalo.longitud()); 
	}
}

