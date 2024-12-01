package numerosPrimos;

public class Numero extends Thread{
		private long numero;

		public Numero(long numero) {
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
				System.out.println("Hilo: " + Thread.currentThread().getName() + " el numero procesado es: " + this.numero
						+ " , tarda " + duracion + " milisegundos" + " y es numero primo");
			} else {
				System.out.println(
						"Hilo: " + Thread.currentThread().getName() + " ,el numero del hilo calculado no es numero primo");
			}

			System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		}
		}
