package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Meigen;
import com.example.demo.repository.MeigenRepository;


@Service
@Transactional
public class MeigenService {
	@Autowired
	MeigenRepository meiRepo;
	
	
    public List<Meigen> findAll() {
        return meiRepo.findAll();
    }

    public Meigen findOne(Long id) {
    	Optional<Meigen> meigen = meiRepo.findById(id);
        return meigen.get();
    }

    public Meigen create(Meigen meigen) {
        return meiRepo.save(meigen);
    }

    public Meigen update(Meigen meigen) {
        return meiRepo.save(meigen);
    }

    public void delete(Long id) {
        meiRepo.deleteById(id);;
    }

}
