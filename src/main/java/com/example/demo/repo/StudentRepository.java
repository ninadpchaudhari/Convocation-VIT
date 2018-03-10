package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findByLastName(String lastName);
	List<Student> findById(long id);
	List<Student> findByFirstName(String firstName);
	
	
}
