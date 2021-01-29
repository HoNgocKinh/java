package info.kinhho.check_status_at_school;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class TaskListener implements JobListener {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TaskListener";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getJobDetail().getKey().getName() + " to be Executed!");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getJobDetail().getKey().getName() + " execution Vetoed!");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		System.out.println(context.getJobDetail().getKey().getName() + " execution Success!!");
		System.out.println("Message: " + context.get("message").toString());
//		if (context.get("message").toString().equals("success")) {
//			new WindowNotification("Let's go!");
//		}
	}

}
