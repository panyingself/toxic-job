package com.toxic.job.controller;

import com.toxic.job.business.JobCenterBusiness;
import com.toxic.job.model.Schedule;
import com.toxic.job.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author py
 * @date 2018/8/31 上午9:52.
 */
@Controller
@RequestMapping("/job")
public class JobCenterController {

    @Resource
    private JobCenterBusiness jobCenterBusiness;
    @RequestMapping(value = "/queryList")
    public String toJobList(Model model){

        model.addAttribute("jobList",jobCenterBusiness.getAllSchedule());
        return "job/job_list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model){

        model.addAttribute("job",jobCenterBusiness.getAllSchedule().get(0));
        return "job/job_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo realEdit(Schedule schedule){
        ResultVo resultVo = new ResultVo();
        int row = jobCenterBusiness.updateSchedule(schedule);
        resultVo.setData(row);
        return resultVo;
    }
}
