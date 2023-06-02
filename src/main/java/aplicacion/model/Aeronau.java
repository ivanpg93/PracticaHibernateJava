/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Cole
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="aeronau")
public abstract class Aeronau implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int identificadorArcano;
    
    @Column(nullable = false)
    protected String modelo;
    
    @Column(nullable = false)
    protected float mana;
    
    @Column(nullable = false)
    protected Date ultimaRecarga;
    
    @Column(nullable = false)
    protected boolean magiaProhibida;

    @ManyToMany(mappedBy = "aeronaus", cascade = CascadeType.ALL)
    protected List<Missio> missions;
    
    public Aeronau(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        this.identificadorArcano = identificadorArcano;
        this.modelo = modelo;
        this.mana = mana;
        this.ultimaRecarga = ultimaRecarga;
        this.magiaProhibida = magiaProhibida;
    }

    public Aeronau(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        this.modelo = modelo;
        this.mana = mana;
        this.ultimaRecarga = ultimaRecarga;
        this.magiaProhibida = magiaProhibida;
    }

    public Aeronau() {
    }

    public int getIdentificadorArcano() {
        return identificadorArcano;
    }

    public void setIdentificadorArcano(int identificadorArcano) {
        this.identificadorArcano = identificadorArcano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getMana() {
        return mana;
    }

    public List<Missio> getMissions() {
        return missions;
    }

    public void setMissions(List<Missio> missions) {
        this.missions = missions;
    }
    

    public void setMana(float mana) {
        this.mana = mana;
    }

    public Date getUltimaRecarga() {
        return ultimaRecarga;
    }

    public void setUltimaRecarga(Date ultimaRecarga) {
        this.ultimaRecarga = ultimaRecarga;
    }

    public boolean isMagiaProhibida() {
        return magiaProhibida;
    }

    public void setMagiaProhibida(boolean magiaProhibida) {
        this.magiaProhibida = magiaProhibida;
    }

    private boolean recursion = false;
    @Override
    public String toString() {
        return "{" + "identificadorArcano=" + identificadorArcano + ", modelo=" + modelo + ", mana=" + mana + ", ultimaRecarga=" + ultimaRecarga + ", magiaProhibida=" + magiaProhibida + '}';
    }
    
    public String toStringWithObjects(String objectString){
        if(objectString == null) objectString = "";
        else objectString = "\n\tsoldats: {\n" + objectString+"\n";
        
        
        String missionsString = "\n\tmissions: {\n";
        
        for (Missio missio : missions) {
            missionsString+= "\t\t" + missio.toString() + ",\n";
        }
        missionsString += "\t}\n";
        return "{" + "identificadorArcano=" + identificadorArcano + ", modelo=" + modelo + ", mana=" + mana + ", ultimaRecarga=" + ultimaRecarga + ", magiaProhibida=" + magiaProhibida + "," + missionsString + "," + objectString +'}';
    }
}
