/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.Dron;

/**
 * DAO para la clase Dron. Extiende del GenericDAOImpl
 */
public class DronDAO extends GenericDAOImpl<Dron, Integer>{
    
    public DronDAO() {
        super(Dron.class);
    }
    
}
