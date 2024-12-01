package colaDeCorreo;

import java.util.Iterator;

public class Productor extends Thread {
	private String nombre;
	private AlmacenDeCartas almacen;
	private GeneradorDeContenido generador;

	public Productor(String nombre, AlmacenDeCartas almacen, GeneradorDeContenido generador) {
		super();
		this.nombre = nombre;
		this.almacen = almacen;
		this.generador = generador;
	}

	public void run() {
		for (int i = 0; i <= 10; i++) {
			String id = this.nombre + " - " + i;
			if (i != 5) {
			almacen.addEmail(new Email(id, generador.generarDestinatario(), generador.generarRemitente(),
					generador.generarAsunto(), generador.generarCuerpoMensaje()));
			} else {
				almacen.addEmail(new Email(id, "pikachu@gmail.com", generador.generarRemitente(),
					generador.generarAsunto(), generador.generarCuerpoMensaje()));
			}
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
