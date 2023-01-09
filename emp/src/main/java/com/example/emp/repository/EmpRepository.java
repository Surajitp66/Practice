package com.example.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.emp.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {

	public Emp findByName(String name);
	
	@Query
	(value = "select id,name, sal,status from emp",nativeQuery = true)
	public List<Emp> findAllEmp();
	
}
