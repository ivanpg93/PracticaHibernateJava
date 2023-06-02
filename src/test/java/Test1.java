/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import aplicacion.model.Aeronau;
import aplicacion.model.Combat;
import aplicacion.model.Mecanic;
import aplicacion.model.Missio;
import aplicacion.model.Pilot;
import aplicacion.model.Pilotada;
import aplicacion.ClassFactory;
import aplicacion.model.Transport;
import aplicacion.model.Dron;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import utils.SingleSession;

/**
 *
 * @author manel
 * 
 * versió 22_23 1.2
 */
public class Test1 {
    
   static Session session;
   static ClassFactory factory;
   private TestInfo testInfo;
   
   @BeforeEach
   public void init(TestInfo testInfo) {
       this.testInfo = testInfo;
   }
   
   @BeforeAll
   public static void inici()
   {
       factory = new ClassFactory();
   }
     
   /***
    * Verifica la creació de taules a la BBDD
    */
   @Test
   public void RF01() {
      
      session = SingleSession.getInstance().getSessio();
       
      assertTrue(session.getCriteriaBuilder().createQuery(Combat.class).getOrderList().size() >= 0 );
      assertTrue(session.getCriteriaBuilder().createQuery(Mecanic.class).getOrderList().size() >= 0 );
      assertTrue(session.getCriteriaBuilder().createQuery(Missio.class).getOrderList().size() >= 0 );
      assertTrue(session.getCriteriaBuilder().createQuery(Pilot.class).getOrderList().size() >= 0 );
      assertTrue(session.getCriteriaBuilder().createQuery(Dron.class).getOrderList().size() >= 0 );
  }
   
   /***
    * Verifica que l'entitat es generi i es desi a BBDD correctament
    */
   @Test
   public void RF02_Combat() {
       
       System.out.println("TEST: " + testInfo.getDisplayName());
       
       //dos objectes "random" han de tenir atributs diferents
       Combat o1 = (Combat) factory.aeronauFactory(Combat.class);
       Combat o2 = (Combat) factory.aeronauFactory(Combat.class);
       assertTrue(! o1.getAtributString().equals(o2.getAtributString()));
       assertTrue(! o1.getAtributFloat().equals(o2.getAtributFloat()));
       assertTrue(! o1.getAtributDate().equals(o2.getAtributDate()));

       session = SingleSession.getInstance().getSessio();
       
       session.beginTransaction();
       
       Combat objecte = (Combat) factory.aeronauFactory(Combat.class);
       session.persist(objecte);
       session.getTransaction().commit();
       
       Combat objecte2 = (Combat) session.get(Combat.class, objecte.getAtributIdentificador());
       
       assertTrue(objecte.getAtributString().equals(objecte2.getAtributString()));
       assertTrue(objecte.getAtributFloat().equals(objecte2.getAtributFloat()));
       assertTrue(objecte.getAtributDate().equals(objecte2.getAtributDate()));
       assertTrue(objecte.getAtributBoolean().equals(objecte2.getAtributBoolean()));
  }
   
    /***
    * Verifica que l'entitat es generi i es desi a BBDD correctament
    */
   @Test
   public void RF02_Transport() {
       
       System.out.println("TEST: " + testInfo.getDisplayName());
       
       //dos objectes "random" han de tenir atributs diferents
       Transport o1 = (Transport) factory.aeronauFactory(Transport.class);
       Transport o2 = (Transport) factory.aeronauFactory(Transport.class);
       assertTrue(! o1.getAtributString().equals(o2.getAtributString()));
       assertTrue(! o1.getAtributFloat().equals(o2.getAtributFloat()));
       assertTrue(! o1.getAtributDate().equals(o2.getAtributDate()));
       

       session = SingleSession.getInstance().getSessio();
       
       session.beginTransaction();
       
       Transport objecte = (Transport) factory.aeronauFactory(Transport.class);
       session.persist(objecte);
       session.getTransaction().commit();
       
       Transport objecte2 = (Transport) session.get(Transport.class, objecte.getAtributIdentificador());
       
       assertTrue(objecte.getAtributString().equals(objecte2.getAtributString()));
       assertTrue(objecte.getAtributFloat().equals(objecte2.getAtributFloat()));
       assertTrue(objecte.getAtributDate().equals(objecte2.getAtributDate()));
       assertTrue(objecte.getAtributBoolean().equals(objecte2.getAtributBoolean()));
       
   }
   
