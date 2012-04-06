package aroliveira.lab.business.statement;

import javax.ejb.Remote;

@Remote
public interface StatementBean {
	Statement createStatement(String description, String statementValue, String purchaseDate);	
}
