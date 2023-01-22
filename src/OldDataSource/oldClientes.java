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
@Table(name = "clientes")
public class oldClientes implements Serializable {

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

    private List<oldFacturas> facturas;

    /**
     * Constructor vacio.
     */
    public oldClientes() {

    }

    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla Cliente.
    public oldClientes(Integer idClientes, String Nombre, String Direccion, String Telefono) {
        this.idClientes = idClientes;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;

    }

    /**
     * Metodos getter y setter.
     */
    public List<oldFacturas> getFacturas() {
        return facturas;
    }

    public void setFacturas(oldFacturas fact) {
        if (facturas == null) {
            facturas = new ArrayList<>();
        }
        facturas.add(fact);
        fact.setClientes_facturas(this);

    }

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

    /**
     * Metodo el cual genera un codigo hash unico para un objeto.
     *
     * @return Devuelve el codigo hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientes != null ? idClientes.hashCode() : 0);
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
        if (!(object instanceof oldClientes)) {
            return false;
        }
        oldClientes other = (oldClientes) object;
        if ((this.idClientes == null && other.idClientes != null) || (this.idClientes != null && !this.idClientes.equals(other.idClientes))) {
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
        return "p2t2hibernate_ferreteria.Clientes[ id=" + idClientes + ", nombre: "
                + Nombre + " , direccion: " + Direccion + ", telefono: " + Telefono + "]";
    }

}
