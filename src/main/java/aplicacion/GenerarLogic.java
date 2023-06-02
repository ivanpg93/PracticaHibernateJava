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
import aplicacion.model.Transport;
import datos.CombatDAO;
import datos.DronDAO;
import datos.MecanicDAO;
import datos.MissioDAO;
import datos.PilotDAO;
import datos.TransportDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.hibernate.internal.CoreLogging.logger;
import presentation.MenuPrincipal;

/**
 * Logica del menu de generación
 *
 * @author Alex
 */
public class GenerarLogic {

    private static CombatLogic combatLogic = new CombatLogic(new CombatDAO());
    private static DronLogic dronLogic = new DronLogic(new DronDAO());
    private static MecanicLogic mecanicLogic = new MecanicLogic(new MecanicDAO());
    private static MissioLogic missioLogic = new MissioLogic(new MissioDAO());
    private static PilotLogic pilotLogic = new PilotLogic(new PilotDAO());
    private static TransportLogic transportLogic = new TransportLogic(new TransportDAO());
    private static Scanner sc = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(GenerarLogic.class);

    public static List<Object> generar(int option, int numAGenerar) throws Exception {

        List<Object> objetosGenerados = new ArrayList<>();

        ClassFactory classFactory = new ClassFactory();

        switch (option) {
            case 1:

                System.out.println("Esta clase tienen entidades asociadas de tipo Missio: ");

                int entidadesRelacionAGenerar = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Missio quieres agregar a la nave? [min 1, max 2]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerar = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerar < 0 && entidadesRelacionAGenerar > 2);

                logger.info("Generando clases...");
                for (int i = 0; i < numAGenerar; i++) {
                    Pilotada aeronau = (Pilotada) classFactory.aeronauFactory(Combat.class);
                    Pilot pilot = (Pilot) classFactory.soldatFactory(Pilot.class);
                    classFactory.addPilotToAeronauPilotada(pilot, aeronau);
                    List<Missio> missions = classFactory.missionsFactory(entidadesRelacionAGenerar);
                    classFactory.addMissionsToAeronau(missions, aeronau);

                    combatLogic.guardarCombat((Combat) aeronau);

                    objetosGenerados.add(aeronau);
                }

                break;
            case 2:
                System.out.println("Esta clase tienen entidades asociadas de tipo Missio: ");
                entidadesRelacionAGenerar = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Missio quieres agregar a la nave? [min 1, max 2]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerar = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerar < 0 && entidadesRelacionAGenerar > 2);

