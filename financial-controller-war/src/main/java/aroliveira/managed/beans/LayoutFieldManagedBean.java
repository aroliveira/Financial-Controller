package aroliveira.managed.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import aroliveira.lab.fileManager.LayoutFieldBean;
import aroliveira.lab.structure.entities.layout.LayoutField;

@ManagedBean(name="layoutFieldManagedBean")
@SessionScoped
public class LayoutFieldManagedBean {	

	@EJB
	private LayoutFieldBean layoutFieldBeanService;

	private LayoutField currentLayoutField;

	public LayoutFieldManagedBean() {
		currentLayoutField = new LayoutField();
	}

	public LayoutField getCurrentLayoutField() {
		return currentLayoutField;
	}
	
	public LayoutField createNewLayoutField(){
		
		
		return layoutFieldBeanService.createLayoutField(null, 
				true, 
				1, 
				10);
		
		/*return layoutFieldBeanService.createLayoutField(currentLayoutField.getField(), 
				currentLayoutField.getNullable(), 
				currentLayoutField.getInitialPosition(), 
				currentLayoutField.getSize());*/
	}
	
	public List<LayoutField> layoutFields(){
		return layoutFieldBeanService.layoutFields();
	}
}
