package Clase7;

public class TresEnRaya {

	private Tablero tablero; 
	private Jugador[] jugadores; 
	private Turno turno; //tenemos un solo turno
	
	public TresEnRaya() {
		tablero = new Tablero(); 
		jugadores = new Jugador[2]; 
		jugadores[0] = new Jugador('x'); 
		jugadores[1] = new Jugador('o'); 
		turno = new Turno(); 
	}
	
	public void jugar() {
		
		do {
			tablero.mostrar(); 
			
			if(tablero.estaCompleto(jugadores[turno.toca()])) {
				jugadores[turno.toca()].moverFicha(tablero);
			}else {
				jugadores[turno.toca()].ponerFicha(tablero); 
			}
			 
			turno.cambiar(); 
		}while(!tablero.hayTresRaya()); 
		
		//gana el ultimo que ha puesto, el que no le toca poner
		jugadores[turno.noToca()].cantaVictoria(); 
	}
	
	public static void main(String[] args) {
		new TresEnRaya().jugar();
	}
}
