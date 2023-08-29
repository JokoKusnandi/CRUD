package com.joko.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joko.model.DanamonEmployee;
import com.joko.repository.DanamonEmployeeRepository;

@RestController
@RequestMapping("/bdi/interview")
public class DanamonEmployeeController {
	
	@Autowired
	DanamonEmployeeRepository danamonEmployeeRepository;
	
	@GetMapping("/employee")
	public ResponseEntity<List<DanamonEmployee>> getAllDanamonEmployee(@RequestParam(required = false) String name) {
		try {
			List<DanamonEmployee> danamonEmployees = new ArrayList<DanamonEmployee>();
			
		      if (name == null)
		    	  danamonEmployeeRepository.findAll().forEach(danamonEmployees::add);
		        else
		        	danamonEmployeeRepository.findByNameContaining(name).forEach(danamonEmployees::add);

		        if (danamonEmployees.isEmpty()) {
		          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		        }
			return new ResponseEntity<>(danamonEmployees, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	  @GetMapping("/employee/{id}")
	  public ResponseEntity<DanamonEmployee> getDanamonEmployeeById(@PathVariable("id") long id) {
	    Optional<DanamonEmployee> danamonEmployees = danamonEmployeeRepository.findById(id);

	    if (danamonEmployees.isPresent()) {
	      return new ResponseEntity<>(danamonEmployees.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PostMapping("/employee")
	  public ResponseEntity<DanamonEmployee> createDanamonEmployee(@RequestBody DanamonEmployee danamonEmployee) {
	    try {
	    	DanamonEmployee danamonemployee = danamonEmployeeRepository.save(new DanamonEmployee(danamonEmployee.getName(), danamonEmployee.getAddress(),danamonEmployee.getSalary(),danamonEmployee.getJob()));
	      return new ResponseEntity<>(danamonemployee, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/employee/{id}")
	  public ResponseEntity<DanamonEmployee> updateDanamonEmployee(@PathVariable("id") long id, @RequestBody DanamonEmployee danamonEmployee) {
	    Optional<DanamonEmployee> employeedata = danamonEmployeeRepository.findById(id);

	    if (employeedata.isPresent()) {
	    	DanamonEmployee emp = employeedata.get();
	      emp.setName(danamonEmployee.getName());
	      emp.setAddress(danamonEmployee.getAddress());
	      emp.setSalary(danamonEmployee.getSalary());
	      emp.setJob(danamonEmployee.getJob());
	      return new ResponseEntity<>(danamonEmployeeRepository.save(emp), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @DeleteMapping("/employee/{id}")
	  public ResponseEntity<HttpStatus> deleteDanamonEmployee(@PathVariable("id") long id) {
	    try {
	    	danamonEmployeeRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @DeleteMapping("/employee")
	  public ResponseEntity<HttpStatus> deleteAllDanamonEmployee() {
	    try {
	    	danamonEmployeeRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	  
}
