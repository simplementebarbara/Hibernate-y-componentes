package Dtos;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez.
 */
public class CategoriasDto {

    private Integer idCategorias;
    private String Nombre;
    private String Descripcion;
   
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

    //Constructor que recibe parametros en funcion de las columnas que posee la
    //tabla Categorias.
    public CategoriasDto(Integer idCategorias, String Nombre, String Descripcion) {
        this.idCategorias = idCategorias;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    /**
     * Metodo el cual muestra los atributos de clase como texto.
     *
     * @return Devuelve los atributos de clase como texto.
     */
    @Override
    public String toString() {
        return "CategoriaDto{" + "idCategorias=" + idCategorias + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + '}';
    }

}
