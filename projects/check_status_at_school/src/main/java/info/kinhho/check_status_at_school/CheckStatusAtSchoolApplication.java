package info.kinhho.check_status_at_school;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckStatusAtSchoolApplication {

	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(CheckStatusAtSchoolApplication.class, args);
		
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler schedule = sf.getScheduler();
		
		JobDetail details = JobBuilder
								.newJob(Task.class)
								.build();
								
		JobListener jobListener = new TaskListener();
		
		Trigger trigger = TriggerBuilder.newTrigger()
							.withIdentity("trigger", "group1")
							.withSchedule(CronScheduleBuilder.cronSchedule("0 */1 * * * ? *"))
							.forJob(details)
							.build();
		
		schedule.scheduleJob(details, trigger);
		schedule.getListenerManager().addJobListener(jobListener);
		
		schedule.start();
	}

}
