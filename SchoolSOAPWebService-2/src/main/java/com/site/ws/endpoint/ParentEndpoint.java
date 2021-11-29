
package com.site.ws.endpoint;

import java.sql.Date;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.site.ws.entity.Parent;
import com.site.ws.generated.AddParentRequest;
import com.site.ws.generated.AddParentResponse;
import com.site.ws.generated.ParentInfo;
import com.site.ws.generated.GetParentsResponse;
import com.site.ws.generated.*;

import com.site.ws.service.IParentService;

@Endpoint
public class ParentEndpoint {

	private static final String NAMESPACE_URI = "http://www.site.com/ws/school";
	@Autowired
	private IParentService parentService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getParentByFullNameRequest")
	@ResponsePayload
	public GetParentByFullNameResponse getParent(@RequestPayload GetParentByFullNameRequest request) {
		GetParentByFullNameResponse response = new GetParentByFullNameResponse();
		ParentInfo parentInfo = new ParentInfo();
		BeanUtils.copyProperties(parentService.getParentByFullName(request.getFullName()), parentInfo);
		response.setParentInfo(parentInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getParentsRequest")
	@ResponsePayload
	public GetParentsResponse getParents() {
		GetParentsResponse response = new GetParentsResponse();
		List<ParentInfo> parentInfoList = new ArrayList<>();
		List<Parent> parentList = parentService.getParents();
		for (int i = 0; i < parentList.size(); i++) {
			ParentInfo ob = new ParentInfo();
			BeanUtils.copyProperties(parentList.get(i), ob);
			parentInfoList.add(ob);
		}
		response.getParentInfo().addAll(parentInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addParentRequest")
	@ResponsePayload
	public AddParentResponse addParent(@RequestPayload AddParentRequest request) {
		AddParentResponse response = new AddParentResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Parent parent = new Parent();
		
		parent.setFullName(request.getFullName());
		
		Date fecha = new Date(request.getDateOfBirthStr().toGregorianCalendar().getTimeInMillis());
		Format fechaTxt = new java.text.SimpleDateFormat("dd MMMM, yyyy");
		
		
		parent.setDateOfBirthStr(fechaTxt.format(fecha));
		parent.setgetIdentificationCard(request.getIdentificationCard());
		
	
		
		boolean flag = parentService.addParent(parent);
		
		if (flag == false) {
			serviceStatus.setStatusCode("CONFLICTO");
			serviceStatus.setMessage("Registro existente.");
			response.setServiceStatus(serviceStatus);
		} else {
			ParentInfo parentInfo = new ParentInfo();
			BeanUtils.copyProperties(parent, parentInfo);
			response.setParentInfo(parentInfo);
			serviceStatus.setStatusCode("REGISTRADO");
			serviceStatus.setMessage("Registro agregado satisfactoriamente.");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}

}