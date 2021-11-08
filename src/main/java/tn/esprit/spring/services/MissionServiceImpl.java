package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class MissionServiceImpl implements IMissionService{
	
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	MissionRepository missRepoistory;

	@Override
	public int addMission(Mission Mission) {
		missRepoistory.save(Mission);
		return Mission.getId();
	}

	@Override
	public void deleteMissionById(int MissionId) {
		Mission mission = missRepoistory.findById(MissionId).get();
		missRepoistory.delete(mission);
		
	}

	@Override
	public void updateMissionById(int MissionId,Mission miss) {
		Mission mission=missRepoistory.findById(MissionId).orElse(null);
		if(mission!=null)
		{
			mission.setDescription(miss.getDescription());
			mission.setName(miss.getName());
			missRepoistory.save(mission);
		}
		
	}

	@Override
	public List<Mission> getAllMissions() {
		return (List<Mission>) missRepoistory.findAll();
	}

	@Override
	public Mission getMissionById(int MissionId) {
		return missRepoistory.findById(MissionId).orElse(null);
	}

	

	@Override
	public List<Mission> getAllMissionByDepartment(Departement department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignDepartmentToMission(Departement department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMissionToTimeSheet(Mission mission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Mission> getAllMissionsByEmailFact(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSumofAverageDayRateJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

}
