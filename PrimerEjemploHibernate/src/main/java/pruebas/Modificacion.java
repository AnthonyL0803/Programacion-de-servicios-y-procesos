package pruebas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Invento;

public class Modificacion {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		try {
			sf = new Configuration().configure().buildSessionFactory();

			session = sf.openSession();

			// Construimos el invento 1
			Invento MaquinaVapor = new Invento();
			MaquinaVapor.setInvento("Máquina de vapor");
			MaquinaVapor.setInventor("James Watt");
			MaquinaVapor.setFecha(1765);
			
			session.beginTransaction();
			
			session.persist(MaquinaVapor);
			session.getTransaction().commit();
			
			//Modificamos datos
			MaquinaVapor.setInventor("HERON");
			MaquinaVapor.setFecha(0);
			session.beginTransaction();
			session.merge(MaquinaVapor);
			session.getTransaction().commit();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
			if (sf != null) sf.close();
		}
	}

}
