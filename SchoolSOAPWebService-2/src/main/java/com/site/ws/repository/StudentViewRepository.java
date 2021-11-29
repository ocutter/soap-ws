package com.site.ws.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.site.ws.entity.StudentView;

public interface StudentViewRepository  extends CrudRepository<StudentView, Long>{

	StudentView findByStudentId(long studentId);
    StudentView findByFullName(String fullName);
    //List<Student> findByFullNameAndParentId(String fullName, long parentId);
  //  List<Student> findByFullNameAndParent(String fullName);
}



