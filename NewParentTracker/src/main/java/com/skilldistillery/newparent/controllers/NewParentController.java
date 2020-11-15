package com.skilldistillery.newparent.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.newparent.entities.Baby;
import com.skilldistillery.newparent.services.NewParentService;

@RequestMapping("api")
@RestController
public class NewParentController {
	
	@Autowired
	private NewParentService svc;
	
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	
	@GetMapping("baby")
	public List<Baby> list(){
		return svc.index();
	}
	
	@GetMapping("baby/{babyId}")
	public Baby showBaby(@PathVariable Integer babyId, HttpServletResponse response) {
		Baby baby = svc.show(babyId);
		if(baby == null) {
			response.setStatus(404);
		}
		return baby;
	}
	
	@PostMapping("baby")
	public Baby addBaby(
			@RequestBody Baby baby,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		try {
		baby = svc.create(baby);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/").append(baby.getId());
			response.setHeader("Location", url.toString());
		} catch (Exception e) {
			response.setStatus(400);
			baby = null;
		}
		return baby;
	}
	
	@PutMapping("baby/{babyId}")
	public Baby updateBaby(
			@PathVariable Integer babyId, 
			@RequestBody Baby baby,
			HttpServletResponse response
	) {
		try {
			baby = svc.update(babyId, baby);
			if (baby == null) {
				response.setStatus(404);
				baby = null;
			}
		} catch (Exception e) {
			response.setStatus(400);
			baby = null;
		}
		return baby;
	}
	
	@DeleteMapping("baby/{babyId}")
	public void deleteFilm(
			@PathVariable Integer babyId,
			HttpServletResponse response
	) {
		try {
			if (svc.delete(babyId)) {
				response.setStatus(204);
			}
			else {
				response.setStatus(404);
			}
		} catch (Exception e) {
			response.setStatus(400);
		}
	}

}
