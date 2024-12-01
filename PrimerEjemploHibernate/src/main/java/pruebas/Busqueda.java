package pruebas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Invento;

public class Busqueda {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		try {
			sf = new Configuration().configure().buildSessionFactory();

			session = sf.openSession();

			// Construimos el invento 1
			Invento telar = new Invento();
			telar.setInvento("Telar Mecánico");
			telar.setInventor("Edmund Cartwright");
			telar.setFecha(1743);
			//Construimos el invento 2
			Invento papelHigienico = new Invento();
			papelHigienico.setInvento("Papel higienico");
			papelHigienico.setInventor("Joseph Gayetty");
			papelHigienico.setFecha(1857);
			
			session.beginTransaction();
			
			session.persist(telar);
			session.persist(papelHigienico);
			
			session.getTransaction().commit();
			
			System.out.println(session.find(Invento.class, "Telar Mecánico"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
			if (sf != null) sf.close();
		}

	}
}
