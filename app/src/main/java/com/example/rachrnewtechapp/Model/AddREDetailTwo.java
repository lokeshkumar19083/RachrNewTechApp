package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class AddREDetailTwo implements Serializable {

    public AddREDetailTwo() {
    }

    public String employeeName;
    public String date;
    public String remark;


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
