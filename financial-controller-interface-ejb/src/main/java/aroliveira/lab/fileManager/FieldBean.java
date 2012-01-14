package aroliveira.lab.fileManager;

public interface FieldBean {
	
	void createField(String fieldName, String fieldType);
	void updateField(String fieldName, String fieldType);
	void deleteField(String fieldName);
	void listAll();
}
