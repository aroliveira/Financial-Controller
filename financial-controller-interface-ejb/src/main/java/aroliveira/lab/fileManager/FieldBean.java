package aroliveira.lab.fileManager;


import java.util.List;

import aroliveira.lab.structure.entities.layout.Field;
import aroliveira.lab.structure.util.Type;

public interface FieldBean {
	
	Field createField(String fieldName, Type type);
	
	Type[] avaliableTypes();

	List<Field> fields();

}
