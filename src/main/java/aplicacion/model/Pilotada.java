/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cole
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="pilotada")
public abstract class Pilotada extends Aeronau implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToOne(optional = true,cascade = CascadeType.ALL)
    private Pilot pilotAeronau;

    @OneToMany(mappedBy = "pilotada", cascade = CascadeType.ALL)
    private List<Mecanic> mecanics = new ArrayList<>();

    public Pilotada(int identificadorArcano, String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(identificadorArcano, modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Pilotada(String modelo, float mana, Date ultimaRecarga, boolean magiaProhibida) {
        super(modelo, mana, ultimaRecarga, magiaProhibida);
    }

    public Pilotada() {
    }

    public Pilot getPilotAeronau() {
        return pilotAeronau;
    }

    public void setPilot(Pilot pilot) {
        this.pilotAeronau = pilot;
    }

    public List<Mecanic> getMecanics() {
        return mecanics;
    }

    public void setMecanics(ArrayList<Mecanic> mecanics) {
        this.mecanics = mecanics;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toStringWithObjects(String objectString) {
        objectString = pilotAeronau.toString();
        return super.toStringWithObjects(objectString);
    }
}
