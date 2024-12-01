package segundaPrueba;

import java.util.ArrayList;
import java.util.List;

public class Ordenador {
	private String marca;
	private String modelo;
	private Procesador procesador;
	private TarjetaGrafica tarjetagrafica;
	List<RAM> listaRAM;
	List<Periferico> listaPeriferico;

	public Ordenador() {
		super();
		this.marca = "ASUS";
		this.modelo = "ASUS TUF GAMING A15";
		this.procesador = new Procesador(475, "AMD", 275, 8);
		this.tarjetagrafica = new TarjetaGrafica("Nvidia", "3060GTX", 400);
		this.listaPeriferico = new ArrayList<>();
		this.listaRAM = new ArrayList<>();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public TarjetaGrafica getTarjetagrafica() {
		return tarjetagrafica;
	}

	public void setTarjetagrafica(TarjetaGrafica tarjetagrafica) {
		this.tarjetagrafica = tarjetagrafica;
	}

	public void añadirComponentes() {
		listaRAM.add(new RAM(120, 16, 6000, "GB"));
		listaRAM.add(new RAM(120, 16, 6000, "GB"));
		listaPeriferico.add(new Periferico(100, "Forgeon", "Teclado"));
		listaPeriferico.add(new Periferico(25, "Razer", "Raton"));
		listaPeriferico.add(new Periferico(70, "Sony", "Camara"));
	}

	public double calcularPrecioTotal() {
		double precioT = 0;
		precioT = this.procesador.getPrecio() + this.tarjetagrafica.getPrecio() + listaRAM.get(0).getPrecio()
				+ listaRAM.get(1).getPrecio() + listaPeriferico.get(0).getPrecio() + listaPeriferico.get(1).getPrecio()
				+ listaPeriferico.get(2).getPrecio();
		return precioT;
	}

	@Override
	public String toString() {
		return "Ordenador [marca=" + marca + ", modelo=" + modelo + ", procesador=" + procesador + ", tarjetagrafica="
				+ tarjetagrafica + ", listaRAM=" + listaRAM + ", listaPeriferico=" + listaPeriferico + ", getMarca()="
				+ getMarca() + ", getModelo()=" + getModelo() + ", getProcesador()=" + getProcesador()
				+ ", getTarjetagrafica()=" + getTarjetagrafica() + ", calcularPrecioTotal()=" + calcularPrecioTotal()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
