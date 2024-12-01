package hilos_parte_ByC;

public class Funcionalidad1 implements Runnable {
	private long numero;

	public Funcionalidad1(long numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());// Coge el nombre del hilo actual

		// Inicia el tiempo de procesamiento
		long tiempoInicio = System.currentTimeMillis();

		// Metemos el código para calcular si es primo o no
		boolean NumeroEsPrimo = true;
		for (long i = 2; i < numero; i++) {
			if (numero % i == 0) {
				NumeroEsPrimo = false;
			}
		}
		// Finaliza el tiempo de procesamiento
		long tiempoFinal = System.currentTimeMillis();
		long duracion = tiempoFinal - tiempoInicio;

		if (NumeroEsPrimo) {
			System.out.println("Hilo: " + Thread.currentThread().getName() + " el numero procesador es: " + this.numero
					+ " , tarda " + duracion + " milisegundos" + " y es numero primo");
		} else {
			System.out.println(
					"Hilo: " + Thread.currentThread().getName() + " ,el numero del hilo calculado no es numero primo");
		}

		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
	}// El hilo muere en esta línea (sale del método run)
}
