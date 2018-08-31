package com.toxic.job.model;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable{
    private static final long serialVersionUID = 6744047355415718603L;
    private Long id;//id
    private String jobName;//任务名称
    private String jobGroup;//任务分组
    private String cron;//任务表达式
    private String beanName;//类名
    private String isConcurrent;//是否并发
    private String methodName;//方法名
    private String createUserId;//创建人
    private Date createDateTime;//创建时间
    private String modifyUserId;//修改人
    private Date modifyDateTime;//修改时间
    private String remarks;//备注
    private String status;//状态
    private String deleteFlag;//删除标示

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    public String getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent == null ? null : isConcurrent.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(Date modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", cron='" + cron + '\'' +
                ", beanName='" + beanName + '\'' +
                ", isConcurrent='" + isConcurrent + '\'' +
                ", methodName='" + methodName + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createDateTime=" + createDateTime +
                ", modifyUserId='" + modifyUserId + '\'' +
                ", modifyDateTime=" + modifyDateTime +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                ", deleteFlag='" + deleteFlag + '\'' +
                '}';
    }
}