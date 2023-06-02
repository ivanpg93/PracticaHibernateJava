/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package aplicacion;

import java.lang.reflect.InvocationTargetException;
import presentation.MenuPrincipal;

import presentation.MenuCredenciales;

/**
 *
 * @author Cole
 */
public class M06uf2pracma {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalAccessException, InvocationTargetException {
        MenuCredenciales.init();      
        MenuPrincipal.init();
    }

}