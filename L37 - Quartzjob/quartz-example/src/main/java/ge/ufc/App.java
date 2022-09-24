package ge.ufc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import ge.ufc.jobs.JobCircle;
import ge.ufc.jobs.JobRect;
import ge.ufc.jobs.JobTr;


public class App {
    private static final Logger lgg = LogManager.getLogger();

    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            JobDetail jobA = JobBuilder.newJob(JobCircle.class).withIdentity("jobA", "group2").build();
            Trigger triggerA = TriggerBuilder.newTrigger().withIdentity("triggerA", "group2").startNow()
                    .withPriority(15)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(4))
                    .build();

            JobDetail jobB = JobBuilder.newJob(JobRect.class).withIdentity("jobB", "group2").build();
            Trigger triggerB = TriggerBuilder.newTrigger().withIdentity("triggerB", "group2").startNow()
                    .withPriority(10)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(6).withRepeatCount(3))
                    .build();

            JobDetail job = JobBuilder.newJob(JobTr.class).withIdentity("myJob", "group1")
                    .usingJobData("jobSays", "Hello World!").usingJobData("myFloatValue", 3.141f).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(7).withRepeatCount(5))
                    .build();

            scheduler.scheduleJob(jobA, triggerA);
            scheduler.scheduleJob(jobB, triggerB);
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            lgg.error(e.getMessage(), e);
        }
    }
}
