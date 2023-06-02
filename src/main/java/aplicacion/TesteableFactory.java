/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.model.Aeronau;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.model.Soldat;
import java.util.List;

/**
 *
 * @author manel
 * 
 * versió 22_23 1.0
 */
public interface TesteableFactory {

    /**
     * Afegeix mecanics a aeronau pilotada
     * @param lo LLista dels mecanics
     * @param p Aeronau
     * @return
     * @throws java.lang.Exception
     */
    Aeronau addMecanicsToPilotada(List<Soldat> lo, Pilotada p) throws Exception;

    /**
     * Afegeix missions a Aeronau
     * @param lm
     * @param a Aeronau
     * @return
     * @throws java.lang.Exception
     */
    Aeronau addMissionsToAeronau(List<Missio> lm, Aeronau a) throws Exception;
    
    
    /***
     * Afegeix aeronaus a la missió
     * @param la
     * @param m
     * @return 
     * @throws java.lang.Exception 
     */
    Missio addAeronausToMissio(List<Aeronau> la, Missio m) throws Exception;

    /**
     * Afegeix pilot a aeronau pilotada
     * @param p aeronau
     * @param a
     * @return
     * @throws java.lang.Exception
     */
    Aeronau addPilotToAeronauPilotada(Pilot p, Pilotada a) throws Exception;

    /**
     * Retorna una instancia del tipus demanat amb dades ficticies
     * Veure
     * @param tipus (Dron, Transport, Combat)
     * @return
     */
    Aeronau aeronauFactory(Class<?> tipus);

    /**
     * REtorna una llista de l'entitat demanada amb dades ficticies
     * @param elements quantitat d'elements a retornar
     * @return
     */
    List<Soldat> mecanicsFactory(int elements);

    /**
     * Retorna una instancia de missio amb dades ficticies
     * @return
     */
    Missio missioFactory();

    /**
     * Retorna una llista de missions amb dades ficticies
     * @param elements quantitat d'elements a retornar
     * @return
     */
    List<Missio> missionsFactory(int elements);

    /**
     * Retorna una llista de pilots amb dades ficticies
     * @param elements quantitat d'elements a retornar
     * @return
     */
    List<Soldat> pilotsFactory(int elements);

    /**
     * Crea una instancia de Mecanic o Pilot segons el paràmetre subministrat
     * @param tipus (macanic o pilot)
     * @return
     */
    Soldat soldatFactory(Class<?> tipus);
    
}
