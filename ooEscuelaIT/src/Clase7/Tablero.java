package Clase7;

import clase5.GestorIO;

public class Tablero {

	private char[][] casillas;

	private static final int DIMENSION = 3;
	private static final char VACIA = '_';

	public Tablero() {
		casillas = new char[DIMENSION]DIMENSION];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = VACIA;
			}
		}
	}

	public void mostrar() {
		GestorIO gestor = new GestorIO();

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				gestor.out(" " + casillas[i][j]);
			}
			gestor.out("\n");
		}
	}

	public boolean hayTresRaya() {
		return this.hayTresRaya('x') || this.hayTresRaya('o');
	}

	private boolean hayTresRaya(char color) {

		// aplicamos el algoritmo correspondiente
		char[] filas = new char[DIMENSION];
		char[] columnas = new char[DIMENSION];

		int diagonal = 0;
		int secundaria = 0;

		// con esto cuento cuantas fichas hay
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (color == casillas[i][j]) {
					filas[i]++;
					columnas[j]++;
					if (i == j) {
						diagonal++;
					}
					if (i + j == 2) {
						secundaria++;
					}
				}
			}
		}

		// una vez que salgo de contar todo
		if (diagonal == DIMENSION || secundaria == DIMENSION) {
			return true;
		} else {
			for (int i = 0; i < DIMENSION; i++) {
				if (filas[i] == DIMENSION || columnas[i] == DIMENSION) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean estaCompleto(Jugador jugador) {
		int fichas = 0;

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (jugador.color() == casillas[i][j]) {
					fichas++;
				}
			}
		}

		return fichas == 3;
	}

	public boolean ocupada(Coordenada coordenada, char color) {
		assert coordenada != null;
		return casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] == color;
	}

	public boolean ocupada(Coordenada coordenada) {
		return !this.ocupada(coordenada, VACIA);
	}

	public void ponerFicha(Coordenada coordenada, char color) {
		assert coordenada != null;
		casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = color;
	}

	public void retirarFicha(Coordenada coordenada) {
		assert coordenada != null;
		assert this.ocupada(coordenada);
		this.ponerFicha(coordenada, VACIA);
	}

	public static void main(String[] args) {
		GestorIO gestor = new GestorIO();
		Coordenada [][] coleccionesCoordenada = new Coordenada[][] {
			{new Coordenada(1,1), new Coordenada(2,1), new Coordenada(3,1)},
			{new Coordenada(1,2), new Coordenada(2,2), new Coordenada(3,2)},
			{new Coordenada(1,3), new Coordenada(2,3), new Coordenada(3,3)},
		}
	}

}
