package colaDeCorreo;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		AlmacenDeCartas almacen = new AlmacenDeCartas();
		GeneradorDeContenido generador = new GeneradorDeContenido();
		
		Productor productor1 = new Productor("Productor 1", almacen, generador);
		Productor productor2 = new Productor("Productor 2", almacen, generador);
		Productor productor3 = new Productor("Productor 3", almacen, generador);

		Consumidor consumidor1 = new Consumidor("Consumidor 1", almacen);
		Consumidor consumidor2 = new Consumidor("Consumidor 2", almacen);

		productor1.start();
		productor2.start();
		productor3.start();
		
		consumidor1.start();
		consumidor2.start();
	}
}
