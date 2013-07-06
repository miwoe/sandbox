package mwoelm.sample;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyClass myClass = (MyClass) ctx.getBean("myClass");
		System.out.println(myClass.isField());
		
		// get the job
		Job job = (Job) ctx.getBean("myJob");

		// get the jobLauncher
		JobLauncher launcher = (JobLauncher) ctx.getBean("jobLauncher");

		// launch the job
		JobExecution jobExecution = launcher.run(job, new JobParameters());

		// (optional)assert job run status
		// assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}
}
