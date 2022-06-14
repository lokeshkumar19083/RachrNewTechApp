package com.example.rachrnewtechapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DcrResponseModel implements Serializable {

    public DcrResponseModel() {

    }
    public String id;
    public String departmentID;
    public String userID;
    public String dependentDepartmentID;
    public String employeeName;
    public String territory;
    public String date;
    public String weekAndYear;
    public String referenceNumber;
    public boolean isActive;
    public boolean isDeleted;
    public String createdOn;
    public String createdBy;
    public String modifiedOn;
    public String modifiedBy;
    public String workFlowStatus;
    public ArrayList<AddDARFCDetail> addDARFCDetail;
    public ArrayList<FormHistoryData> formHistoryData;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDependentDepartmentID() {
        return dependentDepartmentID;
    }

    public void setDependentDepartmentID(String dependentDepartmentID) {
        this.dependentDepartmentID = dependentDepartmentID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekAndYear() {
        return weekAndYear;
    }

    public void setWeekAndYear(String weekAndYear) {
        this.weekAndYear = weekAndYear;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
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

    public String getWorkFlowStatus() {
        return workFlowStatus;
    }

    public void setWorkFlowStatus(String workFlowStatus) {
        this.workFlowStatus = workFlowStatus;
    }

    public ArrayList<AddDARFCDetail> getAddDARFCDetail() {
        return addDARFCDetail;
    }

    public void setAddDARFCDetail(ArrayList<AddDARFCDetail> addDARFCDetail) {
        this.addDARFCDetail = addDARFCDetail;
    }

    public ArrayList<FormHistoryData> getFormHistoryData() {
        return formHistoryData;
    }

    public void setFormHistoryData(ArrayList<FormHistoryData> formHistoryData) {
        this.formHistoryData = formHistoryData;
    }
}
