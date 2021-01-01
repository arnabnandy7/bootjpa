package com.arnab.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.arnab.demo.Model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer> {

	List<Alien> findByTech(String string);

}
