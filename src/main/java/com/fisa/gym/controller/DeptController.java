package com.fisa.gym.controller;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisa.gym.exception.DeptNotFoundException;
import com.fisa.gym.model.DeptRepository;
import com.fisa.gym.model.domain.Dept;


@RestController
public class DeptController {

	@Autowired
	private DeptRepository dao;   
	
	@PostMapping("insert")
	public void insertDept() {
		Dept dept = new Dept(10, "인사", "서촌");
		dao.save(dept);
		
		ArrayList<Dept> all = new ArrayList<>();
		all.add(new Dept(11, "구매", "종각"));
		all.add(new Dept(12, "영업", "상암"));
		dao.saveAll(all);
	}
	
	@GetMapping("deptOne")
	public Dept getDept(int deptno) throws Exception {
		Optional<Dept> dept = dao.findById(deptno);
		System.out.println(dept); 
		
		dept.orElseThrow(Exception::new);  
		
		return dept.get();	
	}
	
	@GetMapping("dept")
	public Iterable<Dept> getDeptAll(){
		return dao.findAll();
	}
	
	
	@GetMapping("deptdelete")
	public String deleteDept(int deptno) throws DeptNotFoundException {
		dao.findById(deptno).orElseThrow(DeptNotFoundException::new);//로직 중지
		dao.deleteById(deptno);//존재할 경우실행되는 라인
		return "delete 성공";   
	}
	
	@ExceptionHandler(DeptNotFoundException.class)
	public String exHandler(DeptNotFoundException e) {
		e.printStackTrace();		
		return "해당 부서 번호는 존재하지 않습니다.";
	}
		
	//예외 전담 처리 메소드
	@ExceptionHandler
	public String exHandler(Exception e) {
		e.printStackTrace();		
		return "요청시 입력 데이터 재 확인 부탁합니다";
	}
	
	
}
