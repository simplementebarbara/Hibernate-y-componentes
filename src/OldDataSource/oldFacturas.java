package OldDataSource;

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
 * Clase la cual se usa para mapear una entidad en la BDD.
 *
 * @Entity Se especifica que la clase es una entidad mapeada en una tabla de la
 * BDD.
 * @Table Nombre de la tabla
 * @Id Identificador
 * @Column Columna de la BDD.
 * @ManyToOne Anotacion para especificar la relacion desde categorias es de
 * muchos a uno.
 * @JoinColumn Join entre tablas.
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
@Entity
@Table(name = "facturas")
public class oldFacturas implements Serializable {

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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "Clientes_idClientes")
    private oldClientes clientes_facturas;

    /**
     * Constructor vacio.
     */
    public oldFacturas() {
    }

    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla oldFacturas.
    public oldFacturas(Integer idFacturas, Integer descuento, Date fecha, oldClientes clientes_facturas) {
        this.idFacturas = idFacturas;
        this.descuento = descuento;
        this.fecha = fecha;
        this.clientes_facturas = clientes_facturas;
    }

    //Metodos getter y setter.
    public oldClientes getClientes_facturas() {
        return clientes_facturas;
    }

    public void setClientes_facturas(oldClientes clientes_facturas) {
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

    /**
     * Metodo el cual genera un codigo hash unico para un objeto.
     *
     * @return Devuelve el codigo hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturas != null ? idFacturas.hashCode() : 0);
        return hash;
    }

    /**
     * Metodo el cual comprueba si dos objetos son iguales.
     *
     * @param object
     * @return Devuelve falso si no son iguales y verdaderos si son iguales.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof oldFacturas)) {
            return false;
        }
        oldFacturas other = (oldFacturas) object;
        if ((this.idFacturas == null && other.idFacturas != null) || (this.idFacturas != null && !this.idFacturas.equals(other.idFacturas))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo el cual muestra los atributos de clase como texto.
     *
     * @return Devuelve los atributos de clase como texto.
     */
    @Override
    public String toString() {
        return "p2t2hibernate_ferreteria.Facturas[ id=" + idFacturas + " ]";
    }
}
