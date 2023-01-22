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
@Table(name = "categorias")
public class oldCategorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idCategorias")
    private Integer idCategorias;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Descripcion")
    private String Descripcion;

    @OneToMany(mappedBy = "categorias_productos", cascade = CascadeType.DETACH)

    private List<oldProductos> productos;

    /**
     * Constructor vacio
     */
    public oldCategorias() {
    }

    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla oldCategorias.
    public oldCategorias(Integer idCategorias, String Nombre, String Descripcion) {
        this.idCategorias = idCategorias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
    //Metodos get y set.

    public List<oldProductos> getProductos() {
        return productos;
    }

    public void setProductos(oldProductos prod) {
        if (productos == null) {
            productos = new ArrayList<>();
        }
        productos.add(prod);
        prod.setCategorias_productos(this);
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

    /**
     * Metodo el cual genera un codigo hash unico para un objeto.
     *
     * @return Devuelve el codigo hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorias != null ? idCategorias.hashCode() : 0);
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
        if (!(object instanceof oldCategorias)) {
            return false;
        }
        oldCategorias other = (oldCategorias) object;
        if ((this.idCategorias == null && other.idCategorias != null) || (this.idCategorias != null && !this.idCategorias.equals(other.idCategorias))) {
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
        return "p2t2hibernate_ferreteria.Proveedores[ id="
                + idCategorias + ", nombre: " + Nombre + ", descripcion: " + Descripcion + "]";
    }
}
