package colaDeCorreo;

import java.util.Random;

public class GeneradorDeContenido {
	private static final Random random = new Random();

	private final String[] nombres = { "Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Lucía" };
	private final String[] apellidos = { "García", "Martínez", "López", "Sánchez", "Ramírez", "Hernández", "Pérez",
			"Gómez" };
	private final String[] dominios = { "gmail.com", "yahoo.com", "hotmail.com", "outlook.com" };

	private final static String[] inicioAsunto = { "Recordatorio", "Actualización", "Invitación", "Aviso", "Resumen",
			"Confirmación", "Felicitaciones" };
	private final static String[] temaAsunto = { "de reunión", "de evento", "de proyecto", "de facturación", "de entrega",
			"de promoción", "de cambios" };
	private final static String[] detalleAsunto = { "importante", "urgente", "pendiente", "finalizado", "de este mes",
			"de esta semana", "actual" };
    private static final String[] saludos = {
            "Estimado", "Hola", "Buen día", "Querido", "Apreciado"
        };
        
        private static final String[] cuerpos = {
            "te recordamos que la reunión está programada para mañana.",
            "esperamos tu confirmación para el evento de esta semana.",
            "agradecemos tu interés en el proyecto y esperamos trabajar juntos.",
            "te enviamos la información solicitada en el correo anterior.",
            "queremos felicitarte por tu esfuerzo y dedicación."
        };
        
        private static final String[] despedidas = {
            "Saludos cordiales.", "Atentamente,", "Cordialmente,", "Un saludo,", "Gracias por tu atención."
        };

	public GeneradorDeContenido() {
		super();
	}

	public String generarDestinatario() {
		String nombre = nombres[random.nextInt(nombres.length)];
		String apellido = apellidos[random.nextInt(apellidos.length)];
		String dominio = dominios[random.nextInt(dominios.length)];

		return nombre.toLowerCase() + "." + apellido.toLowerCase() + "@" + dominio;
	}

	public String generarRemitente() {
		String nombre = nombres[random.nextInt(nombres.length)];
		String apellido = apellidos[random.nextInt(apellidos.length)];
		String dominio = dominios[random.nextInt(dominios.length)];
		
		return nombre.toLowerCase() + "." + apellido.toLowerCase() + "@" + dominio;
	}

	public String generarAsunto() {

		String inicio = inicioAsunto[random.nextInt(inicioAsunto.length)];
		String tema = temaAsunto[random.nextInt(temaAsunto.length)];
		String detalle = detalleAsunto[random.nextInt(detalleAsunto.length)];

		return inicio + " " + tema + " " + detalle;
	}
	
    public String generarCuerpoMensaje() {
        Random random = new Random();
        
        String saludo = saludos[random.nextInt(saludos.length)];
        String cuerpo = cuerpos[random.nextInt(cuerpos.length)];
        String despedida = despedidas[random.nextInt(despedidas.length)];
        
        return saludo + ",\n\n" + cuerpo + "\n\n" + despedida;
    }
}
