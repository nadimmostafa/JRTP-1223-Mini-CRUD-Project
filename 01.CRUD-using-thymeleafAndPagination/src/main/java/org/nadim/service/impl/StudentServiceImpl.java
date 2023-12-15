package org.nadim.service.impl;

import java.util.List;

import org.nadim.entity.StudentEntity;
import org.nadim.exceptionhandlig.StudentNotFoundException;
import org.nadim.repository.StudentRepository;
import org.nadim.service.IStudentService;
import org.nadim.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	//1. Save Operation
	@Override
	public Integer saveStudent(StudentEntity std) {
		StudentUtils.intiAdmissionFeeCal(std);
		std = repo.save(std);
		return std.getStudentId();
	}

	// 5. Get particular student details for showing on edit form
	@Override
	public StudentEntity getOneStudent(Integer id) {
		StudentEntity std = repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
		return std;
	}

	// 6. update student data
	@Override
	public void editStudent(StudentEntity std) {
		StudentUtils.intiAdmissionFeeCal(std);
		repo.save(std);
	}
	
	// 3. Delete student details
	@Override
	public void deleteOneStudent(Integer id) {
		repo.delete(this.getOneStudent(id));
	}
   //2 . get All student data
	@Override
	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> list = repo.findAll();
		return list;
	}

	@Override
	public Page<StudentEntity> getAllStudent(Pageable pageable) {
		Page<StudentEntity> page = repo.findAll(pageable);
		return page;
	}

}
