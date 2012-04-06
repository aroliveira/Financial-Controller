package aroliveira.managed.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import aroliveira.lab.fileManager.FieldBean;
import aroliveira.lab.structure.entities.layout.Field;
import aroliveira.lab.structure.util.Type;

@ManagedBean(name="fieldManagedBean")
@SessionScoped
public class FieldManagedBean {	

	@EJB
	private FieldBean fieldBeanService;

	private Field currentField;

	public FieldManagedBean() {
		currentField = new Field();
	}

	public Field getCurrentField() {
		return currentField;
	}

	public Type[] avaliableTypes(){
		return fieldBeanService.avaliableTypes();
	}

	public void createNewField(){
		fieldBeanService.createField(currentField.getName(), currentField.getType());
	}
	
	public List<Field> fields(){
		return fieldBeanService.fields();
	}
}
