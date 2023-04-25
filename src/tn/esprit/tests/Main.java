package tn.esprit.tests;


import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import tn.esprit.entities.Hospitalisation;
import tn.esprit.entities.Services;


import tn.esprit.services.GestionHospitalisation;
import tn.esprit.services.GestionService;
import tn.esprit.tools.MaConnexion;


public class Main {

    public static void main(String[] args) throws SQLException {

        MaConnexion cnx = MaConnexion.getInstance();

        System.out.println(cnx);
        GestionHospitalisation gh = new GestionHospitalisation();

        GestionService ss = new GestionService();


    Hospitalisation h = new Hospitalisation();
      
//ajouter service 
        Services s = new Services();
      
        /*s.setType("Cardiology");
        s.setChef_service("tasnim");
        s.setDescription("aaaa");
        s.setPrix(26.6);
        ss.ajouter(s);
//modifier service
        Services serviceToModify = new Services(47, "type", "descprition", "chefservice", 2.5);
        ss.modifier(serviceToModify);
        System.out.println("Service modofié " + serviceToModify);
        List<Services> services = ss.afficher();
        for (Services service : services) {
            System.out.println(service);
        }
  //supprimer service
        Services ServiceSupp = new Services();
        ServiceSupp.setId(45);
        ss.supprimer(ServiceSupp);
        System.out.println("Service supprimé: " + ServiceSupp);*/
//ajouter hospitalisation
        h.setDate_entree(Date.valueOf("2022-01-01"));
        h.setDate_sortie(Date.valueOf("2022-01-05"));
        h.setId_hospitalisation(12345);
       // s.setId(38);
       //h.setS(s);
        s.setType("pediatrie");
        h.setS(s);
       gh.ajouter(h);
        System.out.println(h);
 //supprimer hospitalisation

       /* Hospitalisation deletedHospitalisation = new Hospitalisation();
        deletedHospitalisation.setId(68);
        gh.supprimer(deletedHospitalisation);
        System.out.println(" Hospitalisation supprimé: " + deletedHospitalisation);
 //modifer hospitalisation 
  Hospitalisation HospitalisationModify = new Hospitalisation();
        HospitalisationModify.setId(70);
        HospitalisationModify.setDate_sortie(Date.valueOf("2023-01-05"));
        HospitalisationModify.setDate_entree(Date.valueOf("2022-01-01"));
        HospitalisationModify.setId_hospitalisation(123);
       // Services serv = new Services();
        // serv.setType("pediatrie");
        ///HospitalisationModify.setS(s);
        gh.modifier(HospitalisationModify);
        System.out.println("hospitalisation modifiée: " + HospitalisationModify);
        // afficher hospitalisation 
        
          List<Hospitalisation> hospitalisation = gh.afficher();
            for (Hospitalisation hospitalisations : hospitalisation) {
                System.out.println(hospitalisations);
            }
     */
  
    }
}
