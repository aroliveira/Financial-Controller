package aroliveira.lab.time;

import java.util.Date;

public interface TimedBean {

	public void scheduleOnASpecificDate(Date dateOfTest, String desc);
	
	public void scheduleOnASpecificDateForAPeriod(Long dateOfTest, Long period, String desc);
	
	public void cleanTimers();
}