                logger.info("Generando clases...");
                for (int i = 0; i < numAGenerar; i++) {
                    Pilotada aeronau = (Pilotada) classFactory.aeronauFactory(Transport.class);
                    Pilot pilot = (Pilot) classFactory.soldatFactory(Pilot.class);
                    classFactory.addPilotToAeronauPilotada(pilot, aeronau);
                    List<Missio> missions = classFactory.missionsFactory(entidadesRelacionAGenerar);
                    classFactory.addMissionsToAeronau(missions, aeronau);

                    transportLogic.guardarTransport((Transport) aeronau);

                    objetosGenerados.add(aeronau);

                }
                break;
            case 3:
                System.out.println("Esta clase tiene una entidad asocidada de tipo Pilotada la cual tiene entidades de tipo Missio asociadas: ");
                entidadesRelacionAGenerar = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Missio quieres agregar a la nave? [min 1, max 2]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerar = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerar < 0 && entidadesRelacionAGenerar > 2);

                logger.info("Generando clases...");
                for (int i = 0; i < numAGenerar; i++) {
                    Mecanic mecanic = (Mecanic) classFactory.soldatFactory(Mecanic.class);
                    List<Missio> missions = classFactory.missionsFactory(entidadesRelacionAGenerar);
                    Pilotada pilotada = null;

                    int randomNum = (int) (Math.random() * 2 + 1);
                    if (randomNum == 1) {
                        pilotada = (Pilotada) classFactory.aeronauFactory(Transport.class);
                    } else {
                        pilotada = (Pilotada) classFactory.aeronauFactory(Combat.class);
                    }

                    classFactory.addPilotToAeronauPilotada((Pilot) classFactory.soldatFactory(Pilot.class), pilotada);
                    classFactory.addMissionsToAeronau(missions, pilotada);

                    mecanic.setPilotada(pilotada);
                    mecanicLogic.guardarMecanic(mecanic);

                    objetosGenerados.add(mecanic);
                }
                break;
            case 4:
                System.out.println("Esta clase tiene entidades asocidadas de tipo Aeronau");
                entidadesRelacionAGenerar = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Aeronau quieres agregar a  Missio? [min 1, max 8]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerar = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerar < 0 && entidadesRelacionAGenerar > 8);

                logger.info("Generando clases...");
                List<Missio> missions = classFactory.missionsFactory(numAGenerar);

                for (Missio missio : missions) {
                    List<Aeronau> aeronaus = new ArrayList<>();

                    for (int i = 0; i < entidadesRelacionAGenerar; i++) {
                        int randomNum = (int) (Math.random() * 3 + 1);
                        Aeronau aeronau = null;

                        switch (randomNum) {
                            case 1:
                                aeronau = classFactory.aeronauFactory(Combat.class);
                                break;
                            case 2:
                                aeronau = classFactory.aeronauFactory(Transport.class);
                                break;
                            default:
                                aeronau = classFactory.aeronauFactory(Dron.class);
                                break;
                        }
                        aeronau.setMissions(Arrays.asList(missio));
                        aeronaus.add(aeronau);
                    }

                    missio.setAeronaus(aeronaus);
                    missioLogic.guardarMissio(missio);

                    objetosGenerados.add(missio);
                }
                break;
            case 5:
                System.out.println("Esta clase tienen entidades asociadas de tipo Missio: ");

                entidadesRelacionAGenerar = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Missio quieres agregar a la nave? [min 1, max 2]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerar = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerar < 0 && entidadesRelacionAGenerar > 2);

                logger.info("Generando clases...");
                for (int i = 0; i < numAGenerar; i++) {
                    Dron dron = (Dron) classFactory.aeronauFactory(Dron.class);

                    missions = classFactory.missionsFactory(entidadesRelacionAGenerar);

                    classFactory.addMissionsToAeronau(missions, dron);

                    dronLogic.guardarDron(dron);

                    objetosGenerados.add(dron);

                }
                break;
            case 6:
                System.out.println("Esta clase tienen entidades asociadas de tipo Mecanic en la entidad Pilotada: ");
                int entidadesRelacionAGenerarMecanic = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Mecanic quieres agregar a la nave? [min 1, max 2]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerarMecanic = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerarMecanic < 0 && entidadesRelacionAGenerarMecanic > 2);

                System.out.println("Esta clase tienen entidades asociadas de tipo Missio en la entidad Pilotada: ");
                int entidadesRelacionAGenerarMissio = -1;
                do {
                    System.out.println("¿Cuantas Entidades de tipo Missio quieres agregar a la nave? [min 1, max 2]");
                    if (sc.hasNextInt()) {
                        entidadesRelacionAGenerarMissio = sc.nextInt();
                    }
                    sc.nextLine();
                } while (entidadesRelacionAGenerarMissio < 0 && entidadesRelacionAGenerarMissio > 2);

                logger.info("Generando clases...");
                for (int i = 0; i < numAGenerar; i++) {
                    missions = classFactory.missionsFactory(entidadesRelacionAGenerarMissio);
                    Pilotada pilotada = null;

                    int randomNum = (int) (Math.random() * 2 + 1);
                    if (randomNum == 1) {
                        pilotada = (Pilotada) classFactory.aeronauFactory(Transport.class);
                    } else {
                        pilotada = (Pilotada) classFactory.aeronauFactory(Combat.class);
                    }

                    Pilot pilot = (Pilot) classFactory.soldatFactory(Pilot.class);

                    classFactory.addPilotToAeronauPilotada(pilot, pilotada);
                    classFactory.addMissionsToAeronau(missions, pilotada);
                    classFactory.addMecanicsToPilotada(classFactory.mecanicsFactory(entidadesRelacionAGenerarMecanic), pilotada);

                    pilot.setPilotada(pilotada);

                    pilotLogic.guardarPilot(pilot);

                    objetosGenerados.add(pilot);
                }

                break;
            default:
                throw new Exception("Opción invalida.");

        }
        return objetosGenerados;
    }
}
