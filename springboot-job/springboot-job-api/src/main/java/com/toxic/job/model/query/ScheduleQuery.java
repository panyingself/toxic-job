package com.toxic.job.model.query;

import com.toxic.job.model.Schedule;

import java.util.Date;


public class ScheduleQuery extends Schedule {

    private Date createDateTimeFrom;

    private Date createDateTimeTo;

    public Date getCreateDateTimeFrom() {
        return createDateTimeFrom;
    }

    public void setCreateDateTimeFrom(Date createDateTimeFrom) {
        this.createDateTimeFrom = createDateTimeFrom;
    }

    public Date getCreateDateTimeTo() {
        return createDateTimeTo;
    }

    public void setCreateDateTimeTo(Date createDateTimeTo) {
        this.createDateTimeTo = createDateTimeTo;
    }
}