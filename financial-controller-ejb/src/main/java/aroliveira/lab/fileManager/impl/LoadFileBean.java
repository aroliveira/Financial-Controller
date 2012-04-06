package aroliveira.lab.fileManager.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import aroliveira.lab.fileManager.LoadFile;

@Stateless
@Remote
//@TransactionManagement
public class LoadFileBean implements LoadFile{

	@PersistenceContext(unitName="DefaultDS")
	EntityManager manager;

	@PostConstruct
	public void toSomething(){
		System.out.println("LoadFileBean.toSomething()");
		System.out.println(manager == null);
	}
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String doSomeThing(String nomeDoField){
		try{	
			
			System.out.println("LoadFileBean.doSomeThing() 1");
			
			//Query query = manager.createQuery("FROM Field f");
			
			System.out.println("LoadFileBean.doSomeThing() 2");
			
			//System.out.println("Antes de salvar: " + query.getSingleResult());
			
			System.out.println("LoadFileBean.doSomeThing() 3");
			
			//manager.persist(new Field(nomeDoField, Type.DATE));
			
			//System.out.println("\n\n\n\n\n\nDepois de salvar: " + query.getSingleResult());
			return "Sucess";
		}catch (Exception e) {
			System.out.println("\n\n\n\n\n\n\n\nFODEU\n\n");
			e.printStackTrace();
			return e.getMessage();
		}
	}
/*	
	private Layout getLayout() {
		
		Field statamentDateField = new Field("Statement Date", Type.DATE);
		Field statementDescriptionField = new Field("Statement Description", Type.TEXT);
		Field statementValueField = new Field("Statement Value", Type.CURRENCY);
		
		LayoutField statamentDate = new LayoutField(statamentDateField, false, 0, 10);
		LayoutField statamentDescription = new LayoutField(statementDescriptionField, false, 11, 24);
		LayoutField statamentValue = new LayoutField(statementValueField, false, 36, 6);
		
		List<LayoutField> fields = new ArrayList<LayoutField>();		
		fields.add(statamentDate);
		fields.add(statamentDescription);
		fields.add(statamentValue);

		return new Layout(fields, "Test Layout");
	}*/	
}