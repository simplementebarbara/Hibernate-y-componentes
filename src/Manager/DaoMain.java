package Manager;

import Modelo.FerreteriaFactory;
import Operaciones.ClienteDao;
import Operaciones.ProductosDao;
import Dtos.ClienteDto;
import Dtos.ProductosDto;

/**
 * Clase de prueba para los requisitos de la practica.
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class DaoMain {

    public static void main(String[] args) throws Exception {

        ClienteDao cliente = new ClienteDao(FerreteriaFactory.getSession());

        ClienteDto clienteDto = cliente.get(201);
        System.out.println(clienteDto.toString());

        clienteDto.setDireccion("Nueva Direccion+00000000000");
        cliente.update(clienteDto);

        clienteDto = cliente.get(201);
        System.out.println(clienteDto.toString());

        ProductosDao productoDao = new ProductosDao(FerreteriaFactory.getSession());
        ProductosDto producto = productoDao.get(90);
        System.out.println(producto.toString());
        producto.setNombre("Prueba+00000000000000000");
        productoDao.update(producto);
        producto = productoDao.get(90);
        System.out.println(producto.toString());

        FerreteriaFactory.close();

    }
}
