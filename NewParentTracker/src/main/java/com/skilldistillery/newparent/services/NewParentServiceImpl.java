package com.skilldistillery.newparent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.newparent.entities.Baby;
import com.skilldistillery.newparent.repositories.NewParentRepository;

@Service
public class NewParentServiceImpl implements NewParentService{
	
	@Autowired
	private NewParentRepository repo;

	@Override
	public List<Baby> index() {
	return repo.findAll();
	}

	@Override
	public Baby show(int babyId) {
		Optional<Baby> babyOpt = repo.findById(babyId);
		Baby baby = null;
		if(babyOpt.isPresent()) {
		baby = babyOpt.get();
		}
		return baby;
	}

	@Override
	public Baby create(Baby baby) {
		repo.saveAndFlush(baby);
		return baby;
	}

	@Override
	public Baby update(int babyId, Baby baby) {
		Optional<Baby> babyOpt = repo.findById(babyId);
		Baby managedBaby = null;
		if(babyOpt.isPresent()) {
			managedBaby = babyOpt.get();
			if(baby.getName() != null) {managedBaby.setName(baby.getName());}
			if(baby.getAge() != null) {managedBaby.setAge(baby.getAge());}
			if(baby.getLastFeed() != null) {managedBaby.setLastFeed(baby.getLastFeed());}
			if(baby.getTimeSlept() != null) {managedBaby.setTimeSlept(baby.getTimeSlept());}
			if(baby.getNumberOfNaps() != null) {managedBaby.setNumberOfNaps(baby.getNumberOfNaps());}
			if(baby.getNumberOfDiaperChanges() != null) {managedBaby.setNumberOfDiaperChanges(baby.getNumberOfDiaperChanges());}
			repo.saveAndFlush(managedBaby);
		}
		
		return managedBaby;
	}

	@Override
	public boolean delete(int babyId) {
		boolean deleted = false;
		Optional<Baby> babyOpt = repo.findById(babyId);
		if(babyOpt.isPresent()) {
			repo.deleteById(babyId);
			deleted = true;
		}
		return deleted;
	}
	

}
