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
@Table(name = "categorias")
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idCategorias")
    private Integer idCategorias;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Descripcion")
    private String Descripcion;
   
     @OneToMany(mappedBy = "categorias_productos", cascade = CascadeType.DETACH)
       
        private List<Productos> productos;
   
 //get y set de la relacion
    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(Productos prod) {
        if(productos == null) productos = new ArrayList<>();
        productos.add(prod);
        prod.setCategorias_productos(this);
    }
    public Categorias() {
    }

    public Categorias(Integer idCategorias, String Nombre, String Descripcion) {
        this.idCategorias = idCategorias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Integer getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorias != null ? idCategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idCategorias == null && other.idCategorias != null) || (this.idCategorias != null && !this.idCategorias.equals(other.idCategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "p2t2hibernate_ferreteria.Proveedores[ id=" 
                + idCategorias + ", nombre: "+Nombre+ ", descripcion: "+ Descripcion+"]";
    }
}
