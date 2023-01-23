package Dtos;

import java.util.Date;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayora Alvarez
 */
public class FacturasDto {

    private Integer idFacturas;
    private Integer descuento;
    private Date fecha;
    private Integer idClientes;

    public Integer getIdCliente() {
        return idClientes;
    }

    public void setIdCliente(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Integer getIdFacturas() {
        return idFacturas;
    }

    public void setIdFacturas(Integer idFacturas) {
        this.idFacturas = idFacturas;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FacturasDto(Integer idFacturas, Integer descuento, Date fecha, Integer idClientes) {
        this.idFacturas = idFacturas;
        this.descuento = descuento;
        this.fecha = fecha;
        this.idClientes = idClientes;
    }

    @Override
    public String toString() {
        return "FacturasDto{" + "idFacturas=" + idFacturas + ", descuento=" + descuento + ", fecha=" + fecha + '}';
    }

}
