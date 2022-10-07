package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAllMembers();
    }

    public void insert(Member member) {
        memberRepository.save(member);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }

    public void delete(Integer id) {
        memberRepository.deleteById(id);
    }

    public Optional<Member> selectById(Integer id) {
        return memberRepository.findById(id);
    }


}
