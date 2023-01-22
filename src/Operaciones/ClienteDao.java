package Operaciones;

import Dtos.ClienteDto;
import org.hibernate.Session;
import Modelo.Clientes;

/**
 * Clase con la que operar sobre la tabla "Clientes". Implementa la interfaz
 * Dao.
 *
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez.
 */
public class ClienteDao extends BaseDao<ClienteDto> {

    /**
     * session: objeto de tipo Session con el que establecer la conexion con la
     * BDD.
     */
    // private final Session session;
    /**
     * Metodo el cual asigna la conexion a la BDD con la clase Clientes.
     *
     * @param session objeto para establecer la sesion con la BDD.
     */
    public ClienteDao(Session session) {
        super(session);
    }

    /**
     * Metodo implementado de la interfaz Dao el cual obtiene los datos de la
     * tabla Clientes.
     *
     * @param id identificador (Primary Key) sobre la que realizar la consulta.
     * @return
     */
    @Override
    public ClienteDto get(Integer id) {
        Clientes cliente = getCliente(id);
        return new ClienteDto(cliente.getIdClientes(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono());
    }

    /**
     * Metodo implementado de la interfaz Dao el cual inserta los datos del
     * parametro t en la tabla Clientes.
     *
     * @param t Objeto ClienteDto el cual se desea insertar en la tabla
     * Clientes.
     */
    @Override
    public void save(ClienteDto t) {
        Clientes cliente = new Clientes(t.getIdClientes(), t.getNombre(), t.getDireccion(), t.getTelefono());
        this.session.save(cliente);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual actualiza los registros de
     * la tabla Clientes en funcion del id del cliente pasado por parametro. En
     * caso de no existir el cliente, lo notificara.
     *
     * @param t Objeto ClienteDto del cual se obtendra el id para actualizar la
     * tabla.
     * @throws Exception
     */
    @Override
    public void update(ClienteDto t) throws Exception {
        Clientes cliente = getCliente(t.getIdClientes());
        if (cliente == null) {
            throw new Exception("Cliente no existe");
        }
        cliente.setDireccion(t.getDireccion());
        cliente.setNombre(t.getNombre());
        cliente.setTelefono(t.getTelefono());
        this.session.update(cliente);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual borra los registros de la
     * tabla Clientes en funcion del id del cliente pasado por parametro. En
     * caso de existir el cliente, lo eliminara.
     *
     * @param t Objeto de tipo ClienteDto el cual se desea eliminar de la BDD.
     */
    @Override
    public void delete(ClienteDto t) {
        Clientes cliente = getCliente(t.getIdClientes());
        if (cliente != null) {
            this.session.delete(cliente);
            commit();
        }
    }

    /**
     * Metodo para obtener el cliente que coincida con el id pasado por
     * parametro.
     *
     * @param id identificador con el que encontrar al cliente que se desea
     * recuperar de la BDD.
     * @return cliente obtenido
     */
    private Clientes getCliente(Integer id) {
        Clientes cliente = this.session.get(Clientes.class, id);
        return cliente;
    }
}
