package servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private static final int puerto = 3000;

	public static void main(String[] args) {
		System.out.println("      APLICACI�N DE SERVIDOR CON HILOS     ");
		System.out.println("-------------------------------------------");		
		
		int peticion = 0;
		
		//Primero creamos el socket servidor el cual habilita el servidor.
		try(ServerSocket serverSocket = new ServerSocket()){
			
			//Luego habilitamos el puerto desde el que se va a escuchar y posteriormente se conecta con el socket del servidor.
			InetSocketAddress puertoDireccion = new InetSocketAddress(puerto);
			serverSocket.bind(puertoDireccion);
			
			System.out.println("SERVIDOR: Esperando peticion por el puerto " + puerto);

			//Aquí creamos un bucle infinito para que pueda mantenerse conectado y así recibir peticiones constantemente
			while(true) {
				//Aquí llega cada una de las peticiones y por cada petición se crea un socket diferente
				Socket socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				
				//Por cada socket de cliente que se cree se le crea aparte un hilo en la clase HiloPelicula para que se le gestionen las peticiones
				new HiloPelicula(socketAlCliente);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
