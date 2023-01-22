package Operaciones;

import Modelo.Categorias;
import Modelo.Productos;
import Modelo.Proveedores;
import Dtos.ProductosDto;
import org.hibernate.Session;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class ProductosDao extends BaseDao<ProductosDto> {

    /**
     * session: objeto de tipo Session con el que establecer la conexion con la
     * BDD.
     */
    //private final Session session;
    /**
     * Metodo el cual asigna la conexion a la BDD con la clase Productos.
     *
     * @param session objeto para establecer la sesion con la BDD.
     */
    public ProductosDao(Session session) {
        super(session);
    }

    /**
     * Metodo implementado de la interfaz Dao el cual obtiene los datos de la
     * tabla Productos.
     *
     * @param id identificador (Primary Key) sobre la que realizar la consulta.
     * @return
     */
    @Override
    public ProductosDto get(Integer id) {
        Productos productos = getProductos(id);
        return new ProductosDto(
                productos.getIdProductos(),
                productos.getNombre(),
                productos.getStock(),
                productos.getCategoriasidCategorias().getIdCategorias(),
                productos.getProveedoresidProveedores().getIdProveedores(),
                productos.getPrecio()
        );
    }

    /**
     * Metodo implementado de la interfaz Dao el cual inserta los datos del
     * parametro t en la tabla Productos.
     *
     * @param t Objeto ProductosDto el cual se desea insertar en la tabla
     * Productos.
     */
    @Override
    public void save(ProductosDto t) throws Exception {
        Proveedores proveedor = getProveedor(t.getIdProveedor());
        Categorias categoria = getCategoria(t.getIdCategoria());
        Productos productos = new Productos(t.getIdProductos(), t.getNombre(), t.getStock(), t.getPrecio(), categoria, proveedor);
        this.session.save(productos);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual actualiza los registros de
     * la tabla Productos en funcion del id del cliente pasado por parametro. En
     * caso de no existir el productos, lo notificara.
     *
     * @param t Objeto ProductosDto del cual se obtendra el id para actualizar
     * la tabla.
     * @throws Exception
     */
    @Override
    public void update(ProductosDto t) throws Exception {
        Productos productos = getProductos(t.getIdProductos());
        if (productos == null) {
            throw new Exception("Cliente no existe");
        }
        productos.setNombre(t.getNombre());
        productos.setStock(t.getStock());
        productos.setCategoriasidCategorias(getCategoria(t.getIdCategoria()));
        productos.setProveedoresidProveedores(getProveedor(t.getIdProveedor()));
        productos.setPrecio(t.getPrecio());
        this.session.update(productos);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual borra los registros de la
     * tabla Productos en funcion del id del cliente pasado por parametro. En
     * caso de existir el producto, lo eliminara.
     *
     * @param t Objeto de tipo ProductosDto el cual se desea eliminar de la BDD.
     */
    @Override
    public void delete(ProductosDto t) {
        Productos productos = getProductos(t.getIdProductos());
        if (productos != null) {
            this.session.delete(productos);
            commit();
        }
    }

    /**
     * Metodo para obtener el producto que coincida con el id pasado por
     * parametro.
     *
     * @param id identificador con el que encontrar al producto que se desea
     * recuperar de la BDD.
     * @return producto obtenido
     */
    private Productos getProductos(Integer id) {
        Productos productos = this.session.get(Productos.class, id);
        return productos;
    }

    private Proveedores getProveedor(Integer id) throws Exception {
        Proveedores proveedor = session.get(Proveedores.class, id);
        if (proveedor == null) {
            throw new Exception("No existe el proveedor asociado con el prducto");
        }
        return proveedor;
    }

    private Categorias getCategoria(Integer id) throws Exception {
        Categorias categoria = session.get(Categorias.class, id);
        if (categoria == null) {
            throw new Exception("No existe el categoría asociado con el prducto");
        }
        return categoria;
    }
}
