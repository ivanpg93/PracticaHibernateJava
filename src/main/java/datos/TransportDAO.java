/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.Transport;

/**
 * DAO para la clase Transport. Extiende del GenericDAOImpl
 */
public class TransportDAO extends GenericDAOImpl<Transport, Integer>{
    
    public TransportDAO() {
        super(Transport.class);
    }
    
}
