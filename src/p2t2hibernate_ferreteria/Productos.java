package p2t2hibernate_ferreteria;

import java.io.Serializable;
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
@Table(name = "productos")
@SuppressWarnings("ConsistentAccessType")
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name= "idProductos")
    private Integer idProductos;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Stock")
    private String Stock;
     //Hacemos referencia ala relacion N-1 con la clase Categorias
     //Seleccionamos todos los tipos de cascada excepto REFRESH para que no borre la fk
    
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "Categorias_idCategorias")
    private Categorias categorias_productos;
    //getter y setter de la relacion
    public Categorias getCategorias_productos() {
        return categorias_productos;
    }

    public void setCategorias_productos(Categorias categorias_productos) {
        this.categorias_productos = categorias_productos;
    }
    
     //Hacemos referencia a la relacion N-1 que tiene con la clase Proveedores
     //Seleccionamos todos los tipos de cascada excepto REFRESH para que no borre la fk
    
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "Proveedores_idProveedores")
    private Proveedores proveedores_productos;
     //getter y setter de la relacion
    public Proveedores getProveedores_productos() {
        return proveedores_productos;
    }

    public void setProveedores_productos(Proveedores proveedores_productos) {
        this.proveedores_productos = proveedores_productos;
    }
 
    @Column(name = "Precio")
    private Integer Precio;


 

    public Productos() {
    }

    public Productos(Integer idProductos, String Nombre, String Stock, Categorias categorias_productos, Proveedores proveedores_productos, Integer Precio) {
        this.idProductos = idProductos;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.categorias_productos = categorias_productos;
        this.proveedores_productos = proveedores_productos;
        this.Precio = Precio;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer Precio) {
        this.Precio = Precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductos != null ? idProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProductos == null && other.idProductos != null) || (this.idProductos != null && !this.idProductos.equals(other.idProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "p2t2hibernate_ferreteria.Productos[ id=" + idProductos + " , Nombre: "+Nombre +", stock: "+ Stock+", precio: "+ Precio+" ]";
    }
  
    
}
