package com.skilldistillery.newparent.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BabyTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Baby baby;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf =Persistence.createEntityManagerFactory("NewParentPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		baby = em.find(Baby.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		baby = null;
	}

	@Test
	void test_Baby_enitiy_mapping() {
		assertNotNull(baby);
		assertEquals("Kadence", baby.getName());
		assertEquals("10", baby.getAge());
		assertEquals("12:00", baby.getLastFeed());
		
	}

}
