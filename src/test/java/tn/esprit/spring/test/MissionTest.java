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


import tn.esprit.spring.services.MissionServiceImpl;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionTest {
    private static final Logger L = LogManager.getLogger(EmployeTest.class);
    @Autowired
    MissionServiceImpl MissionService;
    int referenceMission;

    @Before
    public void initBefore() {

        L.info("startup - Add a new Mission");

    }

    @Test
    public void initTest() {

        L.info("startup - Add a new Mission");

    }

    @After
    public void initAfter() {

        L.info("startup - Add a new Mission");

    }

    @Test
    public void deleteTestContrat() {

        try {
            L.info("----Start Test--- ");

        }
        catch (Exception e) { L.error("Erreur : " + e); }
    }
}
