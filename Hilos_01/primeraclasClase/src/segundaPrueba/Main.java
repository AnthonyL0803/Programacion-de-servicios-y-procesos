package segundaPrueba;

public class Main {
	public static void main(String[] args) {
		Ordenador ord1 = new Ordenador();
		ord1.añadirComponentes();
		System.out.println(ord1.toString());
		System.out.println("El ordenador cuesta en total: " + ord1.calcularPrecioTotal() + "$");
	}
}
