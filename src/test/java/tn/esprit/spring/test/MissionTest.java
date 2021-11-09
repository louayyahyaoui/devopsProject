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
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.MissionServiceImpl;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionTest {
    private static final Logger L = LogManager.getLogger(MissionTest.class);
    @Autowired
    MissionServiceImpl MissionService;
    @Autowired
	EntrepriseServiceImpl EntrpService;
    Departement idDep;
    int referenceMission;

    @Before
    public void initBefore() {

        L.info("startup - Add a new Mission");
        Departement departemet = new Departement("devops project");
		idDep=EntrpService.ajouterDepartement(departemet);
		Mission miss = new Mission("mission one", "this is a description of mission one") ;
		referenceMission = MissionService.addMission(miss);

    }

    @Test
    public void GetMisionTest() {

        L.info("startup - get current mission added");
        Mission tempMiss= MissionService.getMissionById(referenceMission);
        L.info("Info - Current Mission : ",tempMiss);
    }


    @Test
    public void deleteMissionTest() {

            L.info("----Start Test--- Deleting Mission ");
            MissionService.deleteMissionById(referenceMission);
            L.info("----End Test--- ");
       
    }
}
