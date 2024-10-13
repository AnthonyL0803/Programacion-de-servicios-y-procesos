package segundaPrueba;

public class Procesador {
	private double velocidad;
	private String marca;
	private double precio;
	private int nucleos;
	
	
	public Procesador(double velocidad, String marca, double precio, int nucleos) {
		this.velocidad = velocidad;
		this.marca = marca;
		this.precio = precio;
		this.nucleos = nucleos;
	}

	public Procesador() {
		super();
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNucleos() {
		return nucleos;
	}

	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}

	@Override
	public String toString() {
		return "Procesador [velocidad=" + velocidad + ", marca=" + marca + ", precio=" + precio + ", nucleos=" + nucleos
				+ "]";
	}
    

}
