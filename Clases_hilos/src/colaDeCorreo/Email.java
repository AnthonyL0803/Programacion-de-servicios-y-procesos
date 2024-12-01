package colaDeCorreo;

public class Email {
	private String id;
	private String destinatario;
	private String remitente;
	private String asunto;
	private String mensaje;
	
	public Email(String id, String destinatario, String remitente, String asunto, String mensaje) {
		super();
		this.id = id;
		this.destinatario = destinatario;
		this.remitente = remitente;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}
	

	public String getId() {
		return id;
	}

	public String getAsunto() {
		return asunto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Id: ").append(this.id).append("\n");
	    sb.append("Destinatario: ").append(this.destinatario).append("\n");
	    sb.append("Remitente: ").append(this.remitente).append("\n");
	    sb.append("Asunto: ").append(this.asunto).append("\n");
	    sb.append("Cuerpo: ").append(this.mensaje).append("\n");
	    return sb.toString();
	}
}
