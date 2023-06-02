/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.Combat;

/**
 * DAO para la clase Combat. Extiende del GenericDAOImpl
 */
public class CombatDAO extends GenericDAOImpl<Combat, Integer>{
    
    public CombatDAO() {
        super(Combat.class);
    }
    
}
