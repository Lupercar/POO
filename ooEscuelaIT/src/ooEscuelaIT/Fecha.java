package ooEscuelaIT;

public class Fecha {
	
	//para saber la fecha actual se puede utilizar métodos static o hacemos un constructor que al nacer se inicialice 
		//con la fecha del sistema por defecto
		public Fecha() {
			
		}
		
		public Fecha(int dia, int mes, int año) {
			
		}
		
		public Fecha(Fecha fecha) {
			//fecha con una fecha ya existente
		}
		
		public Fecha(int timeStamp) {
		}
		
		public Fecha(String fecha) {
		}

	//metodos no correcto porque no tiene sentido
//	public Fecha[] festiveDaysMonth(int month) 
	
//	En POO no hay suicidios el unico que elimina es el GCC
//	public void eliminar()
	
//	no tiene sentido comparar 3 fechas la de la clase y los 2 parametros
//	public int diferencia (Fecha fecha1, Fecha fecha2)
	
//	es para una fecha no para varias, por eso no tiene sentidoC
//	public double promedioDias() 
	
	public char diaSemana() {
		return (Character) null; 
	}
	
	public boolean equals(Fecha fecha) {
//		sin parametro no tiene sentido
		return true; 
	}
	
	public boolean festivo() {
		return true; 
	}

	public int diferencia(Fecha fecha) {
		return 0; 
	}
	
	public void mostrar() {
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public String toString(int formato) {
		//mas interesante que hacer un metodo para cada formato
		return super.toString();
	}
	
	public void setFecha(Fecha fecha) {
		
	}

	public char estacion() {
		return 'c'; 
	}
	
	public int numeroSemana() {
		return 0; 
	}
	
	public void incrementar(int dia) {
		
	}
	
	public boolean esBisiesto() {
//		te dice si la fecha actual es de un año bisiesto
		return true; 
	}
	
	public Fecha clone() {
		return null; 
	}
	
}
