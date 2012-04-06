package aroliveira.lab.fileManager.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aroliveira.lab.fileManager.LayoutFieldBean;
import aroliveira.lab.structure.entities.layout.Field;
import aroliveira.lab.structure.entities.layout.LayoutField;

@Stateless
@Remote
public class LayoutFieldBeanImpl implements LayoutFieldBean {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public LayoutField createLayoutField(Field field, Boolean nullable, Integer initialPosition,
			Integer size) {
		System.out.println("Antes de criar o LayoutField no ejb");
		LayoutField layoutField = new LayoutField(field, nullable, initialPosition, size);
		System.out.println("Depois de criar o LayoutField no ejb: " + layoutField);
		manager.persist(layoutField);
		return layoutField;
	}

	@Override
	public List<LayoutField> layoutFields() {
		return manager.createNamedQuery("LayoutField.findAll").getResultList();
	}
}
