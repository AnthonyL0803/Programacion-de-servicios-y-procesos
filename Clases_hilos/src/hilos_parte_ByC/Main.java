package hilos_parte_ByC;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String palabra = sc.nextLine();
			long num1 = sc.nextLong();
			long num2 = sc.nextLong();
			
			Funcionalidad1 f1 = new Funcionalidad1(num1);
			Thread t1 = new Thread(f1);
			t1.setName("funcionalidad 1");
			
			Funcionalidad2 f2 = new Funcionalidad2(num2);
			f2.setName("Funcionalidad 2");
			
			Funcionalidad3 f3= new Funcionalidad3(palabra, num1, num2);
			Thread t3 = new Thread(f3);
			
			t3.setName("Funcionalidad 3");
			
			t1.start();
			f2.start();
			t3.start();
			
			
			
	}
}
