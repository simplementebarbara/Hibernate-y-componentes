package Dtos;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class ProveedoresDto {

    private Integer idProveedores;
    private String Nombre;
    private String Direccion;
    private String Telefono;

    public ProveedoresDto(Integer idProveedores, String Nombre,
            String Direccion, String Telefono) {
        this.idProveedores = idProveedores;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;

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

    @Override
    public String toString() {
        return "ProveedoresDto{" + "idProveedores=" + idProveedores + ", Nombre="
                + Nombre + ", Direccion=" + Direccion + ", Telefono=" + Telefono;
    }

}
