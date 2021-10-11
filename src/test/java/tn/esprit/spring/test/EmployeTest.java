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
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	private static final Logger L = LogManager.getLogger(EmployeTest.class);
	
	@Autowired
	EmployeServiceImpl EmplService;
	@Autowired
	EntrepriseServiceImpl EntrpService;
	
	public  int idEmp;
	public  int idDep;
	

	
	@Before
	public void init() {
		
		L.info("startup - Ajouter Employe et departement");
		 Employe employe= new Employe("Argoubi", "Sofien" ,"sofien.argoubi@esprit.tn", true, Role.INGENIEUR);
		Departement departemet = new Departement("spring");
		idDep=EntrpService.ajouterDepartement(departemet);
		idEmp= EmplService.ajouterEmploye(employe);
		
				
		 
	}
	@Test
	public void testAjouterEmploye() {
		L.info("update email employe :");
		
		EmplService.mettreAjourEmailByEmployeId("sofien.updated@esprit.tn",idEmp);
		
		L.info("affecte employe a departement :");
		EmplService.affecterEmployeADepartement(idEmp,idDep);
		L.info("desaffecte employe a departement :");
		EmplService.desaffecterEmployeDuDepartement(idEmp,idDep);
		
	
	}

	@After
	public void teardown() {
		L.info("Delete employe");
		
		EmplService.deleteEmployeById(idEmp);
		L.info("Delete departement");
		EntrpService.deleteDepartementById(idDep);
		
		L.info("End");
		

	}
}
