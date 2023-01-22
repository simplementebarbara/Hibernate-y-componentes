/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 34686
 */
@Embeddable
public class LineasFacturasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Productos_idProductos")
    private int productosidProductos;
    @Basic(optional = false)
    @Column(name = "Facturas_idFacturas")
    private int facturasidFacturas;

    public LineasFacturasPK() {
    }

    public LineasFacturasPK(int productosidProductos, int facturasidFacturas) {
        this.productosidProductos = productosidProductos;
        this.facturasidFacturas = facturasidFacturas;
    }

    public int getProductosidProductos() {
        return productosidProductos;
    }

    public void setProductosidProductos(int productosidProductos) {
        this.productosidProductos = productosidProductos;
    }

    public int getFacturasidFacturas() {
        return facturasidFacturas;
    }

    public void setFacturasidFacturas(int facturasidFacturas) {
        this.facturasidFacturas = facturasidFacturas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productosidProductos;
        hash += (int) facturasidFacturas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineasFacturasPK)) {
            return false;
        }
        LineasFacturasPK other = (LineasFacturasPK) object;
        if (this.productosidProductos != other.productosidProductos) {
            return false;
        }
        if (this.facturasidFacturas != other.facturasidFacturas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityfromdatabase.LineasFacturasPK[ productosidProductos=" + productosidProductos + ", facturasidFacturas=" + facturasidFacturas + " ]";
    }
    
}
