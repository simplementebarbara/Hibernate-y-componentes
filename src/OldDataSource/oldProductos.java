package OldDataSource;

import java.io.Serializable;
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
 * @JoinColumn Join entre tablas
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
@Entity
@Table(name = "productos")
@SuppressWarnings("ConsistentAccessType")
public class oldProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idProductos")
    private Integer idProductos;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Stock")
    private String Stock;
    //Hacemos referencia ala relacion N-1 con la clase oldCategorias
    //Seleccionamos todos los tipos de cascada excepto REFRESH para que no borre la fk

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "Categorias_idCategorias")
    private oldCategorias categorias_productos;

    //getter y setter de la relacion
    public oldCategorias getCategorias_productos() {
        return categorias_productos;
    }

    public void setCategorias_productos(oldCategorias categorias_productos) {
        this.categorias_productos = categorias_productos;
    }

    //Hacemos referencia a la relacion N-1 que tiene con la clase oldProveedores
    //Seleccionamos todos los tipos de cascada excepto REFRESH para que no borre la fk
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "Proveedores_idProveedores")
    private oldProveedores proveedores_productos;

    @Column(name = "Precio")
    private Integer Precio;

    /**
     * Constructor vacio
     */
    public oldProductos() {
    }

    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla oldProductos.
    public oldProductos(Integer idProductos, String Nombre, String Stock, oldCategorias categorias_productos, oldProveedores proveedores_productos, Integer Precio) {
        this.idProductos = idProductos;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.categorias_productos = categorias_productos;
        this.proveedores_productos = proveedores_productos;
        this.Precio = Precio;
    }

    //Metodos getter y setter.
    public oldProveedores getProveedores_productos() {
        return proveedores_productos;
    }

    public void setProveedores_productos(oldProveedores proveedores_productos) {
        this.proveedores_productos = proveedores_productos;
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

    /**
     * Metodo el cual genera un codigo hash unico para un objeto.
     *
     * @return Devuelve el codigo hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductos != null ? idProductos.hashCode() : 0);
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
        if (!(object instanceof oldProductos)) {
            return false;
        }
        oldProductos other = (oldProductos) object;
        if ((this.idProductos == null && other.idProductos != null) || (this.idProductos != null && !this.idProductos.equals(other.idProductos))) {
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
        return "p2t2hibernate_ferreteria.Productos[ id=" + idProductos + " , Nombre: " + Nombre + ", stock: " + Stock + ", precio: " + Precio + " ]";
    }

}
