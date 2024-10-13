package segundaPrueba;

public class Periferico {
		private double precio;
		private String marca;
		private String nombre;
		
		public Periferico(double precio, String marca, String nombre) {
			super();
			this.precio = precio;
			this.marca = marca;
			this.nombre = nombre;
		}
		
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public String toString() {
			return "Periferico [precio=" + precio + ", marca=" + marca + ", nombre=" + nombre + "]";
		}
		
}
