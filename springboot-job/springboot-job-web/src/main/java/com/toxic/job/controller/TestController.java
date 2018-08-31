package com.toxic.job.controller;

import com.toxic.job.model.Schedule;
import com.toxic.job.model.query.ScheduleQuery;
import com.toxic.job.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author py
 * @date 2018/8/29 上午10:14.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private ScheduleService scheduleService;

    @RequestMapping(value = "/a")
    @ResponseBody
    public String getLists(){
        ScheduleQuery schedule = new ScheduleQuery();
        List<Schedule> scheduleList = scheduleService.queryList(schedule);
        return  scheduleList.toString();
    }

    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }
}
