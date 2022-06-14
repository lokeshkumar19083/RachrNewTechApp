package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class DcrRequestModel implements Serializable {

    public DcrRequestModel() {
    }

    public String departmentID;
    public String userID;
    public boolean isFormsSharedMode;

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
}
