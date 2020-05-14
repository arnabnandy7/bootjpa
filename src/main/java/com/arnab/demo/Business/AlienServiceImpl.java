package com.arnab.demo.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.demo.Model.Alien;
import com.arnab.demo.Repository.AlienRepository;
import com.arnab.demo.Service.AlienService;

@Service
public class AlienServiceImpl implements AlienService {

	@Autowired
	private AlienRepository alienRepo;

	@Override
	public List<Alien> findAll() {
		return alienRepo.findAll();
	}

	@Override
	public Optional<Alien> findById(int aid) {
		return alienRepo.findById(aid);
	}

	@Override
	public Alien create(Alien alien) {
		alienRepo.save(alien);
		return alien;
	}

	@Override
	public Optional<Alien> delete(int aid) {
		Optional<Alien> alien = alienRepo.findById(aid);
		alienRepo.deleteById(aid);
		return alien;
	}

	@Override
	public Alien updateAlien(Alien alien) {
		Optional<Alien> alienOrig = alienRepo.findById(alien.getAid());
		Alien alteredAlien;
		if (alienOrig.isPresent()) {
			alteredAlien = alienOrig.get();
			alteredAlien.setAid(alien.getAid());
			alteredAlien.setAname(alien.getAname());
			alteredAlien.setTech(alien.getTech());
			alienRepo.save(alteredAlien);
		} else {
			alteredAlien = null;
		}
		return alteredAlien;
	}

	@Override
	public Alien findByName(int aid) {
		Optional<Alien> aln = alienRepo.findById(aid);
		alienRepo.findById(new Integer(101));
		Alien alien = aln.isPresent() ? aln.get() : null;
		alien.setTech("cpp");
		alienRepo.findById(new Integer(104));
		return alien;
	}

}
