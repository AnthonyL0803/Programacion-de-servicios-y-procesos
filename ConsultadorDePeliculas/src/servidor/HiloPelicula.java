package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;

public class HiloPelicula implements Runnable {
	private Thread hilo;
	private static int numConsulta;
	private Socket socketAlCliente;

	public HiloPelicula(Socket socketAlCliente) {
		numConsulta++;
		this.socketAlCliente = socketAlCliente;
		hilo = new Thread(this, "Consulta número: " + numConsulta);
		hilo.start();
	}
	
	public void run() {
		System.out.println("Estableciendo comunicación con " + hilo.getName());
//Clase necesaria para enviar datos al cliente
		PrintStream salida = null;
//Clases necesarias para recibir los datos del cliente
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;
		
		DAOPeliculas daopeliculas = new DAOPeliculas();
		
		String textoRecibido = "";
		boolean continuar = true;

		try {
			salida = new PrintStream(socketAlCliente.getOutputStream());

			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			entradaBuffer = new BufferedReader(entrada);

			while (continuar) {
				textoRecibido = entradaBuffer.readLine();
				String[] textoRecibidoProcesado;
				if (textoRecibido.trim().equalsIgnoreCase("FIN")) {
					salida.println("OK");
					System.out.println(hilo.getName() + " ha cerrado la comunicacion");
					continuar = false;
				} else {
					textoRecibidoProcesado = textoRecibido.split("-");
					int opcion = Integer.parseInt(textoRecibidoProcesado[0]);
					if(opcion == 1) {
						int id = Integer.parseInt(textoRecibidoProcesado[1]);
						String respuesta = daopeliculas.consultarPeliculaID(id);
						salida.println(respuesta.toString().toLowerCase());
					}
					if(opcion == 2) {
						String respuesta = daopeliculas.consultarPeliculaTitulo(textoRecibidoProcesado[1].toUpperCase());
						salida.println(respuesta.toString().toLowerCase());
					}
					if(opcion == 3) {
						String respuesta = daopeliculas.consultarPeliculaDirector(textoRecibidoProcesado[1].toUpperCase());
						salida.println(respuesta.toString().toLowerCase());
					}
					if(opcion == 4) {
						int id = Integer.parseInt(textoRecibidoProcesado[1]);
						double precio = Double.parseDouble(textoRecibidoProcesado[4]);
						Pelicula pelicula = new Pelicula(id, textoRecibidoProcesado[2].toUpperCase(), textoRecibidoProcesado[3].toUpperCase(), precio);
						System.out.println(pelicula);
						daopeliculas.insertarPelicula(pelicula);
						salida.println("La película se ha agregado con éxito.");
					}
					if(opcion == 5) {
						daopeliculas.limpiarTabla();
						salida.println("Las películas se han borrado correctamente");
					}
				}
			}
			socketAlCliente.close();
		} catch (IOException e) {
		    salida.println("Error de comunicación con el servidor.");
		    e.printStackTrace();
		} catch (SQLException e) {
		    salida.println("Error al acceder a la base de datos.");
		    e.printStackTrace();
		} catch (Exception e) {
		    salida.println("Error inesperado.");
		    e.printStackTrace();
		}
	}
}
