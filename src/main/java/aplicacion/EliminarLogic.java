/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Combat;
import aplicacion.model.Dron;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Transport;
import datos.CombatDAO;
import datos.DronDAO;
import datos.GenericDAOImpl;
import datos.MecanicDAO;
import datos.MissioDAO;
import datos.PilotDAO;
import datos.TransportDAO;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import utils.HibernateUtils;
import utils.SingleSession;

/**
 *Capa logica que se encarga de comunicarse con el DAO para eliminar las entidades.
 * @author joseb
 */
public class EliminarLogic {

    private static Session sesion = SingleSession.getInstance().getSessio();
    private static final Logger logger = LogManager.getLogger(HibernateUtils.class);
    
    /**
     * Funcion que elimina una lista de entidades de la BD segun la opcion
     * @param opcion entidad 1-6
     * @param id_inicial id incial del rango
     * @param id_final  id final del rango
     */
    public void eliminar(int opcion, int id_inicial, int id_final) {
        sesion = SingleSession.getInstance().getSessio();
        logger.info("Eliminando los registros...");

        switch (opcion) {
            case 1:
                //Obtenemos todas las entidades de la bd
                List<Combat> llistaCombat = sesion.createQuery("from " + "Combat", Combat.class).list();
                //Filtramos las entidades por id inicial y id final
                List<Combat> llistaFiltradaCombat = llistaCombat.stream().filter(x -> x.getAtributIdentificador() >= id_inicial && x.getAtributIdentificador() <= id_final).toList();
                
                //Eliminamos a traves de la capa dao las entidades filtradas (Cascada)
                CombatDAO daoCombat = new CombatDAO();            
                daoCombat.eliminarLista(llistaFiltradaCombat);
                
                //Informamos de los registros eliminados, en este caso solo se muestras las entidades
                //eliminas selecciondas, todos los registros eliminados.
                logger.info("Registros eliminados:");
                logger.info(llistaFiltradaCombat);

                break;
            case 2:
                List<Transport> llistaTransport = sesion.createQuery("from " + "Transport", Transport.class).list();
                List<Transport> llistaFiltradaTransport = llistaTransport.stream().filter(x -> x.getAtributIdentificador() >= id_inicial && x.getAtributIdentificador() <= id_final).toList();
                TransportDAO daoTransport = new TransportDAO();
                daoTransport.eliminarLista(llistaFiltradaTransport);
                logger.info("Registros eliminados:");
                logger.info(llistaFiltradaTransport);
                break;
            case 3:
                List<Mecanic> llistatMecanic = sesion.createQuery("from " + "Mecanic", Mecanic.class).list();
                List<Mecanic> llistaFiltradaMecanic = llistatMecanic.stream().filter(x -> x.getAtributIdentificador() >= id_inicial && x.getAtributIdentificador() <= id_final).toList();
                MecanicDAO daoMecanic = new MecanicDAO();
                daoMecanic.eliminarLista(llistaFiltradaMecanic);
                logger.info("Registros eliminados:");
                logger.info(llistaFiltradaMecanic);
                break;
            case 4:
                List<Missio> llistatMissio = sesion.createQuery("from " + "Missio", Missio.class).list();
                List<Missio> llistaFiltradaMissio = llistatMissio.stream().filter(x -> x.getAtributIdentificador() >= id_inicial && x.getAtributIdentificador() <= id_final).toList();
                MissioDAO daoMissio = new MissioDAO();
                daoMissio.eliminarLista(llistaFiltradaMissio);
                logger.info("Registros eliminados:");
                logger.info(llistaFiltradaMissio);
                break;
            case 5:
                List<Pilot> llistatPilot = sesion.createQuery("from " + "Pilot", Pilot.class).list();
                List<Pilot> llistaFiltradaPilot = llistatPilot.stream().filter(x -> x.getAtributIdentificador() >= id_inicial && x.getAtributIdentificador() <= id_final).toList();
                PilotDAO daoPilot = new PilotDAO();
                daoPilot.eliminarLista(llistaFiltradaPilot);
                logger.info("Registros eliminados:");
                logger.info(llistaFiltradaPilot);
                break;
            case 6:
                List<Dron> llistatDron = sesion.createQuery("from " + "Dron", Dron.class).list();
                List<Dron> llistaFiltradaDron = llistatDron.stream().filter(x -> x.getAtributIdentificador() >= id_inicial && x.getAtributIdentificador() <= id_final).toList();
                DronDAO daoDron = new DronDAO();
                daoDron.eliminarLista(llistaFiltradaDron);
                logger.info("Registros eliminados:");
                logger.info(llistaFiltradaDron);
                break;

        }

    }

}
