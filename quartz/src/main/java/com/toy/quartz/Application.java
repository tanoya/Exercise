package com.toy.quartz;

import com.toy.quartz.jobs.FirstJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Application {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();// start

            JobDetail jobDetail = JobBuilder.newJob(FirstJob.class)
                    .withIdentity("jb01", "group01")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("jb01tg","group01")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);

            scheduler.shutdown(false); // end of job
        } catch (Exception e) {
            System.out.println("error happened");
        }
    }
}
