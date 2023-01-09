package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Emp;
import com.example.emp.exception.EmpException;
import com.example.emp.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{

	Logger logger =  LoggerFactory.getLogger(EmpService.class);

	@Autowired
	EmpRepository empRepository;
	
	
	@Override
	public Emp getEmpById(Integer id) {
		
		Optional<Emp> findById =empRepository.findById(id);
		
		return findById.get();
	}

	@Override
	public Emp addEmp(Emp emp) {
		 

		try {
			return empRepository.save(emp);
		} catch (Exception e) {

			logger.error("Error while adding: " ,e.getMessage());
			throw new EmpException("Error while add new emp with invalid data.");
		}
		
	}

	@Override
	public Emp getEmpByName(String name) {

		return empRepository.findByName(name);
	}

	@Override
	public List <Emp> getAllEmp() {
		return empRepository.findAllEmp();
	}
	
}
