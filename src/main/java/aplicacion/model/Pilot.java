/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Cole
 */
@Entity
@Table(name="pilot")
public class Pilot extends Soldat implements TesteableEntity, Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToOne(optional = true,mappedBy = "pilotAeronau", cascade = CascadeType.ALL)
    private Pilotada pilotada;
    

    public Pilot(int numColegiado, String tipoMagia, float poderMagico, Date fechaRenacimiento, boolean mercenario) {
        super(numColegiado, tipoMagia, poderMagico, fechaRenacimiento, mercenario);
    }

    public Pilot(String tipoMagia, float poderMagico, Date fechaRenacimiento, boolean mercenario) {
        super(tipoMagia, poderMagico, fechaRenacimiento, mercenario);
    }

    public Pilot() {
    }

    public void setPilotada(Pilotada pilotada) {
        this.pilotada = pilotada;
    }

    @Override
    public Integer getAtributIdentificador() {
        return getNumColegiado();
    }

    @Override
    public String getAtributString() {
        return getTipoMagia();
    }

    @Override
    public Float getAtributFloat() {
        return getPoderMagico();
    }

    @Override
    public Date getAtributDate() {
        return getFechaRenacimiento();
    }

    @Override
    public Boolean getAtributBoolean() {
        return isMercenario();
    }

    @Override
    public void setAtributString(String s) {
        this.tipoMagia = s;
    }

    @Override
    public void setAtributFloat(Float f) {
        this.poderMagico = f;
    }

    @Override
    public void setAtributDate(Date d) {
        this.fechaRenacimiento = d;
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        this.mercenario = b;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toStringWithObjects(String objectString) {
        return "Pilot " + super.toStringWithObjects(pilotada.toString());
    }
    
}
