/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 34686
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByIdFacturas", query = "SELECT f FROM Facturas f WHERE f.idFacturas = :idFacturas"),
    @NamedQuery(name = "Facturas.findByDescuento", query = "SELECT f FROM Facturas f WHERE f.descuento = :descuento"),
    @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFacturas")
    private Integer idFacturas;
    @Column(name = "descuento")
    private Integer descuento;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Clientes_idClientes", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes clientesidClientes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas")
    private Collection<LineasFacturas> lineasFacturasCollection;

    public Facturas(Integer idFacturas, Integer descuento, Date fecha, Clientes clientesidClientes) {
        this.idFacturas = idFacturas;
        this.descuento = descuento;
        this.fecha = fecha;
        this.clientesidClientes = clientesidClientes;
    }

    
    public Facturas() {
    }

    public Facturas(Integer idFacturas) {
        this.idFacturas = idFacturas;
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

    public Clientes getClientesidClientes() {
        return clientesidClientes;
    }

    public void setClientesidClientes(Clientes clientesidClientes) {
        this.clientesidClientes = clientesidClientes;
    }

    @XmlTransient
    public Collection<LineasFacturas> getLineasFacturasCollection() {
        return lineasFacturasCollection;
    }

    public void setLineasFacturasCollection(Collection<LineasFacturas> lineasFacturasCollection) {
        this.lineasFacturasCollection = lineasFacturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturas != null ? idFacturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idFacturas == null && other.idFacturas != null) || (this.idFacturas != null && !this.idFacturas.equals(other.idFacturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityfromdatabase.Facturas[ idFacturas=" + idFacturas + " ]";
    }
    
}
