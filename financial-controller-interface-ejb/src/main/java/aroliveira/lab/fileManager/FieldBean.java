package aroliveira.lab.fileManager;

<<<<<<< HEAD
import java.util.List;

import aroliveira.lab.structure.entities.layout.Field;
import aroliveira.lab.structure.util.Type;

public interface FieldBean {
	
	Field createField(String fieldName, Type type);
	
	Type[] avaliableTypes();

	List<Field> fields();
=======
public interface FieldBean {
	
	void createField(String fieldName, String fieldType);
	void updateField(String fieldName, String fieldType);
	void deleteField(String fieldName);
	void listAll();
>>>>>>> fb38caf897f2435fce1f7987ff1e9843a9d1c1bf
}
