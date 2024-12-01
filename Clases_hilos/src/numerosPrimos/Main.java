package numerosPrimos;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Numero num1 = new Numero(sc.nextLong());
		num1.setName("Numero 1");
		Numero num2 = new Numero(sc.nextLong());
		num2.setName("Numero 2");
		Numero num3 = new Numero(sc.nextLong());
		num3.setName("Numero 3");
		
		num1.run();
		num2.run();
		num3.run();
	}
}
