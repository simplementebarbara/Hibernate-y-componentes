/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 34686
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProductos", query = "SELECT p FROM Productos p WHERE p.idProductos = :idProductos"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByStock", query = "SELECT p FROM Productos p WHERE p.stock = :stock"),
    @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProductos")
    private Integer idProductos;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Stock")
    private String stock;
    @Basic(optional = false)
    @Column(name = "Precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<LineasFacturas> lineasFacturasCollection;
    @JoinColumn(name = "Categorias_idCategorias", referencedColumnName = "idCategorias")
    @ManyToOne(optional = false)
    private Categorias categoriasidCategorias;
    @JoinColumn(name = "Proveedores_idProveedores", referencedColumnName = "idProveedores")
    @ManyToOne(optional = false)
    private Proveedores proveedoresidProveedores;

    public Productos(Integer idProductos, String nombre, String stock, int precio, Categorias categoriasidCategorias, Proveedores proveedoresidProveedores) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.categoriasidCategorias = categoriasidCategorias;
        this.proveedoresidProveedores = proveedoresidProveedores;
    }

    
    
    public Productos() {
    }

    public Productos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public Productos(Integer idProductos, int precio) {
        this.idProductos = idProductos;
        this.precio = precio;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<LineasFacturas> getLineasFacturasCollection() {
        return lineasFacturasCollection;
    }

    public void setLineasFacturasCollection(Collection<LineasFacturas> lineasFacturasCollection) {
        this.lineasFacturasCollection = lineasFacturasCollection;
    }

    public Categorias getCategoriasidCategorias() {
        return categoriasidCategorias;
    }

    public void setCategoriasidCategorias(Categorias categoriasidCategorias) {
        this.categoriasidCategorias = categoriasidCategorias;
    }

    public Proveedores getProveedoresidProveedores() {
        return proveedoresidProveedores;
    }

    public void setProveedoresidProveedores(Proveedores proveedoresidProveedores) {
        this.proveedoresidProveedores = proveedoresidProveedores;
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
        return "entityfromdatabase.Productos[ idProductos=" + idProductos + " ]";
    }
    
}
