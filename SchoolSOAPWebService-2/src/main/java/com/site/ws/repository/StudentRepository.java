package com.site.ws.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.site.ws.entity.Student;

public interface StudentRepository  extends CrudRepository<Student, Long>{

	Student findByStudentId(long studentId);
    Student findByFullName(String fullName);
    List<Student> findByFullNameAndParentId(String fullName, long parentId);
  //  List<Student> findByFullNameAndParent(String fullName);
}



