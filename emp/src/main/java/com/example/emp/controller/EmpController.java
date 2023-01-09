package com.example.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.domain.EmpResponse;
import com.example.emp.entity.Emp;
import com.example.emp.service.EmpService;

@RestController
public class EmpController {
	
	private final  Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<EmpResponse> getEmp(@PathVariable("id") Integer id) {
		
		logger.info("get emp details by id:{}",id);
		
		Emp emp =empService.getEmpById(id);
		EmpResponse res =new EmpResponse();
		res.setEmpRes(emp);
		res.setMessage("succes");
		
		return new ResponseEntity<EmpResponse>(res,HttpStatus.OK);
		
	}
	
	@GetMapping("/empByName")
	public ResponseEntity<EmpResponse> getEmpName(@RequestParam String name) {
		
		logger.debug("get emp details by name:{}",name);
		
		Emp emp =empService.getEmpByName(name);
		EmpResponse res =new EmpResponse();
		res.setEmpRes(emp);
		res.setMessage("succes");
		
		logger.debug("get emp details by name:{},Emo:{}",name,emp);
		
		return new ResponseEntity<EmpResponse>(res,HttpStatus.OK);
		
	}
	
	@GetMapping("/allEmp")
	public ResponseEntity<EmpResponse> getAllEmp() {
		
		List<Emp> empList =empService.getAllEmp();
		EmpResponse res =new EmpResponse();
		res.setEmpRes(empList);
		res.setMessage("succes");
		
		return new ResponseEntity<EmpResponse>(res,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/emp")
	public ResponseEntity<Object> addEmp(@RequestBody Emp emp){
		EmpResponse res =new EmpResponse();
		if(emp== null) {
			return new ResponseEntity<Object>("Invalid employee", HttpStatus.BAD_REQUEST);
		}
		
		Emp addEmp = empService.addEmp(emp);
		res.setEmpRes(addEmp);
		res.setMessage("New Employee added Successfully");
		
		return new ResponseEntity<Object>(res,HttpStatus.OK);
	}
	
}

	

	/*
	 * private static HashMap<Integer, Emp> empMap = new HashMap<>();
	 * 
	 * public EmpController() { empMap.put(1, new Emp(1,"Surajit", 4000));
	 * empMap.put(2, new Emp(2,"Rohit", 2000)); }
	 * 
	 * @GetMapping("/info") public HashMap<Integer, Emp> getEmp() { return empMap;
	 * 
	 * 
	 * }
	 */

