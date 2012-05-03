package aroliveira.lab.business.statement;

import java.util.List;

import javax.ejb.Remote;

import aroliveira.lab.business.entities.statement.Statement;

@Remote
public interface StatementBean {
	
	Statement createStatement(String description, String statementValue, String purchaseDate);
	List<Statement> findAll();
	Statement findByDescription(String description);
	void update(Statement statement);
}
