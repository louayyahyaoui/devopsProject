package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionExterne;


public interface MissionRepository extends CrudRepository<Mission, Integer> {
	
	//@Query("SELECT * FROM Mission where departement_id = :departement_id")
    //public List<Mission> getMissionByDepartmentID(@Param("departement_id")int departement_id);
	
	//@Query("SELECT * FROM Mission m  where m.email_facturation = ':email_facturation' ")
    //public List<Mission> getAllMissionsByEmailFact(@Param("email_facturation")String email_facturation);
	
	//@Query("SELECT sum(taux_journalier_moyen) FROM Mission")
    //public int getSumofAverageDayRateJPQL();
	
	//@Modifying
    //@Transactional
    //@Query("UPDATE Mission m SET m.departement_id=:depid where m.id=:missionId")
    //public void assignDepartmentToMission(@Param("depid")int depid, @Param("missionId")int missionId);
	
	//@Modifying
    //@Transactional
    //@Query("UPDATE timesheet m SET m.id_mission	=:missid where m.id=:missionId")
    //public void assignMissionToTimeSheet(@Param("missid")int depid, @Param("missionId")int missionId);
	

}
