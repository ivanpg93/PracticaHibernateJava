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
@Table(name="dron")
public class Dron extends Autonoma implements TesteableEntity, Serializable {

    private static final long serialVersionUID = 1L;

    public Dron(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(identificadorArcano, modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Dron(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Dron() {
    }

    @Override
    public Integer getAtributIdentificador() {
        return this.identificadorArcano;
    }

    @Override
    public String getAtributString() {
        return this.modelo;
    }

    @Override
    public Float getAtributFloat() {
        return this.mana;
    }

    @Override
    public Date getAtributDate() {
        return this.ultimaRecarga;
    }

    @Override
    public Boolean getAtributBoolean() {
        return this.magiaProhibida;
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
        return "Dron " + super.toString();
    }

}
