package com.site.ws.endpoint;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.site.ws.entity.Student;
import com.site.ws.generated.AddStudentRequest;
import com.site.ws.generated.AddStudentResponse;
import com.site.ws.generated.StudentInfo;
import com.site.ws.generated.GetStudentsResponse;
import com.site.ws.generated.*;

import com.site.ws.service.IStudentService;

@Endpoint
public class StudentEndpoint {

	private static final String NAMESPACE_URI = "http://www.site.com/ws/school";
	@Autowired
	private IStudentService studentService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentByFullNameRequest")
	@ResponsePayload
	public GetStudentByFullNameResponse getStudent(@RequestPayload GetStudentByFullNameRequest request) {
		GetStudentByFullNameResponse response = new GetStudentByFullNameResponse();
		StudentInfo studentInfo = new StudentInfo();
		BeanUtils.copyProperties(studentService.getStudentByFullName(request.getFullName()), studentInfo);
		response.setStudentInfo(studentInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentsRequest")
	@ResponsePayload
	public GetStudentsResponse getStudents() {
		GetStudentsResponse response = new GetStudentsResponse();
		List<StudentInfo> studentInfoList = new ArrayList<>();
		List<Student> studentList = studentService.getStudents();
		for (int i = 0; i < studentList.size(); i++) {
			StudentInfo ob = new StudentInfo();
			BeanUtils.copyProperties(studentList.get(i), ob);
			studentInfoList.add(ob);
		}
		response.getStudentInfo().addAll(studentInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStudentRequest")
	@ResponsePayload
	public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
		AddStudentResponse response = new AddStudentResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Student student = new Student();
		
		student.setFullName(request.getFullName());
		
		Date fecha = new Date(request.getDateOfBirth().toGregorianCalendar().getTimeInMillis());
	
		student.setDateOfBirth(fecha);
		student.setGender(request.getGender());
		student.setAcademicDegree(request.getAcademicDegree());
		student.setParentId(request.getParentId());
		
		boolean flag = studentService.addStudent(student);
		
		if (flag == false) {
			serviceStatus.setStatusCode("CONFLICTO");
			serviceStatus.setMessage("Registro existente.");
			response.setServiceStatus(serviceStatus);
		} else {
			StudentInfo studentInfo = new StudentInfo();
			BeanUtils.copyProperties(student, studentInfo);
			response.setStudentInfo(studentInfo);
			serviceStatus.setStatusCode("REGISTRADO");
			serviceStatus.setMessage("Registro agregado satisfactoriamente.");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}

}