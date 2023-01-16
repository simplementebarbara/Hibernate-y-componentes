package p2t2hibernate_ferreteria;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class P2T2Hibernate_ferreteria {

    public static void main(String[] args) {
        try (
                //SessionFactory instancia = (SessionFactory) HibernateUtil.buildSessionFactory();
                //Sesiones. Factory crea la sesión conforme al fichero de configuración de hibernate
                //Session. Crea la sesión de conexión a la base de datos
                
             
            SessionFactory instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory()) {
            Session session = instancia.openSession();
            System.out.println("Creamos objetos");
            //Creamos objetos
            //Clientes c = new Clientes(207, "Juan Benitez", "C/ Corralito", "670908070");
            //Proveedores p = new Proveedores(204, "Juan Benitez", "C/ Corralito", "670908070");
            Categorias cat = new Categorias (4, "Herramientas de fontaneria", "Mangueras, tubos..");
            //Transacciones. Insertamos objeto en la tabla
            session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
            System.out.println("Registro insertado");
            session.close();
        } catch (HibernateException he) {
            System.out.println(he);
        } finally {

        }

    }

}
