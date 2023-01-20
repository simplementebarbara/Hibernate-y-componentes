package p2t2hibernate_ferreteria;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

/**
 *
 * @author Daniel Mayorga y Bárbara Sánchez
 */
@Entity
@Table(name = "facturas")
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Estas lineas de codigo solo se pone si el id de la tabla fuera
     * autogenerado
     *
     * @Id
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * @Basic(optional = false)
     *
     */
    @Id
    @Column(name = "idFacturas")
    private Integer idFacturas;
    @Column(name = "descuento")
    private Integer descuento;
    @Column(name = "fecha")
    private Date fecha;
    //Hacemos referencia a la relacion N-1 entre facturas y la clase clientes
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "Clientes_idClientes")
    private Clientes clientes_facturas;
    //getter y setter de la relacion

  
    public Clientes getClientes_facturas() {
        return clientes_facturas;
    }

    public void setClientes_facturas(Clientes clientes_facturas) {
        this.clientes_facturas = clientes_facturas;
    }

  
 
    

   

    public Facturas() {
    }

    public Facturas(Integer idFacturas, Integer descuento, Date fecha, Clientes clientes_facturas) {
        this.idFacturas = idFacturas;
        this.descuento = descuento;
        this.fecha = fecha;
        this.clientes_facturas = clientes_facturas;
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
        return "p2t2hibernate_ferreteria.Facturas[ id=" + idFacturas + " ]";
    }
}
