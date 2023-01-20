
package p2t2hibernate_ferreteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Daniel Mayorga y Bárbara Sánchez
 */
@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

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
    @Column(name = "idClientes")
    private Integer idClientes;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "Telefono")
    private String Telefono;
    @OneToMany(mappedBy = "clientes_facturas", cascade = CascadeType.ALL)
       
        private List<Facturas> facturas;

    public List<Facturas> getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas fact) {
        if(facturas == null) facturas = new ArrayList<>();
        facturas.add(fact);
        fact.setClientes_facturas(this);
            
        }
       
    
   
    
    
    //Siempre se le añade un constructor vacio
    public Clientes() {

    }

    /**
     * Constructor sobre cargado En este caso le debemos pasar el id
     * @param idClientes
     * @param Nombre
     */

    public Clientes(Integer idClientes, String Nombre, String Direccion, String Telefono) {
        this.idClientes = idClientes;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        
    }

    /**
     * Creamos los metodos getter y setter de cada atributo de la clase
     */
    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
      @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientes != null ? idClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idClientes == null && other.idClientes != null) || (this.idClientes != null && !this.idClientes.equals(other.idClientes))) {
            return false;
        }
        return true;
    }
      @Override
    public String toString() {
        return "p2t2hibernate_ferreteria.Clientes[ id=" + idClientes + ", nombre: "+
                Nombre + " , direccion: " + Direccion + ", telefono: " + Telefono+ "]";
    }
    
}
