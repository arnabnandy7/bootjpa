package com.arnab.demo.Service;

import java.util.List;
import java.util.Optional;

import com.arnab.demo.Model.Alien;

public interface AlienService {
	List<Alien> findAll();

	Optional<Alien> findById(int aid);

	Alien create(Alien alien);

	Optional<Alien> delete(int aid);

	Alien updateAlien(Alien alien);
}
