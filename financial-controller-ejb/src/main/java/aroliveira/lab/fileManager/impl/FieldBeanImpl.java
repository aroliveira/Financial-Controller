package aroliveira.lab.fileManager.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aroliveira.lab.fileManager.FieldBean;
import aroliveira.lab.structure.layout.Field;
import aroliveira.lab.structure.util.Type;

@Stateless
@Remote
public class FieldBeanImpl implements FieldBean {

	@PersistenceContext(unitName="DefaultDS")
	EntityManager manager;

	
	
	@Override
	public void createField(String fieldName, String fieldType) {
		manager.persist(new Field(fieldName, Type.valueOf(fieldType)));
		System.out.println();
	}

	@Override
	public void updateField(String fieldName, String fieldType) {
	}

	@Override
	public void deleteField(String fieldName) {
	}

	@Override
	public void listAll() {
	}
}