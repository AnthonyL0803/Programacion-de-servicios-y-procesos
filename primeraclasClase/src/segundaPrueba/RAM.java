package segundaPrueba;

public class RAM {
	private double precio;
	private int capacidad;
	private double frecuencia;
	private String unidad;
	
	public RAM(double precio, int capacidad, double frecuencia, String unidad) {
		this.precio = precio;
		this.capacidad = capacidad;
		this.frecuencia = frecuencia;
		this.unidad = unidad;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public double getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "RAM [precio=" + precio + ", capacidad=" + capacidad + ", frecuencia=" + frecuencia + ", unidad="
				+ unidad + "]";
	}

}
