package colaDeCorreo;

public class Consumidor extends Thread {
	private String nombre;
	private AlmacenDeCartas almacen;

	public Consumidor(String nombre, AlmacenDeCartas almacen) {
		super();
		this.nombre = nombre;
		this.almacen = almacen;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			Email email = almacen.getEmail();
			System.out.println("Ha sido enviado por el Consumidor: " + this.nombre);
			System.out.println("--------------------------------------");
		}
	}
}
