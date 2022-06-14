package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class FormHistoryDataTwo implements Serializable {

    public FormHistoryDataTwo() {
    }

    public String formValue;
    public String departmentId;
    public String initiatedBy;
    public String actionTakenDepartmentId;
    public String workFlowStatus;
    public String remarks;


    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue;
    }

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

    public String getActionTakenDepartmentId() {
        return actionTakenDepartmentId;
    }

    public void setActionTakenDepartmentId(String actionTakenDepartmentId) {
        this.actionTakenDepartmentId = actionTakenDepartmentId;
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
}
