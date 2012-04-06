package aroliveira.lab.fileManager.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aroliveira.lab.fileManager.FieldBean;
import aroliveira.lab.structure.entities.layout.Field;
import aroliveira.lab.structure.util.Type;

@Stateless
@Remote
public class FieldBeanImpl implements FieldBean {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Field createField(String fieldName, Type type) {
		Field f = new Field(fieldName, type);
		manager.persist(f);
		return f; 
	}

	@Override
	public Type[] avaliableTypes() {
		return Type.values();
	}

	@Override
	public List fields() {
		return manager.createNamedQuery("FieldEntity.findAll").getResultList();
	}
}