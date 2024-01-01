package com.fisa.gym.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Dept;

@Repository
public interface DeptRepository extends CrudRepository<Dept, Integer>{

}