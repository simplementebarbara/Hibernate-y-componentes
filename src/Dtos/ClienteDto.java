package Dtos;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class ClienteDto {

    private final Integer idClientes;

    private String nombre;

    private String direccion;

    private String telefono;

    //Metodos getter y setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla Cliente.

    public ClienteDto(Integer idClientes, String nombre, String direccion, String telefono) {
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Metodo el cual muestra los atributos de clase como texto.
     *
     * @return Devuelve los atributos de clase como texto.
     */
    @Override
    public String toString() {
        return "Cliente:" + this.idClientes + "\n"
                + "Nombre:" + this.nombre + "\n"
                + "Direccion:" + this.direccion + "\n"
                + "Telefono:" + this.telefono + "\n";
    }
}
