package OldDataSource;

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
 * Clase la cual se usa para mapear una entidad en la BDD.
 *
 * @Entity Se especifica que la clase es una entidad mapeada en una tabla de la
 * BDD.
 * @Table Nombre de la tabla
 * @Id Identificador
 * @Column Columna de la BDD.
 * @OneToMany Anotacion para especificar la relacion desde categorias es de uno
 * a muchos.
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
@Entity
@Table(name = "proveedores")
public class oldProveedores implements Serializable {

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

    private List<oldProductos> productos;

    public List<oldProductos> getProductos() {
        return productos;
    }

    //Constructos vacio.
    public oldProveedores() {

    }

    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla oldProveedores.
    public oldProveedores(Integer idProveedores, String Nombre,
            String Direccion, String Telefono) {
        this.idProveedores = idProveedores;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;

    }

    /**
     * Metodos getter y setter.
     */
    public void setProductos(oldProductos prod) {
        if (productos == null) {
            productos = new ArrayList<>();
        }
        productos.add(prod);
        prod.setProveedores_productos(this);
    }

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

    /**
     * Metodo el cual genera un codigo hash unico para un objeto.
     *
     * @return Devuelve el codigo hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedores != null ? idProveedores.hashCode() : 0);
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
        if (!(object instanceof oldProveedores)) {
            return false;
        }
        oldProveedores other = (oldProveedores) object;
        if ((this.idProveedores == null && other.idProveedores != null) || (this.idProveedores != null && !this.idProveedores.equals(other.idProveedores))) {
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
        return "p2t2hibernate_ferreteria.Proveedores[ id=" + idProveedores
                + ", Nombre: " + Nombre + " , direccion: " + Direccion + " , telefono: " + Telefono + "]";
    }

}
