package hilos_parte_ByC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Funcionalidad3 implements Runnable{
	private String palabra;
	private long num1;
	private long num2;

	public Funcionalidad3(String palabra, long num1, long num2) {
		super();
		this.palabra = palabra;
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());// Coge el nombre del hilo actual

		// Inicia el tiempo de procesamiento
		long tiempoInicio = System.currentTimeMillis();

		// Metemos el código para calcular si es primo o no
		long resultado = this.num1 - this.num2;
		for (long i = 0 ; i < resultado ; i++) {
			System.out.println(this.palabra);
		}
		// Finaliza el tiempo de procesamiento
		long tiempoFinal = System.currentTimeMillis();
		long duracion = tiempoFinal - tiempoInicio;
		
			System.out.println(
					"Hilo: " + Thread.currentThread().getName() + " ha tardado " + duracion);
		}
	}
