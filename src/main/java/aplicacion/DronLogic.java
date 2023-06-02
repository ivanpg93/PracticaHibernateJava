/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Dron;
import datos.DronDAO;
import java.util.ArrayList;

/**
 * Clase que presenta la capa logica de Dron.
 * @author Alex
 */
public class DronLogic extends LogicLayer{
    
    public DronLogic(DronDAO dao) {
        super(dao);
    }
    
    public void guardarDron(Dron dron){
         dao.guardar(dron);
    }
    
    public void actualizarDron(Dron dron){
        dao.actualizar(dron);
    }
    
    public void eliminarDron(Dron dron){
        dao.eliminar(dron);
    }
    
    public Dron obtenerDron(Integer id){
        return (Dron) dao.obtener(id);
    }
   
    public ArrayList<Dron> obtenerTodosDron(){
        return dao.obtenerTodos();
    }
    
}
