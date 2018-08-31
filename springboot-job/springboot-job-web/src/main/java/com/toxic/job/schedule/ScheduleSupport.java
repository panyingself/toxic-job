package com.toxic.job.schedule;


import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;
import com.toxic.job.service.ScheduleService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ScheduleSupport {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleService scheduleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleSupport.class);

    /**
     * 初始化，动态定时器
     *
     * @throws Exception
     */
    @PostConstruct
    public void init() throws Exception {
        // 这里获取任务信息数据
        ScheduleQuery scheduleQuery = new ScheduleQuery();
        scheduleQuery.setStatus("1");//开启的
        List<Schedule> schedules = scheduleService.queryList(scheduleQuery);
        for (Schedule schedule : schedules) {
            add(schedule);
        }
    }

    /**
     * 添加任务
     *
     * @param schedule
     * @throws SchedulerException
     */
    @SuppressWarnings("unchecked")
    public void add(Schedule schedule) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(schedule.getJobName(), schedule.getJobGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if (trigger == null) {
            Class<?> clazz = QuartzJobFactoryDisallowConcurrentExecution.class;
            JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) clazz).withIdentity(schedule.getJobName(), schedule.getJobGroup()).build();
            jobDetail.getJobDataMap().put("schedule", schedule);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getCron());
            trigger = TriggerBuilder.newTrigger().withIdentity(schedule.getJobName(), schedule.getJobGroup()).withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getCron());
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    /**
     * 暂停一个job
     *
     * @param schedule
     * @throws SchedulerException
     */
    public void pause(Schedule schedule) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(schedule.getJobName(), schedule.getJobGroup());
        scheduler.pauseJob(jobKey);
        scheduleService.updateById(schedule);
    }

    /**
     * 恢复一个job
     *
     * @param schedule
     * @throws SchedulerException
     */
    public void resume(Schedule schedule) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(schedule.getJobName(), schedule.getJobGroup());
        scheduler.resumeJob(jobKey);
        scheduleService.updateById(schedule);
    }

    /**
     * 删除一个job
     *
     * @param schedule
     * @throws SchedulerException
     */
    public void delete(Schedule schedule) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(schedule.getJobName(), schedule.getJobGroup());
        scheduler.deleteJob(jobKey);
    }

    /**
     * 立即执行job
     *
     * @param schedule
     * @throws SchedulerException
     */
    public void runAJobNow(Schedule schedule) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(schedule.getJobName(), schedule.getJobGroup());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 更新job时间表达式
     *
     * @param schedule
     * @throws SchedulerException
     */
    public void updateJobCron(Schedule schedule) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(schedule.getJobName(), schedule.getJobGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        LOGGER.info("schedule :{}", schedule);
        LOGGER.info("triggerKey :{}", triggerKey);
        LOGGER.info("trigger :{}", trigger);
        LOGGER.info("schedule.getCron() :{}", schedule.getCron());
        LOGGER.info("CronScheduleBuilder :{}", CronScheduleBuilder.cronSchedule(schedule.getCron()));
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedule.getCron());

        LOGGER.info("开始测试-----------------");
        TriggerBuilder triggerBuilder = trigger.getTriggerBuilder();
        LOGGER.info("1.triggerBuilder:{}-----------------", triggerBuilder);
        TriggerBuilder tTriggerBuilder = triggerBuilder.withIdentity(triggerKey);
        LOGGER.info("2.tTriggerBuilder:{}-----------------", tTriggerBuilder);
        TriggerBuilder tTriggerBuilder2 = tTriggerBuilder.withSchedule(scheduleBuilder);
        LOGGER.info("3.tTriggerBuilder2:{}-----------------", tTriggerBuilder2);
        trigger = (CronTrigger) tTriggerBuilder2.build();
        LOGGER.info("4.trigger:{}-----------------", trigger);
        LOGGER.info("结束测试-----------------");
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, trigger);
    }
}
