package com.toxic.job.mapper;

import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;

import java.util.List;

public interface ScheduleMapper {

    List<Schedule> queryForList(ScheduleQuery scheduleQuery);

    Schedule selectById(Long id);

    Integer updateById(Schedule schedule);

    Boolean insert(Schedule refund);

    Integer deleteById(Long id);

}