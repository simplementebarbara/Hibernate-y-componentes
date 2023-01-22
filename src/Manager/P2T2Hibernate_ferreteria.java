package Manager;

import Modelo.Productos;
import Modelo.Clientes;
import Modelo.Categorias;
import Modelo.Facturas;
import Modelo.Proveedores;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class P2T2Hibernate_ferreteria {

    public static void main(String[] args) {

        try {
            //SessionFactory instancia = (SessionFactory) HibernateUtil.buildSessionFactory();
            //Sesiones. Factory crea la sesión conforme al fichero de configuración de hibernate
            //Session. Crea la sesión de conexión a la base de datos

            SessionFactory instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Proveedores.class)
                    .addAnnotatedClass(Productos.class)
                    .addAnnotatedClass(Categorias.class)
                    .addAnnotatedClass(Facturas.class)
                    .addAnnotatedClass(Clientes.class)
                    .buildSessionFactory();
            Session session = instancia.openSession();
            System.out.println("-------- Inserción de objetos -------- ");
            /*
                
            //INSERCION DE OBJETOS POR CADA RELACION ENTRE TABLAS
            
            //Relacion Proveedores-Categoria-Productos
           System.out.println("---- Inserción Relacion Proveedores-Categoria-Productos ----- " );
            Proveedores prov = new Proveedores(209, "Juan Benitez", "C/ Corralito", "670908070");
            Categorias cat = new Categorias(9, "Herramientas de fontaneria", "Mangueras, tubos..");
            Productos prod = new Productos(108, "Tornillos cuadrados", "18", cat, prov, 9);
            prov.setProductos(prod);
            cat.setProductos(prod);
            session.beginTransaction();
            session.save(cat);
            session.save(prov);
            session.save(prod);  
            session.getTransaction().commit();
            System.out.println("Registro insertado en 'productos' y 'proveedores" + prov.toString());
            System.out.println("Registro insertado en 'productos' y 'categorias" + cat.toString());
            
            //Relacion Clientes-Facturas
            System.out.println("---- Inserción Relacion Clientes-Facturas ----- " );
            Clientes cliente = new Clientes(209, "Juana de Arcos", "C/Castilla", "670908070");
            
            //Para fechas se puede usar Date o GregorianCalendar
            Date mifecha = new Date(2009, 6, 4); //año,mes,dia
            // opcion es transformar la fecha de Java a MYSQL
            java.sql.Date date2 = new java.sql.Date(mifecha.getTime());
            Facturas factura = new Facturas(3013, 10,date2,cliente);
            cliente.setFacturas(factura);
            session.beginTransaction();
            session.save(cliente);  
            session.save(factura);
            session.getTransaction().commit();
            System.out.println("Registro insertado en 'cliente' y 'facturas" + cliente.toString());
            
             */
            //------------------- ACTUALIZACION DE OBJETOS ------------------- 
            // Actualizacion Proveedores
            System.out.println("---- ACTUALIZACION Proveedores----- ");

            session.beginTransaction();
            Proveedores proveedorActualizar = session.get(Proveedores.class, 207);
            proveedorActualizar.setNombre("Raimundo");
            if (proveedorActualizar != null) {
                session.save(proveedorActualizar);
                session.update(proveedorActualizar);
                System.out.println("Registro actualizado en  objeto proveedores " + proveedorActualizar.toString());
            } else {
                System.out.println("El proveedor no existe");
            }

            session.getTransaction().commit();

            // Actualizacion Categorias
            System.out.println("---- ACTUALIZACION Categorias----- ");

            session.beginTransaction();
            Categorias categoriaActualizar = session.get(Categorias.class, 8);
            categoriaActualizar.setNombre("Chapa y pintura");
            if (categoriaActualizar != null) {
                session.save(categoriaActualizar);
                session.update(categoriaActualizar);
                System.out.println("Registro actualizado en  objeto categoria " + categoriaActualizar.toString());
            } else {
                System.out.println("La categoria no existe");
            }

            session.getTransaction().commit();

            /*
            //------------------- CONSULTA DE OBJETOS -------------------  
            //Obejto Categorias
            System.out.println("---- Consulta objeto Categorias ----- ");
            session.beginTransaction();
            Categorias categoria = session.get(Categorias.class, 1);
            if (categoria != null) {
                System.out.println(categoria.toString());
            } else {
                System.out.println("La categoria no existe");
            }
            //Obtenemos los productos  relacionados con categoria
            for (Productos pro : categoria.getProductos()) {
                System.out.println(pro.toString());
            }

            session.getTransaction().commit();
            //Objeto Proveedores
            System.out.println("---- Consulta objeto Proveedores ----- ");
            session.beginTransaction();
            Proveedores proveedores = session.get(Proveedores.class, 100);
            if (proveedores != null) {
                System.out.println(proveedores.toString());
            } else {
                System.out.println("El proveedores no existe");
            }
            //Obtenemos los productos  relacionados con proveedores

            for (Productos prod : proveedores.getProductos()) {
                System.out.println(prod.toString());
            }

            session.getTransaction().commit();

            //Objeto Productos
            System.out.println("---- Consulta objeto Productos ----- ");
            session.beginTransaction();
            Productos productos = session.get(Productos.class, 104);
            if (productos != null) {
                System.out.println(productos.toString());
            } else {
                System.out.println("El productos no existe");
            }
            //Obtenemos los  proveedores relacionado con producto
            System.out.println("Proveedores relacionados con productos: " + productos.getCategorias_productos().toString());

            session.getTransaction().commit();

            //Objeto Clientes
            System.out.println("---- Consulta objeto Clientes ----- ");
            session.beginTransaction();
            Clientes clientes1 = session.get(Clientes.class, 201);
            if (clientes1 != null) {
                System.out.println(clientes1.toString());
            } else {
                System.out.println("El clientes1 no existe");
            }
            //Obtenemos las facturas  relacionados con clientes

            for (Facturas fact : clientes1.getFacturas()) {
                System.out.println("Facturas relacionadas con clientes: "+fact.toString());
            }

            session.getTransaction().commit();
            
               //Objeto Facturas
            System.out.println("---- Consulta objeto Facturas ----- ");
            session.beginTransaction();
            Facturas factura1 = session.get(Facturas.class, 3004);
            if (factura1 != null) {
                System.out.println(factura1.toString());
            } else {
                System.out.println("La factura1 no existe");
            }
            //Obtenemos los clientes relacionados con factura
                System.out.println("Clientes relacionado con la factura: " + factura1.getClientes_facturas().toString());
            
            session.getTransaction().commit();
             */
 /*        
             //-------------------  BORRADO DE OBJETOS -------------------
             
         
            System.out.println("---- Borrado Proveedores_1aN----- ");

            session.beginTransaction();
            Proveedores proveedorBorrado = session.get(Proveedores.class, 205);
            if (proveedorBorrado != null) {
                session.delete(proveedorBorrado);
                System.out.println("Registro borrado en proveedores y producto" + proveedorBorrado.toString());
            } else {
                System.out.println("El proveedor no existe");
            }

            session.getTransaction().commit();

            System.out.println("---- Borrado Categoria_1aN ----- ");

            session.beginTransaction();
            Categorias categoriaBorrado = session.get(Categorias.class, 9);
            if (categoriaBorrado != null) {
                session.delete(categoriaBorrado);
                System.out.println("Registro borrado en categoria  y producto " + categoriaBorrado.toString());
            } else {
                System.out.println("La categoria no existe");
            }

            session.getTransaction().commit();

            System.out.println("---- Borrado Productos_Na1 ----- ");

            session.beginTransaction();
            Productos productoBorrado = session.get(Productos.class, 107);
            if (productoBorrado != null) {
                session.delete(productoBorrado);
                System.out.println("Registro borrado en producto  " + productoBorrado.toString());
            } else {
                System.out.println("La categoria no existe");
            }

            session.getTransaction().commit();

            System.out.println("---- Borrado Relacion Clientes_1aN ----- ");

            session.beginTransaction();
            Clientes clientesBorrado = session.get(Clientes.class, 200);
            if (clientesBorrado != null) {
                session.delete(clientesBorrado);
                System.out.println("Registro borrado en categoria  y producto " + clientesBorrado.toString());
            } else {
                System.out.println("El cliente no existe");
            }

            session.getTransaction().commit();

            System.out.println("---- Borrado Relacion Facturas_Na1 ----- ");

            session.beginTransaction();
            Facturas facturasBorrado = session.get(Facturas.class, 3010);
            if (facturasBorrado != null) {
                session.delete(facturasBorrado);
                System.out.println("Registro borrado factura " + facturasBorrado.toString());
            } else {
                System.out.println("La factura no existe");
            }

            session.getTransaction().commit();
             */
            session.close();
            instancia.close();

        } catch (Exception he) {
            System.out.println(he);

        }

    }

}
