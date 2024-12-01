package pruebas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Invento;

public class BorradoCompleto {
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

			session.beginTransaction();

			LinkedList lista = new LinkedList<>();
			lista.add(papelHigienico);
			lista.add(telar);
			
			for (int i = 0; i < lista.size(); i++) {
				Invento invento = 	(Invento) lista.get(i);
				session.remove(invento);
			}
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
