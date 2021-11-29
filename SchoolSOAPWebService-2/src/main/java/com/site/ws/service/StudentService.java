package com.site.ws.service;

import java.util.List;
import java.util.ArrayList;

import com.site.ws.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.site.ws.repository.StudentRepository;


@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub		
		List<Student> list = new ArrayList<>();
		studentRepository.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public Student getStudentById(long studentId) {
		Student obj = studentRepository.findByStudentId(studentId);
		return obj;
	}

	@Override
	public boolean addStudent(Student student) {
		List<Student> list = studentRepository.findByFullNameAndParentId(student.getFullName(), student.getParentId()); 	
        
		/* False if exists by FullName and ParentId */
		if (list.size() > 0) {
           return false;
        } else {
        	student = studentRepository.save(student);
           return true;
        }
	}

	@Override
	public Student getStudentByFullName(String fullName) {
		Student obj = studentRepository.findByFullName(fullName);
		return obj;
	}

}

