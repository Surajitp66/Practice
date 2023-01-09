package com.example.emp.service;


import java.util.List;

import com.example.emp.entity.Emp;

public interface EmpService {

	public Emp getEmpById(Integer id);
	public Emp addEmp(Emp emp);
	public Emp getEmpByName(String name);
	public List<Emp> getAllEmp();
	
	
}
