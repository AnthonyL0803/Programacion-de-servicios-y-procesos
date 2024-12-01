package hilos_parte_ByC;

public class Funcionalidad2 extends Thread {
	private long numero;

	public Funcionalidad2(long numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());// Coge el nombre del hilo actual

		// Inicia el tiempo de procesamiento
		long tiempoInicio = System.currentTimeMillis();

		// Metemos el código para calcular si es primo o no
		for (long i = this.numero ; i < 1000000000; i++) {
			System.out.println(i);
		}
		// Finaliza el tiempo de procesamiento
		long tiempoFinal = System.currentTimeMillis();
		long duracion = tiempoFinal - tiempoInicio;
		
			System.out.println(
					"Hilo: " + Thread.currentThread().getName() + " ha tardado " + duracion);
		}
	}// El hilo muere en esta línea (sale del método run)
