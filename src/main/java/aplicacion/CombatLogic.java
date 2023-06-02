/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Combat;
import datos.CombatDAO;
import java.util.ArrayList;

/**
 * Clase que presenta la capa logica de Combat.
 * @author Alex
 */
public class CombatLogic extends LogicLayer{
    
    public CombatLogic(CombatDAO dao) {
        super(dao);
    }
    
    public void guardarCombat(Combat combat){
         dao.guardar(combat);
    }
    
    public void actualizarCombat(Combat combat){
        dao.actualizar(combat);
    }
    
    public void eliminarCombat(Combat combat){
        dao.eliminar(combat);
    }
    
    public Combat obtenerCombat(Integer id){
        return (Combat) dao.obtener(id);
    }
   
    public ArrayList<Combat> obtenerTodosCombat(){
        return dao.obtenerTodos();
    }
    
}
