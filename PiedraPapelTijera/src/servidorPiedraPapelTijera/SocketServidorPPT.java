package servidorPiedraPapelTijera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidorPPT {
	public static final int PUERTO = 3000;

	public static void main(String[] args) throws IOException {
		System.out.println("     APLICACIÓN DE SERVIDOR     ");
		System.out.println("--------------------------------");

		InputStreamReader entradaJugador1 = null;
		InputStreamReader entradaJugador2 = null;
		PrintStream salidaJugador1 = null;
		PrintStream salidaJugador2 = null;

		Socket socketJugador1 = null;
		Socket socketJugador2 = null;
		InetSocketAddress direccion = new InetSocketAddress(PUERTO); // Define el puerto del que va a escuchar

		try (ServerSocket serverSocket = new ServerSocket()) {
			serverSocket.bind(direccion);
			int peticion = 0;

			System.out.println("SERVIDOR: Servidor iniciado. Esperando petición por el puerto " + PUERTO
					+ "Esperando jugadores...");
			socketJugador1 = serverSocket.accept();
			System.out.println("SERVIDOR: Jugador 1 conectado.");
			socketJugador2 = serverSocket.accept();
			System.out.println("SERVIDOR: Jugador 2 conectado.");

			salidaJugador1 = new PrintStream(socketJugador1.getOutputStream());
			salidaJugador2 = new PrintStream(socketJugador2.getOutputStream());

			salidaJugador1.println("Oponente encontrado.");
			salidaJugador2.println("Oponente encontrado.");

			entradaJugador1 = new InputStreamReader(socketJugador1.getInputStream());
			entradaJugador2 = new InputStreamReader(socketJugador2.getInputStream());
			BufferedReader lector = new BufferedReader(entradaJugador1);
			BufferedReader lector2 = new BufferedReader(entradaJugador2);

			int puntosJugador1 = 0;
			int puntosJugador2 = 0;

			while (puntosJugador1 < 3 && puntosJugador2 < 3) {
				String stringRecibido = lector.readLine();
				String stringRecibido2 = lector2.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido2);

				// Convertir las entradas a números
				int numero = Integer.parseInt(stringRecibido); // Jugador 1
				int numero2 = Integer.parseInt(stringRecibido2); // Jugador 2

				String ronda = "Ronda: ";

				// Determinar el resultado de la ronda
				switch (numero) {
				case 1: // Piedra
					if (numero2 == 2) { // Papel gana a Piedra
						puntosJugador2++;
						salidaJugador1.println(ronda
								+ "Jugador 1: Piedra < Jugador 2: Papel - Jugador 2 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(ronda
								+ "Jugador 1: Piedra < Jugador 2: Papel - Jugador 2 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					} else if (numero2 == 3) { // Piedra gana a Tijera
						puntosJugador1++;
						salidaJugador1.println(ronda
								+ "Jugador 1: Piedra > Jugador 2: Tijera - Jugador 1 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(ronda
								+ "Jugador 1: Piedra > Jugador 2: Tijera - Jugador 1 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					} else { // Empate
						salidaJugador1.println(
								ronda + "Jugador 1: Piedra = Jugador 2: Piedra - Empate. Puntuación: Jugador 1: "
										+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(
								ronda + "Jugador 1: Piedra = Jugador 2: Piedra - Empate. Puntuación: Jugador 1: "
										+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					}
					break;

				case 2: // Papel
					if (numero2 == 3) { // Tijera gana a Papel
						puntosJugador2++;
						salidaJugador1.println(ronda
								+ "Jugador 1: Papel < Jugador 2: Tijera - Jugador 2 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(ronda
								+ "Jugador 1: Papel < Jugador 2: Tijera - Jugador 2 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					} else if (numero2 == 1) { // Papel gana a Piedra
						puntosJugador1++;
						salidaJugador1.println(ronda
								+ "Jugador 1: Papel > Jugador 2: Piedra - Jugador 1 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(ronda
								+ "Jugador 1: Papel > Jugador 2: Piedra - Jugador 1 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					} else { // Empate
						salidaJugador1
								.println(ronda + "Jugador 1: Papel = Jugador 2: Papel - Empate. Puntuación: Jugador 1: "
										+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2
								.println(ronda + "Jugador 1: Papel = Jugador 2: Papel - Empate. Puntuación: Jugador 1: "
										+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					}
					break;

				case 3: // Tijera
					if (numero2 == 1) { // Piedra gana a Tijera
						puntosJugador2++;
						salidaJugador1.println(ronda
								+ "Jugador 1: Tijera < Jugador 2: Piedra - Jugador 2 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(ronda
								+ "Jugador 1: Tijera < Jugador 2: Piedra - Jugador 2 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					} else if (numero2 == 2) { // Tijera gana a Papel
						puntosJugador1++;
						salidaJugador1.println(ronda
								+ "Jugador 1: Tijera > Jugador 2: Papel - Jugador 1 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(ronda
								+ "Jugador 1: Tijera > Jugador 2: Papel - Jugador 1 gana esta ronda. Puntuación: Jugador 1: "
								+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					} else { // Empate
						salidaJugador1.println(
								ronda + "Jugador 1: Tijera = Jugador 2: Tijera - Empate. Puntuación: Jugador 1: "
										+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
						salidaJugador2.println(
								ronda + "Jugador 1: Tijera = Jugador 2: Tijera - Empate. Puntuación: Jugador 1: "
										+ puntosJugador1 + ", Jugador 2: " + puntosJugador2);
					}
					break;

				default:
					salidaJugador1.println("La opción elegida por Jugador 1 no es válida.");
					salidaJugador2.println("La opción elegida por Jugador 1 no es válida.");
					break;
				}
			}
			// Resultado final
			if (puntosJugador1 == 3) {
				salidaJugador1.println("Ha ganado el jugador 1");
				salidaJugador2.println("Ha perdido el jugador 2");

			} else {
				salidaJugador2.println("Ha ganado el jugador 2");
				salidaJugador1.println("Ha perdido el jugador 1");
			}

			salidaJugador1.println("Fin de la partida. Adiós.");
			salidaJugador2.println("Fin de la partida. Adiós.");
			lector.readLine(); // Esperar confirmación del jugador 1
			lector2.readLine(); // Esperar confirmación del jugador 2

		} catch (IOException e) {
			System.out.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}
}
