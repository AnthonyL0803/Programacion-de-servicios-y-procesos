package numerosPrimos;

public class Numero extends Thread{
		private long numero;

		public Numero(long numero) {
			super();
			this.numero = numero;
		}
		
		@Override
		public void run() {
			System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
			boolean esPrimo = true;
				for (long j = 2; j < numero; j++) {
				    if (numero % j == 0) {
				        esPrimo = false;
				    } 
				}
				if (esPrimo) {
					System.out
					.println(Thread.currentThread().getName() + " ha tardado " + ((System.currentTimeMillis()%60000)/1000) + " segundos" + " en terminar de calcular" );	
				}
			}
		}
