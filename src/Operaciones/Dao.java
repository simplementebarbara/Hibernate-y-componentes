package Operaciones;

/**
 * Esta clase es un contrato o interfaz donde se establecen todos los puntos que
 * deben tener cada clase y que deben cumplirse.
 *
 * @author Barbara Sanchez Rueda y Daniel Mayorga Alvarez
 */
public interface Dao<T> {

    /**
     * Metodo utilizado para recuperar un objeto especifico de la BDD en funcion
     * que coincida con el id pasado por parametro.
     *
     * @param id identificador del objeto que se desea retirar de la BDD.
     * @return
     */
    T get(Integer id);

    /**
     * Metodo para guardar un objeto en la BDD.
     *
     * @param t objeto que se desea guardar en la BDD.
     */
    void save(T t)  throws Exception;

    /**
     * Metodo para actualizar los registros de un objeto existente en la BDD.
     *
     * @param t objeto existente para actualizar la BDD.
     * @throws Exception
     */
    void update(T t) throws Exception;

    /**
     * Metodo para eliminar un objeto de la BDD.
     *
     * @param t objeto que se desea eliminar de la BDD.
     */
    void delete(T t);
}
