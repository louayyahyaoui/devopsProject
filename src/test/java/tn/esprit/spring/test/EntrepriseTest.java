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

import tn.esprit.spring.services.EntrepriseServiceImpl;




@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	private static final Logger L = LogManager.getLogger(EntrepriseTest.class);
	@Autowired
	EntrepriseServiceImpl EntprService;
	
	@Before
	public void init() {
		L.info("startup");
		 
	}
	@Test
	public void testAjouterEntreprise() {
		L.info("hello");
	}

	@After
	public void teardown() {
		L.info("End");
		

	}
}
