package aroliveira.lab.time.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import aroliveira.lab.time.TimedBean;

@Stateless
@Remote
public class TimedBeanImpl implements TimedBean, TimedObject{

	@Resource
	TimerService timerService;

	
	public void cleanTimers(){
		
		System.out.println("\n\n\n\n\n\n\n\nTimedBeanImpl.limpaTimers()\n\n\n\n\n\n\n\n");
		
		for (Object object : timerService.getTimers()) {
			((Timer) object).cancel();
		}
	}	
	
	@Override
	public void ejbTimeout(Timer timer) {
		System.out.println("Execução automática: " + timer.getInfo() + System.currentTimeMillis());
	}

	@Override
	public void scheduleOnASpecificDate(Date dateOfTest, String desc) {
		
		System.out.println("Criando um novo timer: " + desc);
		
		timerService.createTimer(dateOfTest, desc);
	}

	@Override
	public void scheduleOnASpecificDateForAPeriod(Long dateOfTest, Long period,
			String desc) {
		System.out.println("Criando um novo timer: " + desc);
		timerService.createTimer(dateOfTest, period , desc);
	}
}