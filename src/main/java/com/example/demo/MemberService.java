package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	public List<Member> findAll(){
		return memberRepository.findAll();
	}

	public Member findOne(Integer id) {
		Optional<Member> member = memberRepository.findById(id);
		if(member.isPresent()) {
			return member.get();
		}else {
			return null;
		}
	}

	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public void delete(Integer id) {
		memberRepository.deleteById(id);
	}







}
