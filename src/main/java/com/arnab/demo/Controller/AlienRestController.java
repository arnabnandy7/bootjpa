package com.arnab.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.demo.Model.Alien;
import com.arnab.demo.Service.AlienService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/")
@RestController
public class AlienRestController {

	@Autowired
	AlienService alienService;

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
	// @RequestMapping(path = "/aliens", produces = { "application/xml" })
	// @ResponseBody
	@ApiOperation(value = "It will list all aliens") // it description of api
	@GetMapping("/aliens")
	public ResponseEntity<List<Alien>> getAliens() {
		return ResponseEntity.status(HttpStatus.OK).body(alienService.findAll());
	}

	/**
	 * This will call when client hits following link
	 * http://localhost:8080/alien/103
	 * 
	 * @param aid
	 * @return Optional<Alien>
	 */
	// @ResponseBody
	@ApiOperation(value = "It will list an alien by id") // it description of api
	@GetMapping("/alien/{aid}")
	public ResponseEntity<Optional<Alien>> getAlienById(@PathVariable("aid") int aid) {
		return ResponseEntity.status(HttpStatus.OK).body(alienService.findById(aid));
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
	// @PostMapping(path = "/alien", consumes = { "application/json" })
	@ApiOperation(value = "It will add new alien") // it description of api
	@PostMapping(path = "/alien", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alien> addAlienByRest(@RequestBody Alien alien) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alienService.create(alien));
	}

	/**
	 * This will call when client want to delete an alien
	 * 
	 * @param aid
	 * @return Optional<Alien>
	 */
	@ApiOperation(value = "It will delete alien") // it description of api
	@DeleteMapping("/alien/{aid}")
	public ResponseEntity<Optional<Alien>> deleteAlien(@PathVariable("aid") int aid) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alienService.delete(aid));
	}

	@ApiOperation(value = "It will update an alien") // it description of api
	@PutMapping("/alien")
	public ResponseEntity<Alien> updateAlien(@RequestBody Alien alien) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alienService.updateAlien(alien));
	}
}
