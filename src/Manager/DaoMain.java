package Manager;

import Dtos.CategoriasDto;
import Modelo.FerreteriaFactory;
import Operaciones.ClienteDao;
import Operaciones.ProductosDao;
import Dtos.ClienteDto;
import Dtos.FacturasDto;
import Dtos.ProductosDto;
import Dtos.ProveedoresDto;
import Operaciones.CategoriaDao;
import Operaciones.Dao;
import Operaciones.FacturasDao;
import Operaciones.ProveedoresDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase de prueba para los requisitos de la practica.
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class DaoMain {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String tabla;
        Integer opcion = 0;
        Integer identificador;
        Object objeto = null;
        // Crear un HashMap para almacenar los nombres de las tablas y las clases DAO correspondientes
        Map<String, Dao> tablas = new HashMap<>();
        tablas.put("Clientes", new ClienteDao(FerreteriaFactory.getSession()));
        tablas.put("clientes", new ClienteDao(FerreteriaFactory.getSession()));
        tablas.put("Categorias", new CategoriaDao(FerreteriaFactory.getSession()));
        tablas.put("categorias", new CategoriaDao(FerreteriaFactory.getSession()));
        tablas.put("Facturas", new FacturasDao(FerreteriaFactory.getSession()));
        tablas.put("facturas", new FacturasDao(FerreteriaFactory.getSession()));
        tablas.put("Productos", new ProductosDao(FerreteriaFactory.getSession()));
        tablas.put("productos", new ProductosDao(FerreteriaFactory.getSession()));
        tablas.put("Proveedores", new ProveedoresDao(FerreteriaFactory.getSession()));
        tablas.put("proveedores", new ProveedoresDao(FerreteriaFactory.getSession()));

        do {
            try {
                System.out.println("\n========== Menú CRUD ==========");
                System.out.println("1. Mostrar contenidos de la tabla. ");
                System.out.println("2. Insertar datos en la tabla. ");
                System.out.println("3. Actualizar registros de la tabla. ");
                System.out.println("4. Eliminar registros de la tabla. ");
                System.out.println("5. Salir.");
                System.out.println("================================");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        System.out.print("Ingrese el nombre de la tabla: ");
                        tabla = scanner.next();
                        // Buscar la clase DAO correspondiente a la tabla seleccionada
                        Dao dao = tablas.get(tabla);
                        if (dao == null) {
                            System.out.println("Tabla no encontrada");
                        } else {
                            switch (opcion) {
                                case 1:
                                    System.out.print("Introduzca el identificador: ");
                                    identificador = scanner.nextInt();
                                    System.out.println();
                                    objeto = dao.get(identificador);
                                    System.out.println(objeto.toString());
                                    break;
                                case 2:
                                    Insertar(tabla, scanner, objeto, dao);
                                    break;
                                case 3:
                                    Actualizar(tabla, scanner, objeto, dao);
                                    break;
                                case 4:
                                    Eliminar(tabla, scanner, objeto, dao);
                                    break;
                            }
                        }
                        break;
                    case 5:
                        FerreteriaFactory.close();
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida, intente de nuevo.");

                }
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida, debe ingresar un número. Intente de nuevo: ");
                scanner.next();
            }
        } while (opcion != 5);
    }

    private static void Insertar(String tabla, Scanner scanner, Object objeto, Dao dao) throws ParseException, Exception {
        Integer identificador;
        String nombre;
        String direccion;
        String telefono;
        String descripcion;
        Integer descuento;
        String fecha;
        Integer idClientes;
        Integer stock;
        Integer idCategorias;
        Integer idProveedores;
        Integer precio;
        if (tabla.equalsIgnoreCase("Clientes")) {
            System.out.print("Introduzca el identificador que desea insertar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea insertar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca la direccion que desea insertar: ");
            direccion = scanner.nextLine();
            System.out.print("Introduzca el telefono que desea insertar: ");
            telefono = scanner.nextLine();
            objeto = new ClienteDto(identificador, nombre, direccion, telefono);
        } else if (tabla.equalsIgnoreCase("Categorias")) {
            System.out.print("Introduzca el identificador que desea insertar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea insertar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca la descripcion que desea insertar: ");
            descripcion = scanner.nextLine();
            objeto = new CategoriasDto(identificador, nombre, descripcion);
        } else if (tabla.equalsIgnoreCase("Facturas")) {
            System.out.print("Introduzca el identificador que desea insertar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el descuento que desea insertar: ");
            descuento = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca la fecha que desea insertar: ");
            fecha = scanner.nextLine();
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaConv = formato.parse(fecha);
            //TODO - revisar insercion
            System.out.print("Introduzca el identificador de cliente que desea insertar: ");
            idClientes = scanner.nextInt();
            scanner.nextLine();
            objeto = new FacturasDto(identificador, descuento, fechaConv, idClientes);
        } else if (tabla.equalsIgnoreCase("Productos")) {
            System.out.print("Introduzca el identificador que desea insertar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea insertar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca el stock que desea insertar: ");
            stock = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el identificador de categorias que desea insertar: ");
            idCategorias = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el identificador de proveedores que desea insertar: ");
            idProveedores = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el precio que desea insertar: ");
            precio = scanner.nextInt();
            scanner.nextLine();
            objeto = new ProductosDto(identificador, nombre, stock.toString(), idCategorias, idProveedores, precio);
        } else if (tabla.equalsIgnoreCase("Proveedores")) {
            System.out.print("Introduzca el identificador que desea insertar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea insertar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca la direccion que desea insertar: ");
            direccion = scanner.nextLine();
            System.out.print("Introduzca el telefono que desea insertar: ");
            telefono = scanner.nextLine();
            objeto = new ProveedoresDto(identificador, nombre, direccion, telefono);

        }
        dao.save(objeto);
        System.out.println("Registro insertado correctamente.");
    }

    private static void Actualizar(String tabla, Scanner scanner, Object objeto, Dao dao) throws ParseException, Exception {
        Integer identificador;
        String nombre;
        String direccion;
        String telefono;
        String descripcion;
        Integer descuento;
        String fecha;
        Integer idClientes;
        Integer stock;
        Integer idCategorias;
        Integer idProveedores;
        Integer precio;
        if (tabla.equalsIgnoreCase("Clientes")) {
            System.out.print("Introduzca el identificador que desea actualizar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea actualizar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca la direccion que desea actualizar: ");
            direccion = scanner.nextLine();
            System.out.print("Introduzca el telefono que desea actualizar: ");
            telefono = scanner.nextLine();
            objeto = new ClienteDto(identificador, nombre, direccion, telefono);
        } else if (tabla.equalsIgnoreCase("Categorias")) {
            System.out.print("Introduzca el identificador que desea actualizar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea actualizar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca la descripcion que desea actualizar: ");
            descripcion = scanner.nextLine();
            objeto = new CategoriasDto(identificador, nombre, descripcion);
        } else if (tabla.equalsIgnoreCase("Facturas")) {
            //Añadir lineas
        } else if (tabla.equalsIgnoreCase("Productos")) {
            System.out.print("Introduzca el identificador que desea actualizar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea actualizar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca el stock que desea actualizar: ");
            stock = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el identificador de categorias que desea actualizar: ");
            idCategorias = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el identificador de proveedores que desea actualizar: ");
            idProveedores = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el precio que desea actualizar: ");
            precio = scanner.nextInt();
            scanner.nextLine();
            objeto = new ProductosDto(identificador, nombre, stock.toString(), idCategorias, idProveedores, precio);
        } else if (tabla.equalsIgnoreCase("Proveedores")) {
            System.out.print("Introduzca el identificador que desea actualizar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduzca el nombre que desea actualizar: ");
            nombre = scanner.nextLine();
            System.out.print("Introduzca la  direccion que desea actualizar: ");
            direccion = scanner.nextLine();
            System.out.print("Introduzca el telefono que desea actualizar: ");
            telefono = scanner.nextLine();
            objeto = new ProveedoresDto(identificador, nombre, direccion, telefono);
        }
        dao.update(objeto);
        System.out.println("Registro insertado correctamente.");
    }

    private static void Eliminar(String tabla, Scanner scanner, Object objeto, Dao dao) throws ParseException, Exception {
        Integer identificador;
        if (tabla.equalsIgnoreCase("Clientes")) {
            System.out.print("Introduzca el identificador que desea Eliminar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            objeto = new ClienteDto(identificador, "", "", "");
        } else if (tabla.equalsIgnoreCase("Categorias")) {
            System.out.print("Introduzca el identificador que desea Eliminar: ");
            identificador = scanner.nextInt();
            objeto = new CategoriasDto(identificador, "", "");
        } else if (tabla.equalsIgnoreCase("Facturas")) {
            System.out.print("Introduzca el identificador que desea Eliminar: ");
            identificador = scanner.nextInt();
            objeto = new FacturasDto(identificador, 0, null, 0);
        } else if (tabla.equalsIgnoreCase("Productos")) {
            System.out.print("Introduzca el identificador que desea Eliminar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            objeto = new ProductosDto(identificador, "", "", 0, 0, 0);
        } else if (tabla.equalsIgnoreCase("Proveedores")) {
            System.out.print("Introduzca el identificador que desea Eliminar: ");
            identificador = scanner.nextInt();
            scanner.nextLine();
            objeto = new ProveedoresDto(identificador, "", "", "");

        }
        dao.delete(objeto);
        System.out.println("Registro borrado correctamente.");
    }
}
