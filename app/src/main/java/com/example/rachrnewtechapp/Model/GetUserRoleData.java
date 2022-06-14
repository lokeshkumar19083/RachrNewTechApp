package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class GetUserRoleData implements Serializable {
    public GetUserRoleData() {
    }

    public String id;
    public int formValue;
    public String formName;
    public String departmentId;
    public String departmentName;
    public String userId;
    public String userName;
    public String userTypeId;
    public String userTypeName;
    public String bandName;
    public boolean wfInitiator;
    public boolean wfReviwer;
    public boolean wfApprover;
    public int workFlowValue;
    public int accessPermissionValue;
    public String accessPermissionDescription;
    public String formId;
    public String userBand;
    public boolean isActive;
    public boolean isDeleted;
    public String createdOn;
    public String createdBy;
    public String modifiedOn;
    public String modifiedBy;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

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

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
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

    public String getAccessPermissionDescription() {
        return accessPermissionDescription;
    }

    public void setAccessPermissionDescription(String accessPermissionDescription) {
        this.accessPermissionDescription = accessPermissionDescription;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
