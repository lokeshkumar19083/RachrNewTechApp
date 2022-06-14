package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class GetFormDataModel implements Serializable {

    public GetFormDataModel() {
    }

    public String formId;
    public String formName;
    public String departmentID;
    public String departmentName;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
