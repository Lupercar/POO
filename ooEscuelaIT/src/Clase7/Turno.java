package Clase7;

import java.util.Random;

import clase5.GestorIO;

public class Turno {

	private int valor; 
	
	public Turno() {
		//se inicia de forma aleatoria
//		valor = (int) (Math.random()*2); 
		valor = new Random().nextInt(2); 
	}
	
	public int toca() {
		return valor;
	}

	public int noToca() {
		return (valor+1)%2;
	}

	public void cambiar() {
		valor = this.noToca(); 
	}

	public static void main(String[] args) {
		//vamos a hacer una chapusilla
		Turno nuevoTurno = new Turno();
		GestorIO gestor = new GestorIO();
		
		gestor.out("Toca " + nuevoTurno.toca());
		gestor.out("\nNo Toca " + nuevoTurno.noToca());
		
		nuevoTurno.cambiar();
		
		gestor.out("\n\nToca " + nuevoTurno.toca());
		gestor.out("\nNo Toca " + nuevoTurno.noToca());
	}
}
