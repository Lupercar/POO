package clase5;

import java.util.Scanner;

public class GestorIO {

	public void out(String string) {
		System.out.print(string);
	}

	public double inDouble() {
		return new Scanner(System.in).nextDouble(); 
	}

}
