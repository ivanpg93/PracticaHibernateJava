/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Pilot;
import datos.PilotDAO;
import java.util.ArrayList;

/**
 * Clase que presenta la capa logica de Pilot.
 * @author Alex
 */
public class PilotLogic extends LogicLayer{
    
    public PilotLogic(PilotDAO dao) {
        super(dao);
    }
    
    public void guardarPilot(Pilot pilot){
         dao.guardar(pilot);
    }
    
    public void actualizarPilot(Pilot pilot){
        dao.actualizar(pilot);
    }
    
    public void eliminarPilot(Pilot pilot){
        dao.eliminar(pilot);
    }
    
    public Pilot obtenerPilot(Integer id){
        return (Pilot) dao.obtener(id);
    }
   
    public ArrayList<Pilot> obtenerTodosPilot(){
        return dao.obtenerTodos();
    }
    
}