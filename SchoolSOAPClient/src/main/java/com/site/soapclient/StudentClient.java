package com.site.soapclient;


import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.site.wsdl.AddStudentRequest;
import com.site.wsdl.AddStudentResponse;
import com.site.wsdl.GetStudentByIdRequest;
import com.site.wsdl.GetStudentByIdResponse;
import com.site.wsdl.GetStudentsRequest;
import com.site.wsdl.GetStudentsResponse;

public class StudentClient extends WebServiceGatewaySupport  {
	public GetStudentByIdResponse getStudentById(long studentId) {
		GetStudentByIdRequest request = new GetStudentByIdRequest();
		request.setStudentId(studentId);
		GetStudentByIdResponse response = (GetStudentByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/getStudentByIdRequest"));
		return response;
	}
	public GetStudentsResponse getStudents() {
		GetStudentsRequest request = new GetStudentsRequest();
		GetStudentsResponse response = (GetStudentsResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/getStudentsRequest"));
     	        return response;
	}	
	public AddStudentResponse addStudent(String fullName, Date dateOfBirth, String gender, String AcademicDegree, int parentId) {
		AddStudentRequest request = new AddStudentRequest();
		request.setFullName(fullName);
		
		
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(dateOfBirth.getTime());
		
		
	    XMLGregorianCalendar xmlDate = null;
	    GregorianCalendar gc = new GregorianCalendar();
	    gc.setTime(dateOfBirth);
	 
	    try{
	      xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	    }catch(Exception e){
	      e.printStackTrace();
	    }
		
		request.setDateOfBirth( xmlDate);
		request.setAcademicDegree(AcademicDegree);
		request.setGender(gender);
		request.setParentId(parentId);
		
		
		AddStudentResponse response = (AddStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/ws/addStudentRequest"));
     	        return response;
	}	

} 