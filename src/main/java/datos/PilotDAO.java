/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.Pilot;

/**
 * DAO para la clase Pìlot. Extiende del GenericDAOImpl
 */
public class PilotDAO extends GenericDAOImpl<Pilot, Integer>{
    
    public PilotDAO() {
        super(Pilot.class);
    }
    
}
