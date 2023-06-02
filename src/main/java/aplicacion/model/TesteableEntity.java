/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.model;

import java.sql.Date;

/**
 *
 * @author manel
 * 
 * versió 22_23 1.0
 */
public interface TesteableEntity {
    
     /***
     * Retorna la dada de l'atribut associat al tipus requerit
     * @return 
     */
    Integer getAtributIdentificador();
       
    /***
     * Retorna la dada de l'atribut associat al tipus requerit
     * @return 
     */
    String getAtributString();
    
    /***
     * Retorna la dada de l'atribut associat al tipus requerit
     * @return 
     */
    Float getAtributFloat();
    
   /***
     * Retorna la dada de l'atribut associat al tipus requerit
     * @return 
     */
    Date getAtributDate();
    
   /***
     * Retorna la dada de l'atribut associat al tipus requerit
     * @return 
     */
    Boolean getAtributBoolean();
    
    /***
     * Estableix la dada de l'atribut associat al tipus requerit
     * @param s
     */
    void setAtributString(String s);
    
     /***
     * Estableix la dada de l'atribut associat al tipus requerit
     * @param f
     */
    void setAtributFloat(Float f);
    
     /***
     * Estableix la dada de l'atribut associat al tipus requerit
     * @param d
     */
    void setAtributDate(Date d);
    
     /***
     * Estableix la dada de l'atribut associat al tipus requerit
     * @param b
     */
    void setAtributBoolean(Boolean b);
    
}
