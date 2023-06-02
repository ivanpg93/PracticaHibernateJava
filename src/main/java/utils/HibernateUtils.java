/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para crear una sesión de hibernate según los datos
 * proporcionados por el usuario.
 * 
 * @author Alex
 */
public class HibernateUtils {
    private static final Logger logger = LogManager.getLogger(HibernateUtils.class);
    private static SessionFactory sessionFactory;
    
    private static HibernateUtils instance;
    
    public static HibernateUtils getInstance() {
        if(instance == null) {
            instance = new HibernateUtils();
        }
        return instance;
    }
        
    /**
     * Crea la configuración de Hibernate con el usuario, contraseña y base de datos.
     * @param username usuario
     * @param password contraseña
     * @param database base de datos.
     */
    public void setSetSessionFactory(String username, String password, String database) {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.username", username);
            configuration.setProperty("hibernate.connection.password", password);
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + database+"?createDatabaseIfNotExist=true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            logger.error(": "+e.getMessage());
            throw e;
        }

    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
}
