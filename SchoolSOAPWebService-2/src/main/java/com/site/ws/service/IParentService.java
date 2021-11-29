package com.site.ws.service;

import java.util.List;
import com.site.ws.entity.Parent;

public interface IParentService {
    List<Parent> getParents();
    Parent getParentById(long parentId);
    Parent getParentByIdentificationCard(String identificationCard);
    Parent getParentByFullName(String fullName);
    
    boolean addParent(Parent parent);
}

 