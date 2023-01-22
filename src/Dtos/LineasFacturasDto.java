package Dtos;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class LineasFacturasDto {

    public LineasFacturasDto(int cantidad) {
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
