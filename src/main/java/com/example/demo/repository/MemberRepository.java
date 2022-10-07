package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository <Member, Integer>{

    @Query(value = "SELECT * FROM MEMBERS as m INNER JOIN DIVISION as d ON m.DIVISION_ID = d.ID", nativeQuery = true)
    List<Member> findAllMembers();

}
