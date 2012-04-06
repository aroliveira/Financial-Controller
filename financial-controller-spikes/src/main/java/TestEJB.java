import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.naming.Context;
<<<<<<< HEAD
import javax.naming.NamingException;

import aroliveira.lab.fileManager.FieldBean;
=======
import javax.naming.InitialContext;
import javax.naming.NamingException;

>>>>>>> fb38caf897f2435fce1f7987ff1e9843a9d1c1bf
import aroliveira.lab.fileManager.LoadFile;
import aroliveira.lab.time.TimedBean;


public class TestEJB {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory"); 
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		
		System.out.println("criando o ctx");
<<<<<<< HEAD
		
		System.out.println(TesteEnumm.valueOf("JANEIRO"));
		
		
		//Context context = new InitialContext(props);
		
		//fileBeanTest(context);
		//timerBeanTest(context);
		//fieldBeanTest(context);
	}

	private static void fieldBeanTest(Context context) throws NamingException {
		System.out.println("bind");

		String ejbName = "financial-controller-ear-0.0.1-SNAPSHOT/FieldBeanImpl/remote";
		
		
		System.out.println("opaaaa" + context.lookup(ejbName));
		
		FieldBean x = (FieldBean) context.lookup(ejbName);
		
		System.out.println("opaaaa khkjhkjh: " + x);		
=======
		Context context = new InitialContext(props);
		
		//fileBeanTest(context);
		timerBeanTest(context);
>>>>>>> fb38caf897f2435fce1f7987ff1e9843a9d1c1bf
	}

	private static void timerBeanTest(Context context) throws NamingException {
		System.out.println("bind");

		String ejbName = "financial-controller-ear-0.0.1-SNAPSHOT/TimedBeanImpl/remote";
		
		System.out.println("opaaaa" + context.lookup(ejbName));
		
		TimedBean timedBean = (TimedBean) context.lookup(ejbName);
		
		System.out.println("opaaaa khkjhkjh");
		
		//fieldBean.createField("Uepa 2", "CURRENCY");
		Calendar instance = GregorianCalendar.getInstance();
		instance.add(Calendar.SECOND, 5);
		
		/*timedBean.scheduleOnASpecificDate(instance.getTime(), "Opa");		
		timedBean.scheduleOnASpecificDateForAPeriod(1000L, 3000L, "Opa");		
		timedBean.cleanTimers();*/
		
		System.out.println("sucesso");
	}

	private static void fileBeanTest(Context context) throws NamingException {
		System.out.println("bind");

		//String ejbName = "financial-controller-ear-0.0.1-SNAPSHOT/FieldBeanImpl/remote";
		String ejbName = "financial-controller-ear-0.0.1-SNAPSHOT/LoadFileBean/remote";
		
		System.out.println("opaaaa" + context.lookup(ejbName));
		
		//FieldBean fieldBean =  (FieldBean) context.lookup(ejbName);
		LoadFile fieldBean =  (LoadFile) context.lookup(ejbName);
		
		System.out.println("opaaaa khkjhkjh");
		
		//fieldBean.createField("Uepa 2", "CURRENCY");
		System.out.println(fieldBean.doSomeThing("Uepa 2"));		
	}
}
