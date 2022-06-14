package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class NPRequestModel implements Serializable {

    public NPRequestModel() {
    }


    public String departmentID;
    public String userID;
    public boolean isFormsSharedMode;
    public String status;
    public String startDate;
    public String endDate;


    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isFormsSharedMode() {
        return isFormsSharedMode;
    }

    public void setFormsSharedMode(boolean formsSharedMode) {
        isFormsSharedMode = formsSharedMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
