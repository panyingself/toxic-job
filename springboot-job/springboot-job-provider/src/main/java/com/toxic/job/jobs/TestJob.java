/**
 * Reapal.com Inc.
 * Copyright (c) 2012-2013 All Rights Reserved.
 */
package com.toxic.job.jobs;

import com.toxic.job.template.CallBack;
import com.toxic.job.template.QuartzTemplate;
import org.springframework.stereotype.Component;

/**
 * 商户通知重发定时任务
 */
@Component
public class TestJob extends QuartzTemplate {


    /**
     * 执行方法
     */
    public void executeJobs() {
        System.out.println("test==============");
//        this.executeQuartz(
//                new CallBack() {
//            public void execute() {
//                for (int i =1 ; i<10;i++){
//                    System.out.println(i);
//                }
//            }
//
//            public String getLockKey() {
//                return this.getClass().getName() + ":execute";
//            }
//
//            public int getLockDuration() {
//                return defLockDuration;
//            }
//
//            public String getDescribe() {
//                return "商户通知重发定时任务";
//            }
//        });
    }

}
