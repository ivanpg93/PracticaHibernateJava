/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.Mecanic;

/**
 * DAO para la clase Mecanic. Extiende del GenericDAOImpl
 */
public class MecanicDAO extends GenericDAOImpl<Mecanic, Integer>{
    
    public MecanicDAO() {
        super(Mecanic.class);
    }
    
}
