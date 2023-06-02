/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Clase encargada de generar una única sesión para Hibernate
 * IMPORTANTE: AÑADIR USERNAME, PASSWORD Y DATABASE EN LA FUNCIÓN init()
 * @author ivan
 */
public class SingleSession {
    private static Session sessio;
    private static SingleSession singleSession;
    private static SessionFactory factory;
    private static final Logger logger = LogManager.getLogger(SingleSession.class);
    
    private SingleSession() {
        init();
    }

    /**
     * Función que inicializa la sessión creado una factoria sobre los datos de acceso a la DB
     */
    private void init(){
        if(HibernateUtils.getInstance().getSessionFactory() == null){
            HibernateUtils.getInstance().setSetSessionFactory("root", "1234", "test");
        }
        factory = HibernateUtils.getInstance().getSessionFactory();
        sessio =  factory.openSession();
    }
    
    /**
     * Función encargada de crear una instancia de la clase. Si ya existe devuelve la misma, si no la crea.
     * @return 
     */
    public static SingleSession getInstance() {
        if(singleSession == null) {
            singleSession = new SingleSession();
        }
        
        return singleSession;
    }

    /**
     * Función encargada de cerrar la sesión.
     */
    public static void closeSession(){
        if(sessio != null) sessio.close();
    }
    
    /**
     * Función encargada de obtener la sesión. Si la sesión ya está abierta, la cierra y la vuelve a crear.
     * @return Sesión a la BD
     */
    public Session getSessio() {
        if(sessio.getTransaction().isActive()){
            closeSession();
            init();
        }
        if(!sessio.isOpen()) sessio = factory.openSession();
        return sessio;
    }
    
    /**
     * Función encargada de asignar una sesión.
     * @param sessio 
     */
    public void setSessio(Session sessio) {
        this.sessio = sessio;
    }
    
    //Sobreescribimos el método clone, para que no se pueda clonar un objeto de esta clase
    @Override
    public SingleSession clone() throws CloneNotSupportedException {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            logger.error("No se puede clonar un objeto de la clase SingleSession");
        }
        return null;
    }
    
}
