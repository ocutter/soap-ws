package com.site.ws.service;

import java.util.List;
import java.util.ArrayList;
import com.site.ws.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.site.ws.repository.ParentRepository;


@Service
public class ParentService implements IParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	@Override
	public List<Parent> getParents() {
		// TODO Auto-generated method stub		
		List<Parent> list = new ArrayList<>();
		parentRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Parent getParentById(long parentId) {
		Parent obj = parentRepository.findByParentId(parentId);
		return obj;
	}

	@Override
	public boolean addParent(Parent parent) {
		List<Parent> list = parentRepository.findByIdentificationCard(parent.getIdentificationCard()); 	 	
        
		/* False if exists by FullName and ParentId */
		if (list.size() > 0) {
           return false;
        } else {
        	parent = parentRepository.save(parent);
           return true;
        }
	}


	@Override
	public Parent getParentByIdentificationCard(String identificationCard) {
		Parent obj = parentRepository.findByIdentificationCard(identificationCard).stream().filter(f -> f.getIdentificationCard().equalsIgnoreCase(identificationCard)).findFirst().get();
		return obj;
	}

	@Override
	public Parent getParentByFullName(String fullName) {
		Parent obj = parentRepository.findByFullName(fullName);
		return obj;
	}

}

