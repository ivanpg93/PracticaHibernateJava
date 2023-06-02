/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Mecanic;
import datos.MecanicDAO;
import java.util.ArrayList;

/**
 * Clase que presenta la capa logica de Mecanic.
 * @author Alex
 */
public class MecanicLogic extends LogicLayer{
    
    public MecanicLogic(MecanicDAO dao) {
        super(dao);
    }
    
    public void guardarMecanic(Mecanic mecanic){
         dao.guardar(mecanic);
    }
    
    public void actualizarMecanic(Mecanic mecanic){
        dao.actualizar(mecanic);
    }
    
    public void eliminarMecanic(Mecanic mecanic){
        dao.eliminar(mecanic);
    }
    
    public Mecanic obtenerMecanic(Integer id){
        return (Mecanic) dao.obtener(id);
    }
   
    public ArrayList<Mecanic> obtenerTodosMecanic(){
        return dao.obtenerTodos();
    }
    
}
