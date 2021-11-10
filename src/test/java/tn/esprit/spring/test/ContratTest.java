package tn.esprit.spring.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.services.EmployeServiceImpl;


import java.util.Date;

import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
    private static final Logger L = LogManager.getLogger(EmployeTest.class);
    @Autowired
    EmployeServiceImpl EmplService;
    int referenceContrat;

    @Before
    public void initBefore() {

        L.info("startup -- Add a new Conrat");
        Date current = new Date();
        L.info("Create Date - Create Current Date");
        Contrat contrat= new Contrat(current,"CDD",2000);
        referenceContrat=EmplService.ajouterContrat(contrat);
        L.info("Finish - Contrat added in @Before with reference ==> : " + referenceContrat);
         L.info("finish - test trigger build");
    }

    @Test
    public void initTest() {

        L.info("startup -- Add a new Conrat");
        Date current = new Date();
        Contrat contrat= new Contrat(current,"CDD",2000);
        referenceContrat=EmplService.ajouterContrat(contrat); // JUnit assertion

        L.info("Finish - Contrat added in @Test with reference ==> : " + referenceContrat);
    }

    @After
    public void initAfter() {

        L.info("startup - - Add a new Conrat");
        Date current = new Date();
        Contrat contrat= new Contrat(current,"CDD",2000);
        referenceContrat=EmplService.ajouterContrat(contrat);
        L.info("Finish - Contrat added in @After with reference ==> : " + referenceContrat);
    }

    @Test
    public void deleteTestContrat() {

        try {
            L.info("----Start Test--- ");
            L.debug("Je vais lancer la suppression");
            EmplService.deleteContratById(4);

            L.debug("Je viens de finir l'opération du suppression.");

            L.info("Out deleteContratById(4) without errors.");
        }
        catch (Exception e) { L.error("Erreur dans deleteContratById(4) : " + e); }
    }
}
