package com.skilldistillery.newparent.services;

import java.util.List;

import com.skilldistillery.newparent.entities.Baby;

public interface NewParentService {
	
	List<Baby> index();
	Baby show(int babyId);
	Baby create(Baby baby);
	Baby update(int babyId, Baby baby);
	boolean delete(int babyId);
	

}
