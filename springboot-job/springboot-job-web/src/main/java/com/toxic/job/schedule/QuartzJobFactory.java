//package com.toxic.job.schedule;
//
//import com.toxic.job.model.Schedule;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
///**
// * 计划任务执行处 无状态
// *
// * @author cc
// */
//public class QuartzJobFactory implements Job {
//
//	private static Logger logger = LoggerFactory.getLogger(QuartzJobFactory.class.getName());
//
//	private ExecutorService service = Executors.newSingleThreadExecutor();
//
//	public void execute(JobExecutionContext context) throws JobExecutionException {
//		Schedule schedule = (Schedule) context.getMergedJobDataMap().get("schedule");
//		try {
//			long startTime = System.currentTimeMillis();
//			ScheduleRunnable task = new ScheduleRunnable(schedule.getBeanName(), schedule.getMethodName(),null);
//			Future<?> future = service.submit(task);
//			future.get();
//			long times = System.currentTimeMillis() - startTime;
//			logger.info("任务执行完毕，任务名称：" + schedule.getJobName() + "  总共耗时：" + times + "毫秒");
//		} catch (Exception e) {
//			logger.error("任务执行失败，任务名称：" + schedule.getJobName(), e);
//		}
//	}
//}