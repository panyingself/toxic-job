package com.toxic.job.schedule;

import com.toxic.job.model.Schedule;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 *
 * @author cc
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {

    private static Logger logger = LoggerFactory.getLogger(QuartzJobFactoryDisallowConcurrentExecution.class.getName());

    private ExecutorService service = Executors.newSingleThreadExecutor();

    public void execute(JobExecutionContext context) throws JobExecutionException {
        Schedule schedule = (Schedule) context.getMergedJobDataMap().get("schedule");
        try {
            long startTime = System.currentTimeMillis();
            ScheduleRunnable task = new ScheduleRunnable(schedule.getBeanName(), schedule.getMethodName(), null);
            Future<?> future = service.submit(task);
            future.get();
            long times = System.currentTimeMillis() - startTime;
            logger.info("任务执行完毕，任务名称：" + schedule.getJobName() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务名称：" + schedule.getJobName(), e);
        }
    }
}