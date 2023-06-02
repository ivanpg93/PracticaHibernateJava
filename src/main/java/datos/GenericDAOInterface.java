/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <Entidad> Objeto (Entidad)
 * @param <ID> extends Serializable (El tipo de ID (objeto) solo puede ser de tipo
 * serializable --> que se puede convertir a una secuencia de bytes y luego a un
 * objeto otra vez)
 *
 */
public interface GenericDAOInterface<Entidad, ID extends Serializable> {
    /**
     * Función encargada de guardar una entidad.
     * @param entidad Entidad a guardar
     */
    public void guardar(Entidad entidad);
    
    /**
     * Función encargada de actualizar una entidad
     * @param entidad Entidad a actualizar.
     */
    public void actualizar(Entidad entidad);
    
    /**
     * Función encargada de devolver una entidad según su id.
     * @param id el id de la entidad.
     * @return la Entidad cone se id.
     */
    public Entidad obtener(ID id);
    
    /**
     * Función encargada de obtener todas las entidades del tipo.
     * @return ArrayList de entidades.
     */
    public ArrayList<Entidad> obtenerTodos();
    
    /**
     * Función encargada de eliminar una entidad.
     * @param entidad Entidad a eliminar.
     */
    public void eliminar(Entidad entidad);
    
    /**
     * Funcion encargada de eliminar una lista de entidades
     * @param lista Lista de entidades a eliminar
     */
    public void eliminarLista(List<Entidad> lista);
}
