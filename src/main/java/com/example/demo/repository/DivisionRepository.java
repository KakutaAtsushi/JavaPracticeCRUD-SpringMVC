package com.example.demo.repository;

import com.example.demo.domain.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DivisionRepository extends CrudRepository <Division, Integer>{
}
