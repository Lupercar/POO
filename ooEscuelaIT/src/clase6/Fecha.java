package clase6;

import java.util.StringTokenizer;

import clase5.GestorIO;

public class Fecha {

	// aparte de los atributos de tipo int dia, mes y año
	// se podria hacer mediante un String o un int con la fecha en milisegundos
	private int dia;
	private int mes;
	private int año;

	// este array es particular de una fecha? o es algo global a la comunidad,
	// si es global entonces lo hacemos static como nadie me ha pedido esta cte la
	// hago private
	private static final int[] DIAS_MESES = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final char[] INICIALES_DIA = new char[] { 's', 'd', 'l', 'm', 'x', 'j', 'v', };

	// para saber la fecha actual se puede utilizar métodos static o hacemos un
	// constructor que al nacer se inicialice
	// con la fecha del sistema por defecto
	public Fecha() {
		this(1, 1, 1);
	}

	public Fecha(int dia, int mes, int año) {
		this.setFecha(dia, mes, año); // me apoyo en el setter para pasarle una fecha
	}

	public Fecha(Fecha fecha) {
		// fecha con una fecha ya existente
		this(fecha.dia, fecha.mes, fecha.año);
	}

	public Fecha(String fecha) {
		// utilizo la libreria StringTokenizer que analiza el String que pases con el
		// separador
		StringTokenizer analizador = new StringTokenizer(fecha, "/");
		dia = Integer.parseInt(analizador.nextToken());
		mes = Integer.parseInt(analizador.nextToken());
		año = Integer.parseInt(analizador.nextToken());
	}

	public Fecha(int timeStamp) {
		// no nos interesa
	}

	public void setFecha(Fecha fecha) {
		dia = fecha.dia;
		mes = fecha.mes;
		año = fecha.año;
	}

	private void setFecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}

	public Fecha clone() {
		return new Fecha(dia, mes, año);
	}

	public void mostrar() {
		new GestorIO().out(dia + "/" + mes + "/" + año);
	}

	public String toStringCAS() {
		return dia + "/" + mes + "/" + año;
	}

	public String toStringUSA() {
		return mes + "/" + dia + "th," + año;
	}

	public boolean igual(Fecha fecha) {
		return dia == fecha.dia && mes == fecha.mes && año == fecha.año;
	}

	public boolean anterior(Fecha fecha) {
		return this.diasOrigen() < fecha.diasOrigen();
	}

	public boolean posterior(Fecha fecha) {
		return !this.igual(fecha) && !this.anterior(fecha);
	}

	public int diferencia(Fecha fecha) {
		return this.diasOrigen() - fecha.diasOrigen();
	}

	private int diasOrigen() {
		// sin contemplar bisiestos
		int resultado = this.diaAño();

		resultado += 365 * (año - 1); // no se cuenta el año actual que aun no ha pasado

		for (int i = 0; i < año - 1; i++) {
			if (Fecha.bisiesto(i)) {
				resultado++; // si es bisiesto tiene 1 dia más
			}

		}

		return resultado;
	}

	// para el calculo de años bisiesto lo hago static pq atañe a todos los dias de
	// 1 año bisiesto
	public static boolean bisiesto(int año) {
		return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
	}

	public static int diasAño(int año) {
		int resultado = 365;
		if (Fecha.bisiesto(año)) {
			resultado++;
		}
		return resultado;
	}

	public int diaAño() {
		// sin contemplar bisiestos
		int resultado = dia;
		// lo hago atributo de clase para que no este ctemente creandose y destruyendose
//				final int [] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31}; 

		for (int i = 0; i < mes; i++) {
			resultado += DIAS_MESES[i]; // no se cuenta el mes que se pasa
		}

		// me falta el dia cuando el año en el que estoy es bisiedto
		if (this.esBisiesto() && mes > 2) {
			resultado++;
		}
		return resultado; 
	}

	public boolean festivo() {
		// convenimos que solo son los sábados y domingos
		final char DIA_SEMANA = this.diaSemana();
		return DIA_SEMANA == 's' || DIA_SEMANA == 'd';
	}

	public char diaSemana() {
		// cada vez que me pide un dia se consultar constantemente lo saco fuera
//		return new char[] {'s','d','l','m','x','j','v',}[ (diasOrigen()-1)%7]; 
		return INICIALES_DIA[(diasOrigen() - 1) % 7];
	}

	public char estacion() {
		return 'c';
	}

	public int numeroSemana() {
		return (this.diasOrigen() - new Fecha(1, 1, año).diasOrigen()) / 7 + 1;
	}

	public void incrementar(int dias) {
		for (int i = 0; i < dias; i++) {
			this.incrementar();
		}
	}

	private void incrementar() {

		dia++;
		if (dia > DIAS_MESES[mes - 1]) {
			dia = 1;
			mes++;
			if (mes > 12) {
				mes = 1;
				año++;
			}
		}
	}

	public boolean esBisiesto() {
		// falta otras operaciones pero vamos a convenir que son los múltiplicos de 4
		return Fecha.bisiesto(año);
	}

	public static void main(String[] args) {
		Fecha fecha = new Fecha(5, 7, 2000);
		fecha.mostrar();
		System.out.println(Fecha.bisiesto(1985));
		System.out.println(bisiesto(1985)); // por regla de estilo pon siempre la clase de donde viene
		System.out.println(fecha.bisiesto(1993)); // esto es raro y feo poner un objeto junto con su static
	}

}
