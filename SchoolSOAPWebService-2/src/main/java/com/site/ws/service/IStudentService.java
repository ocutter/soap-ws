package com.site.ws.service;
import java.util.List;
import com.site.ws.entity.Student;

public interface IStudentService {
    List<Student> getStudents();
    Student getStudentById(long studentId);
    Student getStudentByFullName(String fullName);
    
    boolean addStudent(Student student);
}

 