/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import aplicacion.EliminarLogic;
import java.util.Scanner;

/**
 *Clase abstracta que contiene las funciones de presentacion del apartado eliminar entidades
 * @author joseb
 */
public abstract class MenuEliminar {
    
    //Logica de eliminacion de entidades.
    public static EliminarLogic eliminarLogic = new EliminarLogic();
    
    /**
     * Funcion que muestra el menu principal de eliminar entidades.
     * Muestra 6 opciones respectivas a cada entidad, mas 7 que es para volver.
     * Si el usuario no selecciona la opcion siete volvera a entrar en el menu
     * eliminar entidades.
     * al menu principal de la aplicacion.
     */
    public static void mostrar() {
        
        //Scanner utilizado para obtener los datos del usuario
        Scanner sc = new Scanner(System.in);
        //Opcion elegida
        int opcion = 0;
        
        //Un bucle que se repite hasta que no se selecciona la opcion 7 (volver)
        while (opcion != 7) {
            System.out.println("\n****ELIMINAR ENTIDADES");
            System.out.println("---ENTIDADES---");
            System.out.println("1. Combat");
            System.out.println("2. Transport");
            System.out.println("3. Mecanic");
            System.out.println("4. Missió");
            System.out.println("5. Pilot");
            System.out.println("6: Dron");
            System.out.println("7. Voler");
            System.out.print("Seleccione una opción: ");
            try {
                //Obtenemos por teclado la ocpion del usuario
                opcion = sc.nextInt();
                sc.nextLine();
                //Comprovamos que la opción este dentro del rango disponible 1-7
                //En caso de dato incorrecto avisamos al usuario por consola
                //En caso de dato correcto ejecutamos subMenu() siempre que la opcion
                //no sea volver (7)
                if (opcion < 1 || opcion > 7) {
                    System.out.println("La opción seleccionada no es válida, por favor ingrese un número del 1 al 7.");
                } else {
                    if (opcion < 7) {
                        //Llamamos al menu que pedira las ids
                        subMenu(opcion);
                    }
                    else MenuPrincipal.init();
                }
            } catch (Exception e) {
                //En caso de que el usuario introduza una opcion de formato incorrecto
                //Saltara la exception y se avisara al usuario del error.
                System.out.println("La opción seleccionada no es válida, por favor ingrese un número del 1 al 7.");
                sc.nextLine();
            }
        }

    }
    
    /**
     * Muestra el menu para que el usuario seleccione el rango de eliminación
     * @param opcion entidad seleccionada por el usuario 1-6
     */
    private static void subMenu(int opcion) {
        
        Scanner sc = new Scanner(System.in);
        
        //Id inicial del rango de eliminación
        int id_inicial = 0;
        //Id final del rango de eliminacion
        int id_final = 0;
        
        //Si la id es valida: id_inicial < id_final, ninguna negativa
        boolean idValida = false;

        while (!idValida) {
            try {
                System.out.print("Introduzca la id inical: ");
                id_inicial = sc.nextInt();
                sc.nextLine();
                System.out.print("Introduzca la id final: ");
                id_final = sc.nextInt();
                sc.nextLine();
                //Comprovamos que la id sea valida
                if (id_inicial >= 0 && id_final >= 0 && id_inicial < id_final) {
                    idValida = true;
                } else {
                    System.out.println("La ids  introducidas no cumplen las condiciones. La id incial debe ser menor que la id final y ambos no deben ser negativos. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Los valores introducidos no son válidos. Inténtalo de nuevo.");
                sc.nextLine();
            }
        }
        
        //Llamamos a la capa logica para eliminar las entidades
        eliminarLogic.eliminar(opcion, id_inicial, id_final);
    }

}