    /***
    * Verifica que l'entitat es generi i es desi a BBDD correctament
    */
   @Test
   public void RF02_Mecanic() {
       
       System.out.println("TEST: " + testInfo.getDisplayName());
       
       //dos objectes "random" han de tenir atributs diferents
       Mecanic o1 = (Mecanic) factory.soldatFactory(Mecanic.class);
       Mecanic o2 = (Mecanic) factory.soldatFactory(Mecanic.class);
       assertTrue(! o1.getAtributString().equals(o2.getAtributString()));
       assertTrue(! o1.getAtributFloat().equals(o2.getAtributFloat()));
       assertTrue(! o1.getAtributDate().equals(o2.getAtributDate()));

       session = SingleSession.getInstance().getSessio();
       
       session.beginTransaction();
       
       Mecanic objecte = (Mecanic) factory.soldatFactory(Mecanic.class);
       session.persist(objecte);
       session.getTransaction().commit();
       
       Mecanic objecte2 = (Mecanic) session.get(Mecanic.class, objecte.getAtributIdentificador());
       
       assertTrue(objecte.getAtributString().equals(objecte2.getAtributString()));
       assertTrue(objecte.getAtributFloat().equals(objecte2.getAtributFloat()));
       assertTrue(objecte.getAtributDate().equals(objecte2.getAtributDate()));
       assertTrue(objecte.getAtributBoolean().equals(objecte2.getAtributBoolean()));
   }
   
   /***
   * Verifica que l'entitat es generi i es desi a BBDD correctament
   */
   @Test
   public void RF02_Missio() {
       
       //dos objectes "random" han de tenir atributs diferents
       Missio o1 = (Missio) factory.missioFactory();
       Missio o2 = (Missio) factory.missioFactory();
       assertTrue(! o1.getAtributString().equals(o2.getAtributString()));
       assertTrue(! o1.getAtributFloat().equals(o2.getAtributFloat()));
       assertTrue(! o1.getAtributDate().equals(o2.getAtributDate()));

       session = SingleSession.getInstance().getSessio();
       
       session.beginTransaction();
       
       Missio objecte = factory.missioFactory();
       session.persist(objecte);
       session.getTransaction().commit();
       
       Missio objecte2 = (Missio) session.get(Missio.class, objecte.getAtributIdentificador());
       
       assertTrue(objecte.getAtributString().equals(objecte2.getAtributString()));
       assertTrue(objecte.getAtributFloat().equals(objecte2.getAtributFloat()));
       assertTrue(objecte.getAtributDate().equals(objecte2.getAtributDate()));
       assertTrue(objecte.getAtributBoolean().equals(objecte2.getAtributBoolean()));
       
  }
   
   /***
   * Verifica que l'entitat es generi i es desi a BBDD correctament
   */
   @Test
   public void RF02_Pilot() {
       
       System.out.println("TEST: " + testInfo.getDisplayName());
       
       //dos objectes "random" han de tenir atributs diferents
       Pilot o1 = (Pilot) factory.soldatFactory(Pilot.class);
       Pilot o2 = (Pilot) factory.soldatFactory(Pilot.class);
       assertTrue(! o1.getAtributString().equals(o2.getAtributString()));
       assertTrue(! o1.getAtributFloat().equals(o2.getAtributFloat()));
       assertTrue(! o1.getAtributDate().equals(o2.getAtributDate()));

       session = SingleSession.getInstance().getSessio();
       
       session.beginTransaction();
       
       Pilot objecte = (Pilot) factory.soldatFactory(Pilot.class);
       session.persist(objecte);
       session.getTransaction().commit();
       
       Pilot objecte2 = (Pilot) session.get(Pilot.class, objecte.getAtributIdentificador());
       
       assertTrue(objecte.getAtributString().equals(objecte2.getAtributString()));
       assertTrue(objecte.getAtributFloat().equals(objecte2.getAtributFloat()));
       assertTrue(objecte.getAtributDate().equals(objecte2.getAtributDate()));
       assertTrue(objecte.getAtributBoolean().equals(objecte2.getAtributBoolean()));
   }
   
