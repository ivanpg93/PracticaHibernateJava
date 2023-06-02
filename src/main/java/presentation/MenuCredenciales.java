/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.HibernateUtils;

/**
 *
 * @author Alex
 * 
 * Menú encargado de pedir las credenciales y generar la sessión.
 */
public abstract class MenuCredenciales {
    
    private static final Logger logger = LogManager.getLogger(HibernateUtils.class);
    
    /**
     * Inicializa el menú preguntado las credenciales.Si son correctas se genera la sessión de Hibernate.
     */
    public static void init(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre de la BBDD: ");
            String database = sc.nextLine();
            System.out.println("Introduce el usuario de la BBDD: ");
            String username = sc.nextLine();
            System.out.println("Introduce la contrasenya de la BBDD: ");
            String password = sc.nextLine();
        
            logger.info("Realizando Conexión...");
            HibernateUtils.getInstance().setSetSessionFactory(username, password, database);
        } catch (Exception e) {
            init();
        }

        logger.info("Conexión realizada correctamente.");
    }
}
