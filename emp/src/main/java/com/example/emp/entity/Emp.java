package com.example.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Setter
//@Getter
@Table(name = "Emp")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String name;
	private Integer sal;
	private String status = "A";

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer id, String name, Integer sal, String status) {
		super();
		Id = id;
		this.name = name;
		this.sal = sal;
		this.status = status;
	}

	
	  public Integer getId() { return Id; }
	  
	  public void setId(Integer id) { Id = id; }
	  
	  public String getName() { return name; }
	 
	  public void setName(String name) { this.name = name; }
	 
	  public Integer getSal() { return sal; }
	 
	  public void setSal(Integer sal) { this.sal = sal; }
	  
	  public String getStatus() { return status; }
	 
	  public void setStatus(String status) { this.status = status; }
	 

	@Override
	public String toString() {
		return "Emp [Id=" + Id + ", name=" + name + ", sal=" + sal + ", status=" + status + "]";
	}

}
