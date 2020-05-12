package com.arnab.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arnab.demo.Model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname desc")
	List<Alien> findByTechSorted(String tech);
}
