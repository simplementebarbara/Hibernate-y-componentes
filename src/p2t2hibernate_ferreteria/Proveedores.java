
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
@Table(name= "proveedores")
public class Proveedores implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idProveedores")
    private Integer idProveedores;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "Telefono")
    private String Telefono;
     @OneToMany(mappedBy = "proveedores_productos", cascade = CascadeType.ALL)
       
        private List<Productos> productos;
   
      public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(Productos prod) {
        if(productos == null) productos = new ArrayList<>();
        productos.add(prod);
        prod.setProveedores_productos(this);
    }
     
    //Siempre se le añade un constructor vacio
    public Proveedores() {

    }

   
     /**
     * Constructor sobre cargado En este caso le debemos pasar el id
     * @param idProveedores
     * 
     */
    public Proveedores(Integer idProveedores, String Nombre,
            String Direccion, String Telefono) {
        this.idProveedores = idProveedores;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        
    }
 /**
     * Creamos los metodos getter y setter de cada atributo de la clase
     */

    public Integer getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(Integer idProveedores) {
        this.idProveedores = idProveedores;
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
        hash += (idProveedores != null ? idProveedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProveedores == null && other.idProveedores != null) || (this.idProveedores != null && !this.idProveedores.equals(other.idProveedores))) {
            return false;
        }
        return true;
    }
      @Override
    public String toString() {
        return "p2t2hibernate_ferreteria.Proveedores[ id=" + idProveedores 
                + ", Nombre: "+Nombre + " , direccion: " + Direccion + " , telefono: "+ Telefono +"]";
    }
    
 
    
}
