package colaDeCorreo;

import java.util.LinkedList;

public class AlmacenDeCartas {
	private static final int MAX_ELEMENTOS = 5;
	private LinkedList<Email> emails;

	public AlmacenDeCartas() {
		super();
		this.emails = new LinkedList<Email>();
	}

	public synchronized void addEmail(Email email) {

		if (email.getDestinatario().equals("pikachu@gmail.com")) {
			System.out.println(
					"Emails con destinatario " + email.getDestinatario() + " no se pueden almacenar en el buzon.");
			return;
		}
		while (emails.size() == MAX_ELEMENTOS) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		emails.offer(email);
		notifyAll();
	}

	public synchronized Email getEmail() {
		
		while (emails.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		Email email = emails.poll();
		System.out.println(email.toString());
		notifyAll();
		return email;
		}
}