   /***
    * Verifica que l'entitat es generi i es desi a BBDD correctament
    */
   @Test
   public void RF02_Dron() {
       
       System.out.println("TEST: " + testInfo.getDisplayName());
       
       //dos objectes "random" han de tenir atributs diferents
       Dron o1 = (Dron) factory.aeronauFactory(Dron.class);
       Dron o2 = (Dron) factory.aeronauFactory(Dron.class);
       assertTrue(! o1.getAtributString().equals(o2.getAtributString()));
       assertTrue(! o1.getAtributFloat().equals(o2.getAtributFloat()));
       assertTrue(! o1.getAtributDate().equals(o2.getAtributDate()));

       session = SingleSession.getInstance().getSessio();
       
       session.beginTransaction();
       
       Dron objecte = (Dron) factory.aeronauFactory(Dron.class);
       session.persist(objecte);
       session.getTransaction().commit();
       
       Dron objecte2 = (Dron) session.get(Dron.class, objecte.getAtributIdentificador());
       
       assertTrue(objecte.getAtributString().equals(objecte2.getAtributString()));
       assertTrue(objecte.getAtributFloat().equals(objecte2.getAtributFloat()));
       assertTrue(objecte.getAtributDate().equals(objecte2.getAtributDate()));
       assertTrue(objecte.getAtributBoolean().equals(objecte2.getAtributBoolean()));
   }
   
   
    @Test
    public void RF04() {

       //relació ok 1 a 1
       session = SingleSession.getInstance().getSessio();
       session.beginTransaction();

       Pilot p, p2;
       Pilotada ap;
       
        try {

            p = (Pilot)factory.soldatFactory(Pilot.class);
            ap = (Pilotada)factory.aeronauFactory(Combat.class);
            factory.addPilotToAeronauPilotada(p, ap);

            session.persist(p);
            session.persist(ap);

            assertEquals(ap.getPilotAeronau().getAtributIdentificador(), p.getAtributIdentificador());
       
       } catch (Exception ex) {
             fail();
        }finally
        {
            session.getTransaction().commit();
        }
    }
    
  
    @Test
    public void RF05() {
        
       
        session = SingleSession.getInstance().getSessio();
        session.beginTransaction();

        Aeronau v;
        Pilotada ve;
        
        try {
            v = factory.addMecanicsToPilotada(factory.mecanicsFactory(2),(Pilotada)factory.aeronauFactory(Transport.class));
            session.persist(v);
            
            ve = (Pilotada)session.get(Transport.class, ((Transport)v).getAtributIdentificador());
            assertEquals(ve.getMecanics().size(), 2);

            v = factory.addMecanicsToPilotada(factory.mecanicsFactory(1),(Pilotada)factory.aeronauFactory(Combat.class));
            session.persist(v);
            ve = (Pilotada)session.get(Combat.class, ((Combat)v).getAtributIdentificador());
            assertEquals(ve.getMecanics().size(), 1);
            
        } catch (Exception ex) {
             fail();
        }finally
        {
            session.getTransaction().commit();
        }
        
         session.beginTransaction();
         
         try {
            v = factory.addMecanicsToPilotada(factory.mecanicsFactory(4),(Pilotada)factory.aeronauFactory(Transport.class));
            session.persist(v);
            
            fail();
           
            
        } catch (Exception ex) {
            //ok
        }finally
        {
            session.getTransaction().commit();
        }
    }
    
    @Test
    public void RF07() {
        
        session = SingleSession.getInstance().getSessio();
        
        session.beginTransaction();
        
        //creem aeronaus 
        List<Aeronau> escuadrilla1 = new ArrayList<>();
        for (int i = 1; i<=8; i++)
            escuadrilla1.add(factory.aeronauFactory(Dron.class));
        
        //desem
        escuadrilla1.stream().forEach(x -> session.persist(x));
        
        //creem misions 
        List<Missio> missions = factory.missionsFactory(2);
        
        //desem
        missions.stream().forEach(x -> session.persist(x));
        
        //enllacem aeronaus a missió
        missions.get(0).setAeronaus(escuadrilla1);
        
        //enllacem aeronaus a missió
        missions.get(1).setAeronaus(escuadrilla1);
        
        //persistim a BBDD
        session.getTransaction().commit();
               
        //recuperem missio
        Missio m1 = (Missio)session.get(Missio.class, missions.get(0).getAtributIdentificador());
        session.refresh(m1);
        
        //verifiquem misió ---> aeronaus
        assertEquals((m1.getAeronaus().size() == 8), true);
        
        //recuperem aeronau
        Dron a1 = (Dron)session.get(Dron.class, ((Dron)(escuadrilla1.get(0))).getAtributIdentificador());
        session.refresh(a1);
        
        //verifiquem aeronau ---> misió
        assertEquals((a1.getMissions().size() == 2), true);
    }
    
    @Test
    public void RF08() {
        
        session = SingleSession.getInstance().getSessio();
        
        session.beginTransaction();
        
        //creem aeronaus 
        List<Aeronau> escuadrillaBad = new ArrayList<>();
        for (int i = 1; i<=15; i++)
            escuadrillaBad.add(factory.aeronauFactory(Dron.class));
        
        //desem
        escuadrillaBad.stream().forEach(x -> session.persist(x));
        
         //creem aeronaus 
        List<Aeronau> escuadrillaGood = new ArrayList<>();
        for (int i = 1; i<=8; i++)
            escuadrillaGood.add(factory.aeronauFactory(Dron.class));
        
        //desem
        escuadrillaGood.stream().forEach(x -> session.persist(x));
        
        //creem misions 
        List<Missio> missions = factory.missionsFactory(4);
        
        //desem
        missions.stream().forEach(x -> session.persist(x));
        
         try {
             //enllacem aeronaus a missió
             factory.addAeronausToMissio(escuadrillaBad, missions.get(0));

             //una misió no pot tenir més de 8 aeronaus
             fail();
         } catch (Exception e) {
             //ok
         }
        
         try {
             //enllacem missions a aeronau
             factory.addMissionsToAeronau(missions, escuadrillaGood.get(0));
             
             // una aeronau no pot tenir més de dues missions alhora
             fail();
           
             
         } catch (Exception e) {             
             //ok
             
         } finally{
             
             //persistim a BBDD
             session.getTransaction().commit();
         }
    }
    
   @AfterAll
   public static void fi()
   {
       session.close();
   }
}