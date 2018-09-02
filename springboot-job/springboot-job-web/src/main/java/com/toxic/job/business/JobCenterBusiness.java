package com.toxic.job.business;

import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;
import com.toxic.job.schedule.ScheduleSupport;
import com.toxic.job.service.ScheduleService;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author py
 * @date 2018/8/31 上午9:55.
 * 任务中心business
 */
@Component
public class JobCenterBusiness {
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private ScheduleSupport scheduleSupport;
    /**
     * @param
     * @return java.util.List<com.toxic.job.model.Schedule>
     * @author py
     * @date  上午9:57
     * 获取所有定时
     * @exception
     */
    public List<Schedule> getAllSchedule(){
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        try {
            scheduleList = scheduleService.queryList(new ScheduleQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public Schedule getScheduleByid(Long id){
        return scheduleService.selectById(id);
    }

    /**
     * @param
     * @return void
     * @author py
     * @date  下午5:06
     * 修改指定定时
     * @exception
     */
    public int updateSchedule(Schedule schedule){
        int row = scheduleService.updateById(schedule);
        //修改成功、重新定位定时信息
        if( row > 0 ){
            try {
                if( "0".equals(schedule.getStatus()) ){
                    scheduleSupport.delete(schedule);
                }
                scheduleSupport.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return row;
    }
    /**
      * Method: 
      * Description: 添加schedule
      * Author: py
      * Data: 2018/9/2 14:21
       * @param schedule
      * @return void
      */
    public void insertSchedule(Schedule schedule){

        if( null != schedule){
            schedule.setCreateDateTime(new Date());
            schedule.setStatus("1");
        }
        scheduleService.insert(schedule);
        try {
            scheduleSupport.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
      * Method: 
      * Description: 删除某个schedule
      * Author: py
      * Data: 2018/9/2 14:42
       * @param id
      * @return void
      */
    public void deleteSchedule(Long id){
        Schedule schedule = scheduleService.selectById(id);
        try {
            scheduleSupport.delete(schedule);
            scheduleService.deleteById(id);
            scheduleSupport.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
