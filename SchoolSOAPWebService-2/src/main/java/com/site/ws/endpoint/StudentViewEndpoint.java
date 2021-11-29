package com.site.ws.endpoint;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.site.ws.entity.StudentView;
import com.site.ws.generated.*;

import com.site.ws.service.IStudentViewService;

@Endpoint
public class StudentViewEndpoint {

	private static final String NAMESPACE_URI = "http://www.site.com/ws/school";
	@Autowired
	private IStudentViewService studentViewService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentViewByFullNameRequest")
	@ResponsePayload
	public GetStudentViewByFullNameResponse getStudentView(@RequestPayload GetStudentViewByFullNameRequest request) {
		GetStudentViewByFullNameResponse response = new GetStudentViewByFullNameResponse();
		StudentViewInfo studentViewInfo = new StudentViewInfo();
		BeanUtils.copyProperties(studentViewService.getStudentViewByFullName(request.getFullName()), studentViewInfo);
		response.setStudentViewInfo(studentViewInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentsViewRequest")
	@ResponsePayload
	public GetStudentsViewResponse getStudentsView() {
		GetStudentsViewResponse response = new GetStudentsViewResponse();
		List<StudentViewInfo> studentViewInfoList = new ArrayList<>();
		List<StudentView> studentViewList = studentViewService.getStudentsView();
		for (int i = 0; i < studentViewList.size(); i++) {
			StudentViewInfo ob = new StudentViewInfo();
			BeanUtils.copyProperties(studentViewList.get(i), ob);
			studentViewInfoList.add(ob);
		}
		response.getStudentViewInfo().addAll(studentViewInfoList);
		return response;
	}


}