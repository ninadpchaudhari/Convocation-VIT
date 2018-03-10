package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LinkedInProfile;

@Repository
public interface LinkedInProfileRepository extends CrudRepository<LinkedInProfile, Long>{
	List<LinkedInProfile> findByLastName(String lastName);
	List<LinkedInProfile> findById(long id);
	List<LinkedInProfile> findByFirstName(String firstName);
	List<LinkedInProfile> findAll();
	
}
