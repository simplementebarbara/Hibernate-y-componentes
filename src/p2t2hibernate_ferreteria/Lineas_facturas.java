package p2t2hibernate_ferreteria;


/**
 * Esta clase se le va asignar la tabla de union 'Linea_facturas_Id', ya que
 * contiene id compuesto
 *
 * @author Daniel Mayorga y Bárbara Sánchez
 */


public class Lineas_facturas  {

    public Lineas_facturas() {
    }

    public Lineas_facturas(int cantidad) {
        this.cantidad = cantidad;
    }
    private int cantidad;
  

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
