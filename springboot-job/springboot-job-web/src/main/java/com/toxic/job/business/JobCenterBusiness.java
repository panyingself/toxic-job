package com.toxic.job.business;

import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;
import com.toxic.job.service.ScheduleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        return row;
    }

}
