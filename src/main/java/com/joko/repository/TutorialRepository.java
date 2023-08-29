package com.joko.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joko.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findAll();

	List<Tutorial> findByPublished(boolean b);

}
