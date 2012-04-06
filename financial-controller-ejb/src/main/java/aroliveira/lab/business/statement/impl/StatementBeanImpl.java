package aroliveira.lab.business.statement.impl;

import javax.ejb.Stateless;

import aroliveira.lab.business.statement.Statement;
import aroliveira.lab.business.statement.StatementBean;

@Stateless
public class StatementBeanImpl implements StatementBean {

	@Override
	public Statement createStatement(String description, String statementValue,
			String purchaseDate) {
		
		System.out.println("StatementBeanImpl.createStatement()");
		return null;
	}
}