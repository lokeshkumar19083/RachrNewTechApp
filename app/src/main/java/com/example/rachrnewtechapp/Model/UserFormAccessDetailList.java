package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class UserFormAccessDetailList implements Serializable {

    public UserFormAccessDetailList() {
    }

    public int formId;
    public String formName;
    public boolean wfInitiator;
    public boolean wfReviwer;
    public boolean wfApprover;
    public int accessPermissionValue;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
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

    public int getAccessPermissionValue() {
        return accessPermissionValue;
    }

    public void setAccessPermissionValue(int accessPermissionValue) {
        this.accessPermissionValue = accessPermissionValue;
    }
}
