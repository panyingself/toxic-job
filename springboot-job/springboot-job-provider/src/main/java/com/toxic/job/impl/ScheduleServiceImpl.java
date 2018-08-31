package com.toxic.job.impl;

import com.github.pagehelper.PageHelper;
import com.toxic.job.mapper.ScheduleMapper;
import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;
import com.toxic.job.page.Page;
import com.toxic.job.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Programmer.aj on 2017/8/17.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    public List<Schedule> queryList(ScheduleQuery scheduleQuery) {
        return scheduleMapper.queryForList(scheduleQuery);
    }

    public Page<Schedule> queryForList(Page<Schedule> page, ScheduleQuery scheduleQuery) {
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(scheduleMapper.queryForList(scheduleQuery));
        return page;
    }

    public Schedule selectById(Long id) {
        return scheduleMapper.selectById(id);
    }

    public Integer updateById(Schedule schedule) {
        return scheduleMapper.updateById(schedule);
    }

    public Boolean insert(Schedule schedule) {
        return scheduleMapper.insert(schedule);
    }

    public Integer deleteById(Long id) {
        return scheduleMapper.deleteById(id);
    }

}
