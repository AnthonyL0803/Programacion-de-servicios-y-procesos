package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	public static final int PUERTO = 3000;
	public static final String IP_SERVER = "172.20.10.3";

	public static void main(String[] args) {
		// Varaibles
		int opcion;
		String numero1;
		String numero2;

		System.out.println("       APLICACIÓN CLIENTE    ");
		System.out.println("-----------------------------");

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in); Socket socketAlServidor = new Socket()) {

			// Pedimos al usuario los numeros
			System.out.println("Introduce los números para la operación: ");
			numero1 = sc.nextLine();
			numero2 = sc.nextLine();

			// Pedimos al usuarios tipo de la operación
			System.out.println("Dime que operación desea realizar: ");
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("5. Salir");
			opcion = sc.nextInt();

			String operacion = numero1 + "-" + numero2 + "-" + opcion; // Texto plano
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
			socketAlServidor.connect(direccionServidor);
			System.out.println("CLIENTE: Conexión establecida.. a " + IP_SERVER + " por el puerto " + PUERTO);

			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			salida.println(operacion);

			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader lector = new BufferedReader(entrada);

			System.out.println("CLIENTE: Esperando al resultado del servidor.....");
			String resultado = "";
			resultado = lector.readLine();

			switch (opcion) {
			case 1: {

				System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
				break;
			}
			case 2: {

				System.out.println("CLIENTE: El resultado de la resta es: " + resultado);
				break;
			}
			case 3: {

				System.out.println("CLIENTE: El resultado de la multiplicación es: " + resultado);
				break;
			}
			case 4: {

				System.out.println("CLIENTE: El resultado de la division es: " + resultado);
				break;
			}
			case 5: {
				System.out.println("Enhorabuena has salido del programa");
				break;
			}

			default:
				System.out.println("La opcion elegida no es válida. ");
				break;
			}

		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		System.out.println("CLIENTE: Fin del programa");
	}
}
