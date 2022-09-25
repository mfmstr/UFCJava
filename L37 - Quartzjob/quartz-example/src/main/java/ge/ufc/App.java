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

            JobDetail JobCircle = JobBuilder.newJob(JobCircle.class).withIdentity("jobA", "group2").build();
            Trigger triggerA = TriggerBuilder.newTrigger().withIdentity("triggerA", "group2").startNow()
                    .withPriority(15)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(4))
                    .build();

            JobDetail JobRect = JobBuilder.newJob(JobRect.class).withIdentity("jobB", "group2").build();
            Trigger triggerB = TriggerBuilder.newTrigger().withIdentity("triggerB", "group2").startNow()
                    .withPriority(10)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(6).withRepeatCount(3))
                    .build();

            JobDetail JobTr = JobBuilder.newJob(JobTr.class).withIdentity("jobC", "group3").build();
            Trigger triggerC = TriggerBuilder.newTrigger().withIdentity("triggerC", "group3").startNow()
                    .withPriority(10)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(6).withRepeatCount(3))
                    .build();

              scheduler.scheduleJob(JobCircle, triggerA);
            scheduler.scheduleJob(JobRect, triggerB);
            scheduler.scheduleJob(JobTr, triggerC);
            scheduler.start();
        } catch (SchedulerException e) {
            lgg.error(e.getMessage(), e);
        }
    }
}
