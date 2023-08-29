package com.joko.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employees")
public class DanamonEmployee {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank
	@Size(max = 120)
	@Column(name = "name")
    private String name;
	
	@NotBlank
	@Size(max = 200)
	@Column(name = "address")
    private String address;
	
	@NotBlank
	@Size(max = 200)
	@Column(name = "salary")
    private String salary;
	
	@NotBlank
	@Size(max = 120)
	@Column(name = "job")
    private String job;
	
	public DanamonEmployee () {}
	
	

	public DanamonEmployee(@NotBlank @Size(max = 120) String name, @NotBlank @Size(max = 200) String address,
			@NotBlank @Size(max = 200) String salary,@NotBlank @Size(max = 120) String job) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.job = job;
	}

	

	@Override
	public String toString() {
		return "DanamonEmployee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", job="+job+", getId()=" + getId() + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getSalary()=" + getSalary() +", getJob()="+getJob()+ ", toString()=" + super.toString() + "]";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}
	
	
}
