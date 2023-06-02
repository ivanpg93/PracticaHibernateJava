/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.GenericDAOImpl;

/**
 * Capa logica, se utiliza para no tener que añadir el atributo dao todo el rato.
 * 
 * @author Alex
 */
public class LogicLayer {
    
    //Referencia al dao
    protected GenericDAOImpl dao;

    /**
     * Constructor de la clase, instanciamos el dao.
     * @param dao 
     */
    public LogicLayer(GenericDAOImpl dao) {
        this.dao = dao;
    }
    
}
