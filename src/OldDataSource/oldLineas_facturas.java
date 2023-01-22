package OldDataSource;

/**
 * Clase la cual va a asignar la tabla de union 'Linea_facturas_Id'. Contiene id
 * compuesto
 *
 * @author Barbara Sanchez Rueda
 */
public class oldLineas_facturas {

    /**
     * Constructor vacio
     */
    public oldLineas_facturas() {
    }

    /**
     * Constructor con parametro cantidad.
     *
     * @param cantidad Id compuesto.
     */
    public oldLineas_facturas(int cantidad) {
        this.cantidad = cantidad;
    }
    private int cantidad;

    //Metodos getter y setter.
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
