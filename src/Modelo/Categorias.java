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
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByIdCategorias", query = "SELECT c FROM Categorias c WHERE c.idCategorias = :idCategorias"),
    @NamedQuery(name = "Categorias.findByNombre", query = "SELECT c FROM Categorias c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCategorias")
    private Integer idCategorias;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriasidCategorias")
    private Collection<Productos> productosCollection;

    
    public Categorias(Integer idCategorias, String Nombre, String Descripcion) {
        this.idCategorias = idCategorias;
        this.nombre = Nombre;
        this.descripcion = Descripcion;
    }
    
    public Categorias() {
    }

    public Categorias(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public Integer getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
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
        return "entityfromdatabase.Categorias[ idCategorias=" + idCategorias + " ]";
    }
    
}
