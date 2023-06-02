/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Cole
 */
@Entity
@Table(name="combat")
public class Combat extends Pilotada implements TesteableEntity, Serializable{
    
    private static final long serialVersionUID = 1L;
    public Combat(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(identificadorArcano, modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Combat(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Combat() {
    }
    
    @Override
    public Integer getAtributIdentificador() {
        return identificadorArcano;
    }

    @Override
    public String getAtributString() {
        return modelo;
    }

    @Override
    public Float getAtributFloat() {
        return mana;
    }

    @Override
    public Date getAtributDate() {
        return ultimaRecarga;
    }

    @Override
    public Boolean getAtributBoolean() {
        return magiaProhibida;
    }

    @Override
    public void setAtributString(String s) {
        this.modelo = s;
    }

    @Override
    public void setAtributFloat(Float f) {
        this.mana = f;
    }

    @Override
    public void setAtributDate(Date d) {
        this.ultimaRecarga = d;
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        this.magiaProhibida = b;
    }
    
    @Override
    public String toString() {
        return "Combat " + super.toString();
    }
    
}
