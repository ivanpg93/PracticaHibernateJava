/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import presentation.MenuPrincipal;
import utils.SingleSession;

/**
 *
 * DAO generico para todas las entidades de hibernate
 *
 * @param <Entidad> Objeto (Entidad)
 * @param <ID> extends Serializable (El tipo de ID (objeto) solo puede ser de tipo
 * serializable --> que se puede convertir a una secuencia de bytes y luego a un
 * objeto otra vez)
 *
 * Uso: public class CombatDAO extends GenericDAOImpl<CombatDAO, int> 
 */
public abstract class GenericDAOImpl<Entidad, ID extends Serializable> implements GenericDAOInterface<Entidad, ID>{

    
    private static final Logger logger = LogManager.getLogger(GenericDAOImpl.class);
        
    //Clase sobre la cual se va a realizar los DAO.
    private Class<Entidad> clase;

    public GenericDAOImpl(Class<Entidad> clase) {
        this.clase = clase;
    }
    
    /**
     * Obtiene una sesión.
     * @return sesión de Hibernate
     */
    private Session getSession() {
        return SingleSession.getInstance().getSessio();
    }

    /**
     * Función a fin de guardar una entidad. Si la entidad ya existe la actualiza.
     * @param entidad  Entidad a guardar.
     */
    @Override
    public void guardar(Entidad entidad) {
        Session session = getSession();
        Transaction tx = null;
        try {
            
            tx = session.beginTransaction();
            if (session.contains(entidad)) session.merge(entidad);
            else session.persist(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

    
    /**
     * Función a fin de actualizar una entidad
     * @param entidad  Entidad a actualizar.
     */
    @Override
    public void actualizar(Entidad entidad) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

        /**
     * Función a fin de eliminar una entidad
     * @param entidad  Entidad a actualizar.
     */
    @Override
    public void eliminar(Entidad entidad) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(entidad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

    /**
     * Elimina una lista de entidades
     * @param lista lista de entidades a eliminar.
     */
    @Override
    public void eliminarLista(List<Entidad> lista) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            lista.forEach(x -> {
                session.remove(x);
            });
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    
     /**
     * Función a fin de opbtener una entidad
     * @param clase el tipo de entidad.
     * @param id id de la entidad.
     */
    @Override
    public Entidad obtener(ID id) {
        Session session = getSession();
        try {
            Entidad entidad = session.get(clase, id);
            return entidad;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Función a fin de obtener todas las entidades
     */
    @Override
    public ArrayList<Entidad> obtenerTodos() {
        Session session = getSession();
        try {
            ArrayList<Entidad> entidades = new ArrayList(session.createQuery("from " + clase.getName(), clase.getClass()).list());
            return entidades;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }
}
