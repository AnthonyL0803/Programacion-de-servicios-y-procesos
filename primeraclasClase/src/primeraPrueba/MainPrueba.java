package primeraPrueba;

import java.util.ArrayList;
import java.util.List;

/**
 * Java es un lenguaje de tipado fuerte en cambio te admite cosas como el var
 * 
 */
public class MainPrueba {
	public static void main(String[] args) {
		var cadena = "Esto es un String"; // inferencia de tipos (variable comodín)
		String cadena2 = "Esto es otra cadena";
		
		var persona1 = new Persona(); //Se puede poner también el nombre del objeto
		persona1 = null;
		System.gc(); //Comando para activar el garbagge collector manualmente (a veces)
		
		{
			 var persona2 = new Persona();
			 persona2.setNombre("Tony Stark");
		}
		
		long cp = 0b101;
		
		var persona = new Persona();
		Direccion d1 = new Direccion();
		persona.setDireccion(d1);
		persona.getDireccion().setPais("España"); //Si algún valor apunta a una referencia null lo que ocurre es que se genera la excepcion nullpointerexception
		persona.getDireccion().setPais("Francia");
		d1.setCp("28024");
		
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(persona);
		d1.setTipoVia("Calle");
		System.out.println(listaPersonas.get(0).getDireccion().getTipoVia());
		var persona3 = new Persona();
		persona3.setNombre("Thor");
		listaPersonas.add(persona3);
		System.out.println(listaPersonas.get(0).getNombre());
		listaPersonas.get(0).setDireccion(new Direccion());
		d1.getTipoVia();
		
	}
}
