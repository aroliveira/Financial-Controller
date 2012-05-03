package aroliveira.lab.business.statement.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import aroliveira.lab.business.entities.statement.Statement;
import aroliveira.lab.business.statement.StatementBean;

@Stateless
public class StatementBeanImpl implements StatementBean {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Statement createStatement(String description, String statementValue,
			String purchaseDate) {
		
		Statement statement = new Statement(description, statementValue, purchaseDate);
		em.persist(statement);		
		
		return statement;
	}
	
	@SuppressWarnings("unchecked")
	public List<Statement> findAll(){
		Query namedQuery = em.createNamedQuery("Statement.findAll");
		return namedQuery.getResultList();
	}

	@Override
	public Statement findByDescription(String description) {
		Query namedQuery = em.createNamedQuery("Statement.findByDescription");
		namedQuery.setParameter(1, description);
		return (Statement) namedQuery.getSingleResult();
	}

	@Override
	public void update(Statement statement) {
		em.refresh(statement);
	}
}