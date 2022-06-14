package com.example.rachrnewtechapp.Model;

import java.io.Serializable;
import java.util.Date;

public class AddREDetail implements Serializable {

    public AddREDetail() {
    }


    public String id;
    public String employeeName;
    public String date;
    public String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
