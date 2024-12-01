import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static final int PUERTO = 3000;
	public static final String IP_SERVER = "172.20.10.3";

	public static void main(String[] args) throws InterruptedException {
		System.out.println("         BIENVENIDO A PIEDRA, PAPEL, TIJERA       ");
		System.out.println("----------------------------------------------------------------");

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in)) {
			Socket socketAlServidor = new Socket();

			System.out.println("JUGADOR: Esperando a que el servidor acepte la conexion");
			socketAlServidor.connect(direccionServidor);
			System.out.println("JUGADOR: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

			InputStreamReader jugadorEncontrado = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader bfJugadorEncontrado = new BufferedReader(jugadorEncontrado);
			String resultado = bfJugadorEncontrado.readLine();
			System.out.println(resultado);
			boolean salir = true;
			while (salir) {
				System.out.println("Seleccione una opción: 1.Piedra | 2.Papel | 3.Tijera");
				int opcion = sc.nextInt();

				PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
				salida.println(opcion);

				InputStreamReader entradaResultado = new InputStreamReader(socketAlServidor.getInputStream());
				BufferedReader bfResultado = new BufferedReader(entradaResultado);
				String resultado2 = bfResultado.readLine();

				if (resultado2.contains("ganado") || resultado2.contains("perdido")) {
					System.out.println(resultado2);
					salir = false;
				} else {
					System.out.println(resultado2);
				}
			}
			PrintStream salida2 = new PrintStream(socketAlServidor.getOutputStream());
            // Recibir mensaje final del servidor
            String mensajeFinal = bfJugadorEncontrado.readLine();

            // Confirmar recepción del mensaje final
            salida2.println("Recibido");
			socketAlServidor.close();
			
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
