package Operaciones;

import Modelo.Proveedores;
import Dtos.ProveedoresDto;
import org.hibernate.Session;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class ProveedoresDao extends BaseDao<ProveedoresDto> {

    /**
     * Metodo el cual asigna la conexion a la BDD con la clase Proveedores.
     *
     * @param session objeto para establecer la sesion con la BDD.
     */
    public ProveedoresDao(Session session) {
        super(session);
    }

    /**
     * Metodo implementado de la interfaz Dao el cual obtiene los datos de la
     * tabla Proveedores.
     *
     * @param id identificador (Primary Key) sobre la que realizar la consulta.
     * @return
     */
    @Override
    public ProveedoresDto get(Integer id) {
        Proveedores proveedores = getProveedores(id);
        return new ProveedoresDto(proveedores.getIdProveedores(), proveedores.getNombre(), proveedores.getDireccion(), proveedores.getTelefono());
    }

    /**
     * Metodo implementado de la interfaz Dao el cual inserta los datos del
     * parametro t en la tabla Proveedores.
     *
     * @param t Objeto ProveedoresDto el cual se desea insertar en la tabla
     * Proveedores.
     */
    @Override
    public void save(ProveedoresDto t) {
        Proveedores proveedores = new Proveedores(t.getIdProveedores(), t.getNombre(), t.getDireccion(), t.getTelefono());
        this.session.save(proveedores);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual actualiza los registros de
     * la tabla Proveedores en funcion del id del proveedores pasado por
     * parametro. En caso de no existir el proveedor, lo notificara.
     *
     * @param t Objeto ProveedorDto del cual se obtendra el id para actualizar
     * la tabla.
     * @throws Exception
     */
    @Override
    public void update(ProveedoresDto t) throws Exception {
        Proveedores proveedores = getProveedores(t.getIdProveedores());
        if (proveedores == null) {
            throw new Exception("Proveedor no existe");
        }
        proveedores.setNombre(t.getNombre());
        proveedores.setDireccion(t.getDireccion());
        proveedores.setTelefono(t.getTelefono());
        this.session.update(proveedores);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual borra los registros de la
     * tabla Proveedores en funcion del id del proveedor pasado por parametro.
     * En caso de existir el proveedor, lo eliminara.
     *
     * @param t Objeto de tipo ProveedoresDto el cual se desea eliminar de la
     * BDD.
     */
    @Override
    public void delete(ProveedoresDto t) {
        Proveedores proveedores = getProveedores(t.getIdProveedores());
        if (proveedores != null) {
            this.session.delete(proveedores);
            commit();
        }
    }

    /**
     * Metodo para obtener el proveedor que coincida con el id pasado por
     * parametro.
     *
     * @param id identificador con el que encontrar al proveedor que se desea
     * recuperar de la BDD.
     * @return proveedor obtenido
     */
    private Proveedores getProveedores(Integer id) {
        Proveedores proveedores = this.session.get(Proveedores.class, id);
        return proveedores;
    }
}
