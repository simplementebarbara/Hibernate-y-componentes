package Operaciones;

import Modelo.Categorias;
import Dtos.CategoriasDto;
import org.hibernate.Session;

/**
 * Clase con la que operar sobre la tabla "Categorias". Implementa la interfaz
 * Dao.
 *
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez.
 */
public class CategoriaDao extends BaseDao<CategoriasDto> {
    
    public CategoriaDao(Session session) {
        super(session);
    }

    /**
     * Metodo implementado de la interfaz Dao el cual obtiene los datos de la
     * tabla Categorias.
     *
     * @param id identificador (Primary Key) sobre la que realizar la consulta.
     * @return
     */
    @Override
    public CategoriasDto get(Integer id) {
        Categorias categorias = getCategoria(id);
        return new CategoriasDto(categorias.getIdCategorias(), categorias.getNombre(), categorias.getDescripcion());
    }

    /**
     * Metodo implementado de la interfaz Dao el cual inserta los datos del
     * parametro t en la tabla Categorias.
     *
     * @param t Objeto CategoriasDto el cual se desea insertar en la tabla
     * Categorias.
     */
    @Override
    public void save(CategoriasDto t) {
        Categorias categorias = new Categorias(t.getIdCategorias(), t.getNombre(), t.getDescripcion());
        this.session.save(categorias);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual actualiza los registros de
     * la tabla Categorias en funcion del id de la categoria pasada por
     * parametro. En caso de no existir la categoria, lo notificara.
     *
     * @param t Objeto CategoriasDto del cual se obtendra el id para actualizar
     * la tabla.
     * @throws Exception
     */
    @Override
    public void update(CategoriasDto t) throws Exception {
        Categorias categorias = getCategoria(t.getIdCategorias());
        if (categorias == null) {
            throw new Exception("Categorias no existe");
        }
        categorias.setNombre(t.getNombre());
        categorias.setDescripcion(t.getDescripcion());
        this.session.update(categorias);
        commit();
    }

    /**
     * Metodo implementado de la interfaz Dao el cual borra los registros de la
     * tabla Categorias en funcion del id del cliente pasado por parametro. En
     * caso de existir el cliente, lo eliminara.
     *
     * @param t Objeto de tipo CategoriasDto el cual se desea eliminar de la
     * BDD.
     */
    @Override
    public void delete(CategoriasDto t) {
        Categorias categorias = getCategoria(t.getIdCategorias());
        if (categorias != null) {
            this.session.delete(categorias);
            commit();
        }
    }

    /**
     * Metodo para obtener el cliente que coincida con el id pasado por
     * parametro.
     *
     * @param id identificador con el que encontrar al cliente que se desea
     * recuperar de la BDD.
     * @return cliente obtenido
     */
    private Categorias getCategoria(Integer id) {
        Categorias categoria = this.session.get(Categorias.class, id);
        return categoria;
    }
}
