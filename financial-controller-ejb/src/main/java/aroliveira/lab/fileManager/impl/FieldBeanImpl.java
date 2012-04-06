package aroliveira.lab.fileManager.impl;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> fb38caf897f2435fce1f7987ff1e9843a9d1c1bf
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aroliveira.lab.fileManager.FieldBean;
<<<<<<< HEAD
import aroliveira.lab.structure.entities.layout.Field;
=======
import aroliveira.lab.structure.layout.Field;
>>>>>>> fb38caf897f2435fce1f7987ff1e9843a9d1c1bf
import aroliveira.lab.structure.util.Type;

@Stateless
@Remote
public class FieldBeanImpl implements FieldBean {

<<<<<<< HEAD
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
=======
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
>>>>>>> fb38caf897f2435fce1f7987ff1e9843a9d1c1bf
	}
}