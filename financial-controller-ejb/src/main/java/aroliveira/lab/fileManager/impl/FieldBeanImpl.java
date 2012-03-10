package aroliveira.lab.fileManager.impl;

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
		System.out.println("Opa, criando um novo field no ejb. Manager: --> " + manager);
		Field f = new Field(fieldName, type);
		System.out.println("Opa, CRIADO um novo field no ejb");
		System.out.println("Antes de salvar");
		manager.persist(f);
		System.out.println("Depois de salvar");
		return f; 
	}

	@Override
	public Type[] avaliableTypes() {
		System.out.println("No ejb: " + Type.values());
		return Type.values();
	}
}