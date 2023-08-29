package com.joko.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joko.model.DanamonEmployee;

public interface DanamonEmployeeRepository extends JpaRepository<DanamonEmployee, Long>{

	List<DanamonEmployee> findByNameContaining(String name);

	@SuppressWarnings("unchecked")
	DanamonEmployee save(DanamonEmployee danamonEmployee);

}
