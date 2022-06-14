package com.example.rachrnewtechapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class StatusResponse implements Serializable{

    public StatusResponse() {
    }

    public String userId;
    public String userName;
    public String departmentId;
    public String departmentName;
    public String userEmail;
    public int bandId;
    public String bandName;
    public String userType;
    public boolean isUserVerified;
    public boolean isActive;
    public boolean isDeleted;
    public Object token;
    public Object region;
    public String territory;
    public Object careTaker;
    public Object userState;
    public String reporting;
    public Object address;
    public Object contactNumber;
    public Date lastLoginTime;

    public ArrayList<UserFormAccessDetailList> userFormAccessDetailList;

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isUserVerified() {
        return isUserVerified;
    }

    public void setUserVerified(boolean userVerified) {
        isUserVerified = userVerified;
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

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public Object getRegion() {
        return region;
    }

    public void setRegion(Object region) {
        this.region = region;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public Object getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(Object careTaker) {
        this.careTaker = careTaker;
    }

    public Object getUserState() {
        return userState;
    }

    public void setUserState(Object userState) {
        this.userState = userState;
    }

    public String getReporting() {
        return reporting;
    }

    public void setReporting(String reporting) {
        this.reporting = reporting;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Object contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public ArrayList<UserFormAccessDetailList> getUserFormAccessDetailList() {
        return userFormAccessDetailList;
    }

    public void setUserFormAccessDetailList(ArrayList<UserFormAccessDetailList> userFormAccessDetailList) {
        this.userFormAccessDetailList = userFormAccessDetailList;
    }
}
