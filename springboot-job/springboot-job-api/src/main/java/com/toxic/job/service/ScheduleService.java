package com.toxic.job.service;

import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;
import com.toxic.job.page.Page;

import java.util.List;

/**
 * Created by Programmer.aj on 2017/8/17.
 */
public interface ScheduleService {

    List<Schedule> queryList(ScheduleQuery scheduleQuery);

    Page<Schedule> queryForList(Page<Schedule> page, ScheduleQuery refundQuery);

    Schedule selectById(Long id);

    Integer updateById(Schedule schedule);

    Boolean insert(Schedule refund);

    Integer deleteById(Long id);

}
