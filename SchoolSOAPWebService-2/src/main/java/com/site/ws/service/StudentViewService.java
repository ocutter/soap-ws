package com.site.ws.service;

import java.util.List;
import java.util.ArrayList;

//import com.site.ws.entity.Student;
import com.site.ws.entity.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.site.ws.repository.StudentViewRepository;


@Service
public class StudentViewService implements IStudentViewService {

	@Autowired
	private StudentViewRepository studentViewRepository;
	
	@Override
	public List<StudentView> getStudentsView() {
		List<StudentView> list = new ArrayList<>();
		studentViewRepository.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	/**
	 * 
	 */
	@Override
	public StudentView getStudentViewByFullName(String fullName) {
		StudentView obj = studentViewRepository.findByFullName(fullName);
		return obj;
	}


}

