package com.site.soapclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.site.wsdl.AddStudentResponse;
import com.site.wsdl.StudentInfo;
import com.site.wsdl.GetStudentsResponse;
import com.site.wsdl.GetStudentByIdResponse;
import com.site.wsdl.ServiceStatus;

@SpringBootApplication
public class SOAPClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SOAPClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(StudentClient studentClient) {
		return args -> {
			System.out.println("TODOS LOS ESTUDIANTES" );
			GetStudentsResponse allStudentsResponse = studentClient.getStudents();
			allStudentsResponse.getStudentInfo().stream()
					.forEach(e ->System.out.println(
							"ID: " + e.getStudentId() + ",\nFullName: " + e.getFullName() + ",\n DateOfBirth: " + e.getDateOfBirth() +" \n Gender:" + e.getGender() + "\n  ParentId: " + e.getParentId() + " \n\n"
							));

			System.out.println("AGREGAR ESTUDIANTE" );
			String fullName = "JOSE CONNTRERAS";
			String  gender= "MALE";
			String accademicDegree = "BACHELORS";
			int parentId = 5;
			Date dateOfBirth = new Date(2007,04,20);
			
			
			
			
			AddStudentResponse addStudentResponse = studentClient.addStudent(fullName,dateOfBirth, gender, accademicDegree, parentId);
			StudentInfo studentInfo = addStudentResponse.getStudentInfo();
			if (studentInfo != null) {
				System.out.println(
						"ID: " + studentInfo.getStudentId() + ",\nFullName: " + studentInfo.getFullName() + ",\n DateOfBirth: " + studentInfo.getDateOfBirth() +" \n Gender:" + studentInfo.getGender() + "\n  ParentId: " + studentInfo.getParentId() + " \n\n"
						);
			}
			ServiceStatus serviceStatus = addStudentResponse.getServiceStatus();
			System.out.println(
					"StatusCode: " + serviceStatus.getStatusCode() + ", Message: " + serviceStatus.getMessage());

			
		};
	}
}
