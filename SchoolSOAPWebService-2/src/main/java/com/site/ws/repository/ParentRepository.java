
package com.site.ws.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.site.ws.entity.Parent;

public interface ParentRepository  extends CrudRepository<Parent, Long>{

	Parent findByParentId(long studentId);
	Parent findByFullName(String fullName);
    List<Parent> findByIdentificationCard(String identificationCard);
}



