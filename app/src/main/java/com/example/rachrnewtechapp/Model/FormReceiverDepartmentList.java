package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class FormReceiverDepartmentList implements Serializable {

    public FormReceiverDepartmentList() {
    }

    public String id;
    public int formValue;
    public String departmentID;
    public String receiverDepartmentID;
    public String formName;
    public String departmentName;
    public String receiverDepartmentName;
    public String l1_Role;
    public String l1_FormStage;
    public String l1_AccessPermissionValue;
    public String l2_Role;
    public String l2_FormStage;
    public String l2_AccessPermissionValue;
    public String l3_Role;
    public String l3_FormStage;
    public String l3_AccessPermissionValue;
    public String l4_Role;
    public String l4_FormStage;
    public String l4_AccessPermissionValue;
    public String l5_Role;
    public String l5_FormStage;
    public String l5_AccessPermissionValue;
    public String receiverDepartmentAccessLevel;
    public String dependentDepartmentId;
    public boolean isActive;
    public boolean isDeleted;
    public String createdOn;
    public String createdBy;
    public String modifiedOn;
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

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getReceiverDepartmentID() {
        return receiverDepartmentID;
    }

    public void setReceiverDepartmentID(String receiverDepartmentID) {
        this.receiverDepartmentID = receiverDepartmentID;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getReceiverDepartmentName() {
        return receiverDepartmentName;
    }

    public void setReceiverDepartmentName(String receiverDepartmentName) {
        this.receiverDepartmentName = receiverDepartmentName;
    }

    public String getL1_Role() {
        return l1_Role;
    }

    public void setL1_Role(String l1_Role) {
        this.l1_Role = l1_Role;
    }

    public String getL1_FormStage() {
        return l1_FormStage;
    }

    public void setL1_FormStage(String l1_FormStage) {
        this.l1_FormStage = l1_FormStage;
    }

    public String getL1_AccessPermissionValue() {
        return l1_AccessPermissionValue;
    }

    public void setL1_AccessPermissionValue(String l1_AccessPermissionValue) {
        this.l1_AccessPermissionValue = l1_AccessPermissionValue;
    }

    public String getL2_Role() {
        return l2_Role;
    }

    public void setL2_Role(String l2_Role) {
        this.l2_Role = l2_Role;
    }

    public String getL2_FormStage() {
        return l2_FormStage;
    }

    public void setL2_FormStage(String l2_FormStage) {
        this.l2_FormStage = l2_FormStage;
    }

    public String getL2_AccessPermissionValue() {
        return l2_AccessPermissionValue;
    }

    public void setL2_AccessPermissionValue(String l2_AccessPermissionValue) {
        this.l2_AccessPermissionValue = l2_AccessPermissionValue;
    }

    public String getL3_Role() {
        return l3_Role;
    }

    public void setL3_Role(String l3_Role) {
        this.l3_Role = l3_Role;
    }

    public String getL3_FormStage() {
        return l3_FormStage;
    }

    public void setL3_FormStage(String l3_FormStage) {
        this.l3_FormStage = l3_FormStage;
    }

    public String getL3_AccessPermissionValue() {
        return l3_AccessPermissionValue;
    }

    public void setL3_AccessPermissionValue(String l3_AccessPermissionValue) {
        this.l3_AccessPermissionValue = l3_AccessPermissionValue;
    }

    public String getL4_Role() {
        return l4_Role;
    }

    public void setL4_Role(String l4_Role) {
        this.l4_Role = l4_Role;
    }

    public String getL4_FormStage() {
        return l4_FormStage;
    }

    public void setL4_FormStage(String l4_FormStage) {
        this.l4_FormStage = l4_FormStage;
    }

    public String getL4_AccessPermissionValue() {
        return l4_AccessPermissionValue;
    }

    public void setL4_AccessPermissionValue(String l4_AccessPermissionValue) {
        this.l4_AccessPermissionValue = l4_AccessPermissionValue;
    }

    public String getL5_Role() {
        return l5_Role;
    }

    public void setL5_Role(String l5_Role) {
        this.l5_Role = l5_Role;
    }

    public String getL5_FormStage() {
        return l5_FormStage;
    }

    public void setL5_FormStage(String l5_FormStage) {
        this.l5_FormStage = l5_FormStage;
    }

    public String getL5_AccessPermissionValue() {
        return l5_AccessPermissionValue;
    }

    public void setL5_AccessPermissionValue(String l5_AccessPermissionValue) {
        this.l5_AccessPermissionValue = l5_AccessPermissionValue;
    }

    public String getReceiverDepartmentAccessLevel() {
        return receiverDepartmentAccessLevel;
    }

    public void setReceiverDepartmentAccessLevel(String receiverDepartmentAccessLevel) {
        this.receiverDepartmentAccessLevel = receiverDepartmentAccessLevel;
    }

    public String getDependentDepartmentId() {
        return dependentDepartmentId;
    }

    public void setDependentDepartmentId(String dependentDepartmentId) {
        this.dependentDepartmentId = dependentDepartmentId;
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
