package aroliveira.lab.business.statement.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Test;
import org.junit.runner.RunWith;

import aroliveira.lab.business.entities.statement.Statement;
import aroliveira.lab.business.statement.StatementBean;
import aroliveira.lab.structure.util.DateConverter;

@RunWith(Arquillian.class)
public class StatementBeanImplTest {

	final String expectedStatementDescription = "Statement Description for test";		
	final String expectedStatementValue = "10.56";
	final String expectedPurchaseDate = "10/10/2012";

	@EJB
	private StatementBean statementBeanImpl;
	
	@Deployment
	public static JavaArchive createTestArchive(){
		JavaArchive commonsDriver = DependencyResolvers
	            .use(MavenDependencyResolver.class)
	            .loadMetadataFromPom("pom.xml").artifact("aroliveira.lab:commons-driver").resolveAs(JavaArchive.class).iterator().next();
		
		JavaArchive financialControllerInterfaceEjb = DependencyResolvers
	            .use(MavenDependencyResolver.class)
	            .loadMetadataFromPom("pom.xml").artifact("aroliveira.lab:financial-controller-interface-ejb").resolveAs(JavaArchive.class).iterator().next();


		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.merge(commonsDriver)
				.merge(financialControllerInterfaceEjb)
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
				.addAsManifestResource("test_persistence.xml", "persistence.xml")
				.addPackages(true, "aroliveira.lab.business.statement.Statement", "aroliveira.lab.business.statement");
	}

	//@Test
	public void insertHappyDay() throws ParseException{

		statementBeanImpl.createStatement(expectedStatementDescription, expectedStatementValue, expectedPurchaseDate);

		List<Statement> all = statementBeanImpl.findAll();
		Statement statement = all.get(0);

		assertEquals("Statements count",1,all.size());
		assertEquals("Statement Description", expectedStatementDescription, statement.getDescription());
		assertEquals("Statament value", new Double(1056), statement.getStatementValue());
		assertEquals("Statement purchase date", DateConverter.convertToDate(expectedPurchaseDate), statement.getPurchaseDate());
	}
	
	//@Test
	public void findByDescription(){
		insertDefault();
		
		Statement statement = statementBeanImpl.findByDescription(expectedStatementDescription);
		assertNotNull("Should exists a statement with description " + expectedStatementDescription, statement);

		statement = statementBeanImpl.findByDescription("inexistente");
		assertNull("Should not exists a statement with description: inexistente", statement);
	}
	
	@Test
	public void alteraHappyDay(){
		
		assertEquals("Quantity of inserted statement",0, statementBeanImpl.findAll().size());
		insertDefault();
		assertEquals("Quantity of inserted statement",1, statementBeanImpl.findAll().size());

		Statement statement = statementBeanImpl.findByDescription(expectedStatementDescription);
		statement.setDescription("new description");
		statementBeanImpl.update(statement);
	}

	private Statement insertDefault() {
		return statementBeanImpl.createStatement(expectedStatementDescription, expectedStatementValue, expectedPurchaseDate);
	}

	@Test
	public void dontCreateAStatementWithEmptyPurchaseDate(){
		try {
			new Statement(expectedStatementDescription, expectedStatementValue, "");
		} catch (RuntimeException e) {
			assertEquals("Message error", "Statement purchase date can't be null or empty", e.getMessage());
		}
	}
}