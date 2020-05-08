package com.arnab.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.arnab.demo.Model.Alien;
import com.arnab.demo.dao.AlienRepo;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author arnab
 * @since 2020
 * 
 *        <br>
 *        <br>
 *        By Using RestController we can remove use of @ResponseBody at each
 *        method.
 *
 */
@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;

	// Request fetching by normal jsp forms

	/**
	 * This will be called when user requests the link http://localhost:8080 it'll
	 * redirect user to home.jsp from root
	 * 
	 * Since, @RestController had been activated this will not work anymore to
	 * redirect to home.jsp, we need to use ModelAndView instead.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping("/")
	public ModelAndView home() {
		// return "home.jsp";
		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;
	}

	/**
	 * This will be called from home.jsp while add button pressed
	 * 
	 * Since, @RestController had been activated this will not work anymore to
	 * redirect to home.jsp, we need to use ModelAndView instead.
	 * 
	 * @param alien
	 * @return ModelAndView
	 */
	@RequestMapping("/addAlien")
	public ModelAndView addAlien(Alien alien) {
		ModelAndView mv = new ModelAndView("home.jsp");
		repo.save(alien);
		return mv;
	}

	/**
	 * This will be called from home.jsp while search by ID button pressed
	 * 
	 * @param aid
	 * @return ModelAndView
	 */
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}

	/**
	 * This will be called from home.jsp while search by technology button pressed
	 * 
	 * @param tech
	 * @return ModelAndView
	 */
	@RequestMapping("/getAlienByTech")
	public ModelAndView getAlienByTech(@RequestParam("tech") String tech) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		System.out.println(repo.findByTech(tech));
		System.out.println(repo.findByAidGreaterThan(105));
		System.out.println(repo.findByTechSorted(tech));
		return mv;
	}
}
