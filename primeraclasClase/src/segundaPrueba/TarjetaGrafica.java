package segundaPrueba;

public class TarjetaGrafica {
	private String marca;
	private String modelo;
	private double precio;
	private RAM ram;

	public TarjetaGrafica(String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.ram = new RAM(100, 8, 5600, "GB");
	}
	
	public TarjetaGrafica() {
		super();
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void calcularPrecioTotal() {
		this.precio += this.ram.getPrecio();
	}

	@Override
	public String toString() {
		return "TarjetaGrafica [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", ram=" + ram + "]";
	}
	
}
