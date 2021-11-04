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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	private static final Logger L = LogManager.getLogger(EntrepriseTest.class);
	@Autowired
	EntrepriseServiceImpl EntprService;

	public static Entreprise Entp;
	public static Departement Dep;

	@Before
	public void init() {
		L.info("****startup test****");
		Entreprise entreprise = new Entreprise("Esprit", "12");
		Departement departemet = new Departement("spring");
		Entp = EntprService.ajouterEntreprise(entreprise);
		Dep = EntprService.ajouterDepartement(departemet);
		L.info(" Entreprise ajoutee: " + Entp);
		L.info(" Departemnet ajoute: " + Dep);

	}

	@Test
	public void testaffecterDepartementAEntreprise() {
		L.info("***test***");
		EntprService.affecterDepartementAEntreprise(Dep.getId(), Entp.getId());
		Dep=EntprService.getDepartementById(Dep.getId());
		L.info("Departement modifie : "+Dep);
	}

	@After
	public void teardown() {
		L.info("End");
		EntprService.deleteDepartementById(Dep.getId());
		EntprService.deleteEntrepriseById(Entp.getId());

	}
}
