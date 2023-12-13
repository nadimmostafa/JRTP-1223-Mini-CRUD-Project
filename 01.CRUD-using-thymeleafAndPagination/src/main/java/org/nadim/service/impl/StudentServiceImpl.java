package org.nadim.service.impl;

import java.util.List;

import org.nadim.entity.StudentEntity;
import org.nadim.repository.StudentRepository;
import org.nadim.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	//1. Save Operation
	@Override
	public Integer saveStudent(StudentEntity std) {
		std = repo.save(std);
		return std.getStudentId();
	}

	@Override
	public StudentEntity getOneStudent(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editStudent(StudentEntity std) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOneStudent(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentEntity> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
