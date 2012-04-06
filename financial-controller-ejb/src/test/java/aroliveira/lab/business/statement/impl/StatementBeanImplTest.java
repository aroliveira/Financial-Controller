package aroliveira.lab.business.statement.impl;

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

import aroliveira.lab.business.statement.StatementBean;

@RunWith(Arquillian.class)
public class StatementBeanImplTest {

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
				.addPackages(true, "aroliveira.lab.business.statement.Statement", "aroliveira.lab.business.statement");
	}

	@Test
	public void happyDay(){
		for (int i = 0; i < 10; i++) 
			statementBeanImpl.createStatement("rá", "ré", "rí");
		
	}
}