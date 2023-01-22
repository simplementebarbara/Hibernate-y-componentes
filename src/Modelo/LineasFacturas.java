/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 34686
 */
@Entity
@Table(name = "lineas_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineasFacturas.findAll", query = "SELECT l FROM LineasFacturas l"),
    @NamedQuery(name = "LineasFacturas.findByProductosidProductos", query = "SELECT l FROM LineasFacturas l WHERE l.lineasFacturasPK.productosidProductos = :productosidProductos"),
    @NamedQuery(name = "LineasFacturas.findByFacturasidFacturas", query = "SELECT l FROM LineasFacturas l WHERE l.lineasFacturasPK.facturasidFacturas = :facturasidFacturas"),
    @NamedQuery(name = "LineasFacturas.findByCantidad", query = "SELECT l FROM LineasFacturas l WHERE l.cantidad = :cantidad"),
    @NamedQuery(name = "LineasFacturas.findByIdProductos", query = "SELECT l FROM LineasFacturas l WHERE l.idProductos = :idProductos"),
    @NamedQuery(name = "LineasFacturas.findByIdFacturas", query = "SELECT l FROM LineasFacturas l WHERE l.idFacturas = :idFacturas")})
public class LineasFacturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LineasFacturasPK lineasFacturasPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "idProductos")
    private int idProductos;
    @Basic(optional = false)
    @Column(name = "idFacturas")
    private int idFacturas;
    @JoinColumn(name = "Facturas_idFacturas", referencedColumnName = "idFacturas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facturas facturas;
    @JoinColumn(name = "Productos_idProductos", referencedColumnName = "idProductos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public LineasFacturas() {
    }

    public LineasFacturas(LineasFacturasPK lineasFacturasPK) {
        this.lineasFacturasPK = lineasFacturasPK;
    }

    public LineasFacturas(LineasFacturasPK lineasFacturasPK, int idProductos, int idFacturas) {
        this.lineasFacturasPK = lineasFacturasPK;
        this.idProductos = idProductos;
        this.idFacturas = idFacturas;
    }

    public LineasFacturas(int productosidProductos, int facturasidFacturas) {
        this.lineasFacturasPK = new LineasFacturasPK(productosidProductos, facturasidFacturas);
    }

    public LineasFacturasPK getLineasFacturasPK() {
        return lineasFacturasPK;
    }

    public void setLineasFacturasPK(LineasFacturasPK lineasFacturasPK) {
        this.lineasFacturasPK = lineasFacturasPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getIdFacturas() {
        return idFacturas;
    }

    public void setIdFacturas(int idFacturas) {
        this.idFacturas = idFacturas;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineasFacturasPK != null ? lineasFacturasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineasFacturas)) {
            return false;
        }
        LineasFacturas other = (LineasFacturas) object;
        if ((this.lineasFacturasPK == null && other.lineasFacturasPK != null) || (this.lineasFacturasPK != null && !this.lineasFacturasPK.equals(other.lineasFacturasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityfromdatabase.LineasFacturas[ lineasFacturasPK=" + lineasFacturasPK + " ]";
    }
    
}
