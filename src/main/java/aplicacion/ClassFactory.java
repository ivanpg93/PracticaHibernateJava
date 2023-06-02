/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Aeronau;
import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.model.Soldat;
import aplicacion.model.Transport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.JavaFaker;

/**
 *
 * @author Cole
 */
public class ClassFactory implements TesteableFactory {

    @Override
    public Aeronau addMecanicsToPilotada(List<Soldat> lo, Pilotada p) throws Exception {
        if (lo.size() < 0 || lo.size() > 2) {
            throw new Exception("El valor debe estar entre 0 y 2");
        }
        ArrayList<Mecanic> mecanic = new ArrayList<>();
        lo.forEach(e -> {
            ((Mecanic) e).setPilotada(p);
            mecanic.add((Mecanic) e);
        });
        p.setMecanics(mecanic);
        return p;
    }

    /**
     * Asigna una lista de misiones a una aeronave
     *
     * @param lm lista de misiones
     * @param a aeronave a le que asignamos las misiones
     * @return devuele la aeronave con las misiones asignadas
     * @throws Exception si lm contiene mas de dos misiones
     */
    @Override
    public Aeronau addMissionsToAeronau(List<Missio> lm, Aeronau a) throws Exception {

        // Recorro la lista de misiones lm, comprovando que cada mission tenga
        // menos de 8 aeronaves asignadas:
        // En caso de que la mision tenga mas de 8, se elimina de la lista,
        //en caso contrario se le asigna la aeronave
        lm.forEach(m -> {

            if (m.getAeronaus().size() > 7) {
                lm.remove(m);
            } else {
                m.getAeronaus().add(a);
            }
        });

        //Compruevo que la lista de misiones de la aeronave exista
        if (a.getMissions() != null) {
            List<Missio> missions = a.getMissions();
            if (lm.size() > 2) {
                throw new Exception("Como maximo se pueden añadir 2 misiones");
            }

            //Anyadimos la lista lm a la lista de misiones de la aeronave
            missions.addAll(lm);

            //Vamos eliminando la primera mission de la lista de misiones 
            //de la aeronave hasta que queden solo 2 misiones.
            //tambien eliminamos de la mision(eliminada) la aeronave
            while (missions.size() > 2) {
                missions.get(0).getAeronaus().remove(a);
                missions.remove(0);

            }
        } else {
            //Como la lista no existe, simplemente le asigno la lista lm
            if(lm.size() > 2) throw new Exception("No pueden haber más de dos misiones a la vez.");
            a.setMissions(lm);
        }

        return a;
    }

    @Override
    public Missio addAeronausToMissio(List<Aeronau> la, Missio m) throws Exception {
        // Recorro la lista de aeronaves la, comprovando que cada aeronave tenga
        // menos de 2 misiones asignadas:
        // En caso de que la aeronave tenga mas de 2, se elimina de la lista,
        //en caso contrario se le asigna la mision
        la.forEach(a -> {
            if (a.getMissions().size() > 1) {
                la.remove(a);
            } else {
                a.getMissions().add(m);
            }
        });

        //Compruevo que la lista de aeronaves de la mision exista
        if (m.getAeronaus() != null) {

            //Obtenemos la lista de aeronaves de la mision
            ArrayList<Aeronau> aeronaus = (ArrayList<Aeronau>) m.getAeronaus();

            //Comprovamos que la lista de aeronaves la no tenga mas de 8
            //En caso de que tenga mas de dos, salta una exception y la operacion
            //se cancela
            if (la.size() > 8) {
                throw new Exception("Como maximo se pueden asignar 8 aeronaves a la mision");
            }

            //Anyadimos la lista la a la lista de aeronaves de la mision
            aeronaus.addAll(la);

            //Vamos eliminando la primera aeronave de la lista de aeronaves 
            //de la mision hasta que queden solo 8 aeronaves.
            //tambien eliminamos de la aeronave(eliminada) de la mision
            while (aeronaus.size() > 8) {
                aeronaus.get(0).getMissions().remove(m);
                aeronaus.remove(0);

            }
        } else {
            //Como la lista no existe, simplemente le asigno la lista lm
            m.setAeronaus(la);
        }

        return m;
    }

    @Override
    public Aeronau addPilotToAeronauPilotada(Pilot p, Pilotada a) throws Exception {
        a.setPilot(p);
        p.setPilotada(a);
        return a;
    }

    public ClassFactory() {
    }

    /**
     * Función que devuelve una nave del tipo de clase especificada.
     * @param tipus tipo de nave
     * @return Aeronave de ese tipo.
     */
    @Override
    public Aeronau aeronauFactory(Class<?> tipus) {
        Aeronau aeronau = null;
        if (tipus.equals(Dron.class)) {
            aeronau = JavaFaker.generarDron();
        } else if (tipus.equals(Combat.class)) {
            aeronau = JavaFaker.generarCombat();
        } else if (tipus.equals(Transport.class)) {
            aeronau = JavaFaker.generarTransport();
        }
        return aeronau;
    }

    /**
     * Función que genera y devuelve un listado de soldados.
     * @param elements número de soldados a generar.
     * @return lista con el numero de soldados.
     */
    @Override
    public List<Soldat> mecanicsFactory(int elements) {
        List<Soldat> lista = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            lista.add(JavaFaker.generarMecanic());
        }
        return lista;
    }

    @Override
    public Missio missioFactory() {
        return JavaFaker.generarMissio();
    }

    @Override
    public List<Missio> missionsFactory(int elements) {
        List<Missio> lista = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            lista.add(JavaFaker.generarMissio());
        }
        return lista;
    }

    @Override
    public List<Soldat> pilotsFactory(int elements) {
        List<Soldat> lista = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            lista.add(JavaFaker.generarPilot());
        }
        return lista;
    }

    @Override
    public Soldat soldatFactory(Class<?> tipus) {
        Random rnd = new Random();
        int rand = rnd.nextInt(2);
        Pilotada pilotada = null;

        if (rand == 0) {
            pilotada = JavaFaker.generarCombat();
        } else {
            pilotada = JavaFaker.generarTransport();
        }

        Soldat soldat = null;
        if (tipus.equals(Mecanic.class)) {
            soldat = JavaFaker.generarMecanic();
            ((Mecanic) soldat).setPilotada(pilotada);
        } else if (tipus.equals(Pilot.class)) {
            soldat = JavaFaker.generarPilot();
        }

        return soldat;
    }

}
