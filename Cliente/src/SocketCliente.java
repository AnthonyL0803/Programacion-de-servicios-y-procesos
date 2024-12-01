

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	//IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 3000;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("        APLICACION CLIENTE         ");
		System.out.println("-----------------------------------");
		
		
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in);
			Socket socketAlServidor = new Socket()){

			System.out.println("CLIENTE: Introduzca dos numeros: ");
			String numero1 = sc.nextLine();
			String numero2 = sc.nextLine();
			System.out.println("CLIENTE: Introduzca el tipo operación que quiere realizar: ");
			System.out.println("1. Sumar | 2. Restar | 3. Multiplicar | 4. Dividir | 5.Salir");
			int opcion = sc.nextInt();
			String operacion = "";
			switch (opcion) {
			case 1: 
				operacion = "sumar";
				System.out.println("Usted ha seleccionado: " + operacion);
				break;
			case 2:
				operacion = "restar";
				System.out.println("Usted ha seleccionado: " + operacion);
				break;
			case 3:
				operacion = "multiplicar";
				System.out.println("Usted ha seleccionado: " + operacion);
				break;
			case 4:
				operacion = "dividir";
				System.out.println("Usted ha seleccionado: " + operacion);
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				System.exit(0);
				break;
			}
			String operandos = numero1 + "-" + numero2 + "-" + operacion;
			
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexion");
			socketAlServidor.connect(direccionServidor);			
			System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER 
					+ " por el puerto " + PUERTO);		

			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());

			salida.println(operandos);

			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());

			BufferedReader bf = new BufferedReader(entrada);
			
			System.out.println("CLIENTE: Esperando al resultado del servidor...");

			String resultado = bf.readLine();
				
			System.out.println("CLIENTE: El resultado de la operación es: " + resultado);
		
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		
		System.out.println("CLIENTE: Fin del programa");
	}
}
