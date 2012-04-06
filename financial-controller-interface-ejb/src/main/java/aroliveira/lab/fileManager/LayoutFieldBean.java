package aroliveira.lab.fileManager;

import java.util.List;

import aroliveira.lab.structure.entities.layout.Field;
import aroliveira.lab.structure.entities.layout.LayoutField;

public interface LayoutFieldBean {
	
	LayoutField createLayoutField(Field field, Boolean nullable, Integer initialPosition,
			Integer size);
	
	List<LayoutField> layoutFields();
}
