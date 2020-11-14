package com.skilldistillery.newparent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.newparent.entities.Baby;
import com.skilldistillery.newparent.repositories.NewParentRepository;

@Service
public class NewParentServiceImpl implements NewParentService{
	
	@Autowired
	private NewParentRepository repo;

	@Override
	public List<Baby> getAllBabies() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
