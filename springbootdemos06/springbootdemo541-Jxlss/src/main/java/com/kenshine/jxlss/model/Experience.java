package com.kenshine.jxlss.model;

import java.util.Date;

/**
 * 经历
 */
public class Experience {
    private String point;
    private Date startDate = new Date();
    private Date endDate = new Date();

    public Experience(String point) {
        this.point = point;
    }

    public Experience(String point, Date startDate, Date endDate) {
        this.point = point;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}