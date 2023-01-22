package Modelo;

import Modelo.Productos;
import Modelo.Clientes;
import Modelo.Categorias;
import Modelo.Facturas;
import Modelo.LineasFacturas;
import Modelo.Proveedores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Clase la cual se encarga de la creacion y configuracion de una sesion de
 * Hibernate y una transaccion
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class FerreteriaFactory {

    /**
     * Constructor privado de la clase
     */
    private FerreteriaFactory() {
    }

    private static Session session;
    private static Transaction transaction;

    /**
     * Metodo que construye una sesion nueva en caso de no existir
     *
     *
     * @return session existente
     */
    public static Session getSession() {
        if (session == null) {
            build();
        }
        return session;
    }

    /**
     * Metodo el cual construye una sesion nueva utilizando el archivo de
     * configuracion hibernate.cfg.xml y agregando las clases existentes.
     */
    private static void build() {
        try {

            SessionFactory instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Proveedores.class)
                    .addAnnotatedClass(Productos.class)
                    .addAnnotatedClass(Categorias.class)
                    .addAnnotatedClass(Facturas.class)
                    .addAnnotatedClass(Clientes.class)
                    .addAnnotatedClass(LineasFacturas.class)
                    .buildSessionFactory();
            session = instancia.openSession();
        } catch (Exception ex) {
            System.out.println("p2t2hibernate_ferreteria.FerreteriaFactory.build()" + ex);
        }

    }

    /**
     * Metodo el cual cierra la sesion existente.
     */
    public static void close() {
        session.close();
    }

}
