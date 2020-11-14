package com.skilldistillery.newparent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.newparent.entities.Baby;

public interface NewParentRepository extends JpaRepository<Baby, Integer> {
	

}
