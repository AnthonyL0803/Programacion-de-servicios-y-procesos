package pruebas;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Invento;

public class ConsultaCompleja {
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
			// Construimos el invento 2
			Invento papelHigienico = new Invento();
			papelHigienico.setInvento("Papel higienico");
			papelHigienico.setInventor("Joseph Gayetty");
			papelHigienico.setFecha(1857);

			session.beginTransaction();

			session.persist(telar);
			session.persist(papelHigienico);

			session.getTransaction().commit();
			
            
            List<Invento> listaInventos = session.createQuery("from Invento", Invento.class).getResultList();
            
            for (Invento invento : listaInventos) {
				System.out.println(invento);
			}.L
            
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sf != null)
				sf.close();
		}
	}
}
