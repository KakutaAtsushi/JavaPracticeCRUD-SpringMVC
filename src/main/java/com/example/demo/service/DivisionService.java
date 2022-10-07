package com.example.demo.service;

import com.example.demo.domain.Division;
import com.example.demo.domain.Member;
import com.example.demo.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DivisionService {

    @Autowired
    DivisionRepository divisionRepository;

    public List<Division> findAll() {
        return (List<Division>) divisionRepository.findAll();
    }

    public void insert(Division division) {
        divisionRepository.save(division);
    }

    public void update(Division division) {
        divisionRepository.save(division);
    }

    public void delete(Integer id) {
        divisionRepository.deleteById(id);
    }

    public Optional<Division> selectById(Integer id) {
        return divisionRepository.findById(id);
    }
}
