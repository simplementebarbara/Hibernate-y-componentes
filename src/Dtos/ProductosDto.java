package Dtos;

/**
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public class ProductosDto {

    private Integer idProductos;
    private String Nombre;
    private String Stock;
    private Integer idCategoria;
    private Integer idProveedor;
    private Integer Precio;

    public ProductosDto(Integer idProductos, String Nombre, String Stock, Integer idCategoria, Integer idProveedor, Integer Precio) {
        this.idProductos = idProductos;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.Precio = Precio;
    }
//getter y setter de la relacion

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getPrecio() {
        return Precio;
    }

    public void setPrecio(Integer Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        return "ProductosDto{" + "idProductos=" + idProductos + ", Nombre=" + Nombre + ", Stock=" + Stock + ", categorias_productos=" + idCategoria + ", proveedores_productos=" + idProveedor + ", Precio=" + Precio + '}';
    }

}
