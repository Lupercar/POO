package Clase7;

import clase5.GestorIO;

public class Jugador {
	
	private char color; 
	
	public Jugador(char color) {
		this.color = color; 
	}
	
	//esto seria getColor()
	public char color() {
		return color;
	}

	public void ponerFicha(Tablero tablero) {
		//tengo que vigilar que el usuario no me ponga gilipolleses
		//pedimos la posición al actor a la persona que juega
//		int fila; 
//		int columna; 
//		
//		GestorIO gestor = new GestorIO(); 
//		gestor.out("Dame ");
//		 ASI NO, en este caso necesito una coordenada por tanto me creo una clase, soy un jugado 
//		nada de fila y columna
		Coordenada coordenada = new Coordenada(); 
		do {
			coordenada.recoger(); 
		}while(!coordenada.valida() || tablero.ocupada(coordenada) ); 
		
		//soy JUGADOR tengo acceso al color y al tablero, me creo un metodo en el tablero para poner 
		tablero.ponerFicha(coordenada, color); 
	} 

	public void moverFicha(Tablero tablero) {
		// TODO Auto-generated method stub
		//muy parecido al metodo ponerFicha()
		
	}

	public void cantaVictoria() {
		new GestorIO().out("eoeoeoeoeoeoeoeoeo! las " + color + " son los mejores. ");
	}

	
}
