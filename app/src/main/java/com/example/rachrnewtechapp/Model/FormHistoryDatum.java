package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class FormHistoryDatum implements Serializable {

    public FormHistoryDatum() {
    }

    public String departmentId;
    public String initiatedBy;
    public String initiatedOn;
    public String actionTakenDepartmentId;
    public String modifiedOn;
    public String workFlowStatus;
    public String remarks;
    public String departmentName;
    public String actionTakenDepartmentName;
    public String userName;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getInitiatedOn() {
        return initiatedOn;
    }

    public void setInitiatedOn(String initiatedOn) {
        this.initiatedOn = initiatedOn;
    }

    public String getActionTakenDepartmentId() {
        return actionTakenDepartmentId;
    }

    public void setActionTakenDepartmentId(String actionTakenDepartmentId) {
        this.actionTakenDepartmentId = actionTakenDepartmentId;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getWorkFlowStatus() {
        return workFlowStatus;
    }

    public void setWorkFlowStatus(String workFlowStatus) {
        this.workFlowStatus = workFlowStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getActionTakenDepartmentName() {
        return actionTakenDepartmentName;
    }

    public void setActionTakenDepartmentName(String actionTakenDepartmentName) {
        this.actionTakenDepartmentName = actionTakenDepartmentName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
