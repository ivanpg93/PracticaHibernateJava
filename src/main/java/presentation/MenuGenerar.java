/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import aplicacion.ClassFactory;
import aplicacion.CombatLogic;
import aplicacion.DronLogic;
import aplicacion.GenerarLogic;
import aplicacion.MecanicLogic;
import aplicacion.MissioLogic;
import aplicacion.PilotLogic;
import aplicacion.TransportLogic;
import aplicacion.model.Aeronau;
import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.model.Transport;
import datos.CombatDAO;
import datos.DronDAO;
import datos.MecanicDAO;
import datos.MissioDAO;
import datos.PilotDAO;
import datos.TransportDAO;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase que representa al Menu de Generar Entidades.
 * @author Alex
 */
public abstract class MenuGenerar {

    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);
    private static Scanner sc = new Scanner(System.in);

    /**
     * Función que inicializa el menú
     */
    public static void init() {
        try {
            System.out.println("\nMenú de Generación de Clases (escribe el número correspondiente a tu elección)");
            System.out.println("1. Generar Clase");
            System.out.println("2. Volver");
            System.out.println("3. Salir");

            int option = -1;
            if (sc.hasNextInt()) {
                option = sc.nextInt();
            }

            sc.nextLine();

            switch (option) {
                case 1:
                    generarClases();
                    break;
                case 2:
                    MenuPrincipal.init();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    throw new Exception("Opción invalida.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            init();
        }
    }

    /**
     * Función encargada de mostrar las clases que se pueden generar, hacer preguntas sobre la generación de clases y generarlas.
     */
    private static void generarClases() {
        try {
            do {

                System.out.println("\n¿Qué clase quieres generar? (escribe el número correspondiente a tu elección)");
                System.out.println("1 - Combat");
                System.out.println("2 - Transport");
                System.out.println("3 - Mecanic");
                System.out.println("4 - Missio");
                System.out.println("5 - Dron");
                System.out.println("6 - Pilot");
                System.out.println("7 - Volver");
                System.out.println("8 - Salir");

                int option = -1;
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                }
                sc.nextLine();

                if (option < 0) {
                    throw new Exception("Opción invalida.");
                }
                if (option == 7) {
                    MenuPrincipal.init();
                }
                if (option == 8) {
                    System.exit(0);
                }

                int numAGenerar = -1;
                do {
                    System.out.println("Indica la cantidad de clases a generar.");
                    if (sc.hasNextInt()) {
                        numAGenerar = sc.nextInt();
                    }
                    sc.nextLine();
                } while (numAGenerar < 0);

                List<Object> objetosGenerados = GenerarLogic.generar(option, numAGenerar);

                logger.info("Clase generada correctamente.");
                logger.info("Clases generadas: ");
                
                objetosGenerados.forEach(objeto -> {
                    try {
                        Method toStringWithObjects = objeto.getClass().getMethod("toStringWithObjects",String.class);
                        System.out.println(toStringWithObjects.invoke(objeto, ""));
                    } catch (Exception e) {
                        System.out.println(objeto.toString());
                    }
                    System.out.println("");
                });
                
                System.out.println("\n");
            } while (true);
        } catch (Exception e) {
            logger.error(e.getMessage());
            generarClases();
        }

    }
}
