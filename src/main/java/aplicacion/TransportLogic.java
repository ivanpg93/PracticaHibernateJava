/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Transport;
import datos.TransportDAO;
import java.util.ArrayList;

/**
 * Clase que presenta la capa logica de Transport.
 * @author Alex
 */
public class TransportLogic extends LogicLayer{
    
    public TransportLogic(TransportDAO dao) {
        super(dao);
    }
    
    public void guardarTransport(Transport transport){
         dao.guardar(transport);
    }
    
    public void actualizarTransport(Transport transport){
        dao.actualizar(transport);
    }
    
    public void eliminarTransport(Transport transport){
        dao.eliminar(transport);
    }
    
    public Transport obtenerTransport(Integer id){
        return (Transport) dao.obtener(id);
    }
   
    public ArrayList<Transport> obtenerTodosTransport(){
        return dao.obtenerTodos();
    }
    
}
