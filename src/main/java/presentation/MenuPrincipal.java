/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static presentation.MenuListar.menuListar;

/**
 *
 * @author Alex
 * Menú encargado de mostrar las tres opciones disponibles.
 */
public abstract class MenuPrincipal {
    
    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);
    
    /**
     * Inicializa el menu, Dando las opciones al usuario. Si la opción es incorrecta la función se repite indefinidamente.
     */
    public static void init(){
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("\nSelecciona una de las siguiente opciones sobre las clases: ");
            System.out.println("1. Generar Clases");
            System.out.println("2. Eliminar Clases");
            System.out.println("3. Listar Clases");
            System.out.println("4. Salir");
            
            int option = -1;
            
            if(sc.hasNextInt()) option = sc.nextInt();
            sc.nextLine();
            
            switch (option) {
                case 1:
                    MenuGenerar.init();
                    break;
                case 2:
                    MenuEliminar.mostrar();
                    break;
                case 3:
                    menuListar();
                    break;
                case 4:
                    logger.info("Hasta la próxima!!");
                    System.exit(0);
                    break;
                default:
                    throw new Exception("Opción no válida. Vuelve a indica una opción: ");
            }
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            init();
        }
    }
}
