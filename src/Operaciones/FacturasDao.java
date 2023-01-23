package Operaciones;

import Modelo.Clientes;
import Modelo.Facturas;
import Dtos.FacturasDto;
import org.hibernate.Session;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class FacturasDao extends BaseDao<FacturasDto> {

    /**
     * Metodo el cual asigna la conexion a la BDD con la clase Facturas.
     *
     * @param session objeto para establecer la sesion con la BDD.
     */
    public FacturasDao(Session session) {
        super(session);
    }

    /**
     * Metodo implementado de la interfaz Dao el cual obtiene los datos de la
     * tabla Facturas.
     *
     * @param id identificador (Primary Key) sobre la que realizar la consulta.
     * @return
     */
    @Override
    public FacturasDto get(Integer id) {
        Facturas facturas = getFacturas(id);
        return new FacturasDto(facturas.getIdFacturas(), facturas.getDescuento(),
                facturas.getFecha(), facturas.getClientesidClientes().getIdClientes());
    }

    /**
     * Metodo implementado de la interfaz Dao el cual inserta los datos del
     * parametro t en la tabla Facturas.
     *
     * @param t Objeto FacturasDto el cual se desea insertar en la tabla
     * Facturas.
     */
    @Override
    public void save(FacturasDto t) {
        Clientes cliente = session.get(Clientes.class, t.getIdCliente());
        Facturas facturas = new Facturas(t.getIdFacturas(), t.getDescuento(), t.getFecha(), cliente);
        this.session.save(facturas);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual actualiza los registros de
     * la tabla Facturas en funcion del id del cliente pasado por parametro. En
     * caso de no existir la factura, lo notificara.
     *
     * @param t Objeto FacturaDto del cual se obtendra el id para actualizar la
     * tabla.
     * @throws Exception
     */
    @Override
    public void update(FacturasDto t) throws Exception {
        Facturas facturas = getFacturas(t.getIdFacturas());
        if (facturas == null) {
            throw new Exception("Facturas no existe");
        }
        Clientes cliente = session.get(Clientes.class, t.getIdCliente());
        facturas.setDescuento(t.getDescuento());
        facturas.setFecha(t.getFecha());
        facturas.setClientesidClientes(cliente);
        this.session.update(facturas);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual borra los registros de la
     * tabla Clientes en funcion del id del cliente pasado por parametro. En
     * caso de existir la factura, lo eliminara.
     *
     * @param t Objeto de tipo FacturasDto el cual se desea eliminar de la BDD.
     */
    @Override
    public void delete(FacturasDto t) {
        Facturas facturas = getFacturas(t.getIdFacturas());
        if (facturas != null) {
            this.session.delete(facturas);
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
    private Facturas getFacturas(Integer id) {
        Facturas factura = this.session.get(Facturas.class, id);
        return factura;
    }
}
