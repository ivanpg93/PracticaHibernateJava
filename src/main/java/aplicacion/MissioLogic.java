/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Missio;
import datos.MissioDAO;
import java.util.ArrayList;

/**
 * Clase que presenta la capa logica de Missio.
 * @author Alex
 */
public class MissioLogic extends LogicLayer{
    
    public MissioLogic(MissioDAO dao) {
        super(dao);
    }
    
    public void guardarMissio(Missio missio){
         dao.guardar(missio);
    }
    
    public void actualizarMissio(Missio missio){
        dao.actualizar(missio);
    }
    
    public void eliminarMissio(Missio missio){
        dao.eliminar(missio);
    }
    
    public Missio obtenerMissio(Integer id){
        return (Missio) dao.obtener(id);
    }
   
    public ArrayList<Missio> obtenerTodosMissio(){
        return dao.obtenerTodos();
    }
    
}
