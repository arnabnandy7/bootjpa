package com.arnab.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.demo.Model.Alien;
import com.arnab.demo.dao.AlienRepo;

import io.swagger.annotations.ApiOperation;

@RestController
public class AlienRestController {
	
	@Autowired
	AlienRepo repo;
	
	// REST Responses

	/**
	 * This will call when client hits following link http://localhost:8080/aliens
	 * 
	 * In order to restrict to a type you have to specify accepted type in produces
	 * to Request Mapping as produces={"application/xml"}
	 * 
	 * For content negotiations you have to add xml support to pom.xml to add
	 * jackson dataformat xml from maven repository
	 * 
	 * @return List<Alien>
	 */
	@ApiOperation(value = "It will list all aliens") // it description of api
	// @RequestMapping(path = "/aliens", produces = { "application/xml" })
	@GetMapping("/aliens")
	// @ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}

	/**
	 * This will call when client hits following link
	 * http://localhost:8080/alien/103
	 * 
	 * @param aid
	 * @return Optional<Alien>
	 */
	@ApiOperation(value = "It will list an alien by id") // it description of api
	@GetMapping("/alien/{aid}")
	// @ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}

	/**
	 * This will call when client want to add an alien
	 * 
	 * Like produces we can also restrict consumes which will ensure only specified
	 * type of data to be accepted by server using consumes = { "application/json" }
	 * 
	 * @param alien
	 * @return Alien
	 */
	// @PostMapping("/alien")
	@ApiOperation(value = "It will add new alien") // it description of api
	@PostMapping(path = "/alien", consumes = { "application/json" })
	public Alien addAlienByRest(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

	/**
	 * This will call when client want to delete an alien
	 * 
	 * @param aid
	 * @return Optional<Alien>
	 */
	@ApiOperation(value = "It will delete alien") // it description of api
	@DeleteMapping("/alien/{aid}")
	public Optional<Alien> deleteAlien(@PathVariable("aid") int aid) {
		Optional<Alien> alien = repo.findById(aid);
		repo.deleteById(aid);
		return alien;
	}

	@ApiOperation(value = "It will update an alien") // it description of api
	@PutMapping("/alien")
	public Alien updateAlien(@RequestBody Alien alien) {
		Optional<Alien> alienOrig = repo.findById(alien.getAid());
		Alien alteredAlien;
		if (alienOrig.isPresent()) {
			alteredAlien = alienOrig.get();
			alteredAlien.setAid(alien.getAid());
			alteredAlien.setAname(alien.getAname());
			alteredAlien.setTech(alien.getTech());
			repo.save(alteredAlien);
		} else {
			alteredAlien = null;
		}
		return alteredAlien;
	}
}
