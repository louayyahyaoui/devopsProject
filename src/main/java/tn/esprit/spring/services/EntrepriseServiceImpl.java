package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	public Entreprise ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise;
	}

	public Departement ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep;
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
		// Rappel : la classe qui contient mappedBy represente le bout Slave
		// Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		Optional<Entreprise> entrepriseManagedEntitys = entrepriseRepoistory.findById(entrepriseId);
		if (entrepriseManagedEntitys.isPresent()) {
			Entreprise entrepriseManagedEntity = entrepriseManagedEntitys.get();
			Optional<Departement> depManagedEntitys = deptRepoistory.findById(depId);

			if (depManagedEntitys.isPresent()) {
				Departement depManagedEntity = depManagedEntitys.get();
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
			}
		}

	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntitys = entrepriseRepoistory.findById(entrepriseId);
		List<String> depNames = new ArrayList<>();
		if (entrepriseManagedEntitys.isPresent()) {
			Entreprise entrepriseManagedEntity = entrepriseManagedEntitys.get();

			for (Departement dep : entrepriseManagedEntity.getDepartements()) {
				depNames.add(dep.getName());
			}
		}
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntitys = entrepriseRepoistory.findById(entrepriseId);

		if (entrepriseManagedEntitys.isPresent()) {
			Entreprise entrepriseManagedEntity = entrepriseManagedEntitys.get();
			entrepriseRepoistory.delete(entrepriseManagedEntity);
		}
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> depManagedEntitys = deptRepoistory.findById(depId);

		if (depManagedEntitys.isPresent()) {
			Departement depManagedEntity = depManagedEntitys.get();
			deptRepoistory.delete(depManagedEntity);

		}
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional<Entreprise> entrepriseManagedEntitys = entrepriseRepoistory.findById(entrepriseId);

		if (entrepriseManagedEntitys.isPresent()) {
			return entrepriseManagedEntitys.get();
		}
		return null;
	}

	public Departement getDepartementById(int DepID) {
		Optional<Departement> depManagedEntitys = deptRepoistory.findById(DepID);

		if (depManagedEntitys.isPresent()) {
			return depManagedEntitys.get();
		}
		return null;
	}

}
