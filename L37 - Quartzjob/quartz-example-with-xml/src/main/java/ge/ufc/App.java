package ge.ufc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;

public class App {
    private static final Logger lgg = LogManager.getLogger();

    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            try {
                Thread.sleep(30_000);
            } catch (Exception e) {
                //
            }
            
            scheduler.shutdown(true);
            
            SchedulerMetaData metaData = scheduler.getMetaData();
            lgg.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
        } catch (SchedulerException e) {
            lgg.error(e.getMessage(), e);
        }
    }
}
