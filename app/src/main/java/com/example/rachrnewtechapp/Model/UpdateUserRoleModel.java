package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class UpdateUserRoleModel implements Serializable {

    public UpdateUserRoleModel() {
    }

    public String id;
    public int formValue;
    public String departmentId;
    public String userId;
    public boolean wfInitiator;
    public boolean wfReviwer;
    public boolean wfApprover;
    public int workFlowValue;
    public int accessPermissionValue;
    public String formId;
    public String userBand;
    public boolean isActive;
    public String modifiedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFormValue() {
        return formValue;
    }

    public void setFormValue(int formValue) {
        this.formValue = formValue;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isWfInitiator() {
        return wfInitiator;
    }

    public void setWfInitiator(boolean wfInitiator) {
        this.wfInitiator = wfInitiator;
    }

    public boolean isWfReviwer() {
        return wfReviwer;
    }

    public void setWfReviwer(boolean wfReviwer) {
        this.wfReviwer = wfReviwer;
    }

    public boolean isWfApprover() {
        return wfApprover;
    }

    public void setWfApprover(boolean wfApprover) {
        this.wfApprover = wfApprover;
    }

    public int getWorkFlowValue() {
        return workFlowValue;
    }

    public void setWorkFlowValue(int workFlowValue) {
        this.workFlowValue = workFlowValue;
    }

    public int getAccessPermissionValue() {
        return accessPermissionValue;
    }

    public void setAccessPermissionValue(int accessPermissionValue) {
        this.accessPermissionValue = accessPermissionValue;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getUserBand() {
        return userBand;
    }

    public void setUserBand(String userBand) {
        this.userBand = userBand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
