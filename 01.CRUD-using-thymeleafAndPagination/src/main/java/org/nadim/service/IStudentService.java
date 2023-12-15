package org.nadim.service;

import java.util.List;

import org.nadim.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
	
	//1. save data
	public Integer saveStudent(StudentEntity std);
	
	//2. get one student for updating
	public StudentEntity getOneStudent(Integer id);
	
	//3. Update student 
	public void editStudent(StudentEntity std);
	
	//4 Delete student
	public void deleteOneStudent(Integer id);
	
	// get all Student
	public List<StudentEntity> getAllStudent();
	
	//get all Student using Pageable
	public Page<StudentEntity> getAllStudent(Pageable page);
	
}
