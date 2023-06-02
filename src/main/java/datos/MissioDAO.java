/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.Missio;

/**
 * DAO para la clase Missio. Extiende del GenericDAOImpl
 */
public class MissioDAO extends GenericDAOImpl<Missio, Integer>{
    
    public MissioDAO() {
        super(Missio.class);
    }
    
}
