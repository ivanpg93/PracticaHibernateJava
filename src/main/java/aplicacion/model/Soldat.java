/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Cole
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="soldat")
public abstract class Soldat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer numColegiado;
    @Column
    protected String tipoMagia;
    @Column
    protected float poderMagico;
    @Column
    protected Date fechaRenacimiento;
    @Column
    protected boolean mercenario;

    public Soldat(int numColegiado, String tipoMagia, float poderMagico, Date fechaRenacimiento, boolean mercenario) {
        this.numColegiado = numColegiado;
        this.tipoMagia = tipoMagia;
        this.poderMagico = poderMagico;
        this.fechaRenacimiento = fechaRenacimiento;
        this.mercenario = mercenario;
    }

    public Soldat(String tipoMagia, float poderMagico, Date fechaRenacimiento, boolean mercenario) {
        this.tipoMagia = tipoMagia;
        this.poderMagico = poderMagico;
        this.fechaRenacimiento = fechaRenacimiento;
        this.mercenario = mercenario;
    }

    public Soldat() {
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getTipoMagia() {
        return tipoMagia;
    }

    public void setTipoMagia(String tipoMagia) {
        this.tipoMagia = tipoMagia;
    }

    public float getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(float poderMagico) {
        this.poderMagico = poderMagico;
    }

    public Date getFechaRenacimiento() {
        return fechaRenacimiento;
    }

    public void setFechaRenacimiento(Date fechaRenacimiento) {
        this.fechaRenacimiento = fechaRenacimiento;
    }

    public boolean isMercenario() {
        return mercenario;
    }

    public void setMercenario(boolean mercenario) {
        this.mercenario = mercenario;
    }

    @Override
    public String toString() {
        return "{" + "numColegiado=" + numColegiado + ", tipoMagia=" + tipoMagia + ", poderMagico=" + poderMagico + ", fechaRenacimiento=" + fechaRenacimiento + ", mercenario=" + mercenario + '}';
    }
    
    public String toStringWithObjects(String objectString) {
        if(objectString == null ) objectString = "";
        else objectString = "\n\t\t" + objectString +"\n\t}";
        return "{" + "numColegiado=" + numColegiado + ", tipoMagia=" + tipoMagia + ", poderMagico=" + poderMagico + ", fechaRenacimiento=" + fechaRenacimiento + ", mercenario=" + mercenario + objectString +'}';
    }
}
