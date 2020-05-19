package clase6;

import clase5.GestorIO;
import clase5.Intervalo;

//clase que limpia de 8 a 12 por 10 euros la hora ese horario
public class ContratoLimpieza {

	private String empresa;
	private int a�o;
	
	private Intervalo jornadaBase = new Intervalo(12, 8); 
	
	private final double PRECIO_HORA_ESTANDAR = 10; 
	private final double PRECIO_HORA_EXTRA = 12; 
	

	private static Intervalo[] jornadas;

	public ContratoLimpieza(String empresa, int a�o) {
		this.empresa = empresa; 
		this.a�o = a�o; 
		// tenemos que crear 365 o 366 objetos Intervalo dependiendo del a�o
		// esto de dias me lo puede pedir otro cliente asi que me lo llevo a la clase
		// Fecha a un m�todo static llamado diasA�o al que le paso el a�o
//		int dias = 365;
//		if(Fecha.bisiesto(a�o)) {
//			dias++; 
//		}
		
		int dias = Fecha.diasA�o(a�o); 
		// tb se puede calcular los dias que hay entre 2 fechas
//		int dias = new Fecha(1, 1, a�o).diferencia(new Fecha(31, 12, a�o));
		jornadas = new Intervalo[dias];

		for (int i = 0; i < dias; i++) {
			jornadas[i] = jornadaBase.clone(); //le pasamos una copia asi todos tienen una diferente
		}
	}

	//veo que se repite jornadas[fecha.diaA�o()-1] me creo un m�todo privado y sustituyo
	private Intervalo getJornada(Fecha fecha) {
		return jornadas[fecha.diaA�o()-1]; 
	}
	
	private void setJornada(Fecha fecha, Intervalo intervalo) {
		jornadas[fecha.diaA�o()-1] = intervalo; 
	}
	
	public void anular(Fecha fecha) {
		//ponemos el dia de la fecha a nulo y asi anulamos
		this.setJornada(fecha, null);
		//lo mismo que esto
//		jornadas[fecha.diaA�o()-1] = null; 
		
	}

	public void doblar(Fecha fecha) {
		this.getJornada(fecha).doblar();
	}

	// cambiar horario de 8 a 12 a otro intervalo
	public void desplazar(Fecha fecha, int desplazamiento) {
		this.getJornada(fecha).desplazar(desplazamiento);
	}
	
	public void mostrar() {
		GestorIO gestorIO = new GestorIO(); 
		gestorIO.out("Empresa: " + empresa);
		
		Fecha fecha = new Fecha(1, 1, a�o); 
		for(int i=0;i < Fecha.diasA�o(a�o); i++) {
			if(this.getJornada(fecha) != null) {
				fecha.mostrar();
				this.getJornada(fecha).mostrar();
			}
			fecha.incrementar(1);
		}
	}

	public double coste() {
		double resultado = 0; 
		
		//el resultado es la suma de los costes de cada dia
		Fecha fecha = new Fecha(1, 1, a�o); 
		for(int i=0; i<Fecha.diasA�o(a�o); i++) {
			if(this.getJornada(fecha) != null) {
				//a priori las horas extra son todas las del intervalo
				double horasEstandar = this.getJornada(fecha).interseccion(jornadaBase).longitud(); 
				double horasExtra = this.getJornada(fecha).longitud() - horasEstandar; 
				resultado += PRECIO_HORA_ESTANDAR*horasEstandar  + PRECIO_HORA_EXTRA*horasExtra; 
			}
		}
		
		return resultado;
	}
}
