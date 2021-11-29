package com.site.ws.service;
import java.util.List;
import com.site.ws.entity.StudentView;

public interface IStudentViewService {
    List<StudentView> getStudentsView();
  //  StudentView getStudentViewById(long studentId);
    StudentView getStudentViewByFullName(String fullName);


   // boolean addStudentView(StudentView student);
    
}




 