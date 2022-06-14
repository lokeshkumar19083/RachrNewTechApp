package com.example.rachrnewtechapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ProjectNPModel implements Serializable {

    public ProjectNPModel() {
    }

    public String id;
    public int formID;
    public String formName;
    public String departmentID;
    public String userID;
    public String dependentDepartmentID;
    public String formReferenceNo;
    public String customerType;
    public String businessName;
    public String address;
    public String location;
    public String decisionMaker;
    public String designation;
    public String contactNo;
    public String email;
    public String area;
    public String expectedJobClosureDate;
    public String earlierFCsystem;
    public String earlierFCsystemSpecify;
    public String productSupplier;
    public String productSupplierOther;
    public String areaCurrentProject;
    public String expectedJobClosureDateCurrentProject;
    public String specifiedSystem;
    public String decisionMakerInspection;
    public String designationInspection;
    public String contactNoInspection;
    public String emailInspection;
    public String designationSampling;
    public String contactNoSampling;
    public String emailsampling;
    public String samplingRequired;
    public String name;
    public String contactNoApplicator;
    public String sampleApprovalStatus;
    public String sampleApprovalRating;
    public String sampleApprovalRejected;
    public String negotiatingPerson;
    public String designationNegotiatingPerson;
    public String contactNoNegotiatingPerson;
    public String emailNegotiatingPerson;
    public String agenda;
    public String moM;
    public String orderStatus;
    public String competitorName;
    public String price;
    public String date;
    public String week;
    public String floorArea;
    public String floorType;
    public String floorTypeOthers;
    public String concreteFloorStrength;
    public String floorHardnerOrAnyCuringAgent;
    public String floorHardnerOrAnyCuringAgentYes;
    public String soundnessOfTheFloor;
    public String scratchingTheSurface;
    public String checkofMoisture;
    public String cracksPitPots;
    public String impuritiesOnFloor;
    public String floorUndulations;
    public String movementOnFloor;
    public String expansionJoints;
    public String width;
    public String depth;
    public String expansioJointCurrentStatus;
    public String constructionJoints;
    public String constructionJointsCurrentStatus;
    public String coving;
    public String covingCurrentStatus;
    public String widthJoints;
    public String heightCoving;
    public String floorCheckImage;
    public String jointsCheckImage;
    public String expansionJointsCheckImage;
    public String covingsImage;
    public String projectStatus;
    public String rating;
    public Date deadline;
    public String soundnessOfTheFloorProblems;
    public String sampleApprover;
    public String state;
    public String district;
    public String primerImage;
    public String screedImage;
    public String topcoatImage;
    public String orderValue;
    public String status;
    public String territory;
    public String segment;
    public String formStage;
    public String departmentGI;
    public String departmentInspection;
    public String departmentsampling;
    public String departmentNegotiatingPerson;
    public String addREDetail;
    public boolean isActive;
    public boolean isDeleted;
    public String createdOn;
    public String createdBy;
    public String modifiedOn;
    public String modifiedBy;
    public String workFlowStatus;
    public ArrayList<FormHistoryDatum> formHistoryData;

    public boolean expanaded;

    public boolean isExpanaded() {
        return expanaded;
    }

    public void setExpanaded(boolean expanaded) {
        this.expanaded = expanaded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
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

    public String getFormReferenceNo() {
        return formReferenceNo;
    }

    public void setFormReferenceNo(String formReferenceNo) {
        this.formReferenceNo = formReferenceNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(String decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExpectedJobClosureDate() {
        return expectedJobClosureDate;
    }

    public void setExpectedJobClosureDate(String expectedJobClosureDate) {
        this.expectedJobClosureDate = expectedJobClosureDate;
    }

    public String getEarlierFCsystem() {
        return earlierFCsystem;
    }

    public void setEarlierFCsystem(String earlierFCsystem) {
        this.earlierFCsystem = earlierFCsystem;
    }

    public String getEarlierFCsystemSpecify() {
        return earlierFCsystemSpecify;
    }

    public void setEarlierFCsystemSpecify(String earlierFCsystemSpecify) {
        this.earlierFCsystemSpecify = earlierFCsystemSpecify;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

    public String getProductSupplierOther() {
        return productSupplierOther;
    }

    public void setProductSupplierOther(String productSupplierOther) {
        this.productSupplierOther = productSupplierOther;
    }

    public String getAreaCurrentProject() {
        return areaCurrentProject;
    }

    public void setAreaCurrentProject(String areaCurrentProject) {
        this.areaCurrentProject = areaCurrentProject;
    }

    public String getExpectedJobClosureDateCurrentProject() {
        return expectedJobClosureDateCurrentProject;
    }

    public void setExpectedJobClosureDateCurrentProject(String expectedJobClosureDateCurrentProject) {
        this.expectedJobClosureDateCurrentProject = expectedJobClosureDateCurrentProject;
    }

    public String getSpecifiedSystem() {
        return specifiedSystem;
    }

    public void setSpecifiedSystem(String specifiedSystem) {
        this.specifiedSystem = specifiedSystem;
    }

    public String getDecisionMakerInspection() {
        return decisionMakerInspection;
    }

    public void setDecisionMakerInspection(String decisionMakerInspection) {
        this.decisionMakerInspection = decisionMakerInspection;
    }

    public String getDesignationInspection() {
        return designationInspection;
    }

    public void setDesignationInspection(String designationInspection) {
        this.designationInspection = designationInspection;
    }

    public String getContactNoInspection() {
        return contactNoInspection;
    }

    public void setContactNoInspection(String contactNoInspection) {
        this.contactNoInspection = contactNoInspection;
    }

    public String getEmailInspection() {
        return emailInspection;
    }

    public void setEmailInspection(String emailInspection) {
        this.emailInspection = emailInspection;
    }

    public String getDesignationSampling() {
        return designationSampling;
    }

    public void setDesignationSampling(String designationSampling) {
        this.designationSampling = designationSampling;
    }

    public String getContactNoSampling() {
        return contactNoSampling;
    }

    public void setContactNoSampling(String contactNoSampling) {
        this.contactNoSampling = contactNoSampling;
    }

    public String getEmailsampling() {
        return emailsampling;
    }

    public void setEmailsampling(String emailsampling) {
        this.emailsampling = emailsampling;
    }

    public String getSamplingRequired() {
        return samplingRequired;
    }

    public void setSamplingRequired(String samplingRequired) {
        this.samplingRequired = samplingRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNoApplicator() {
        return contactNoApplicator;
    }

    public void setContactNoApplicator(String contactNoApplicator) {
        this.contactNoApplicator = contactNoApplicator;
    }

    public String getSampleApprovalStatus() {
        return sampleApprovalStatus;
    }

    public void setSampleApprovalStatus(String sampleApprovalStatus) {
        this.sampleApprovalStatus = sampleApprovalStatus;
    }

    public String getSampleApprovalRating() {
        return sampleApprovalRating;
    }

    public void setSampleApprovalRating(String sampleApprovalRating) {
        this.sampleApprovalRating = sampleApprovalRating;
    }

    public String getSampleApprovalRejected() {
        return sampleApprovalRejected;
    }

    public void setSampleApprovalRejected(String sampleApprovalRejected) {
        this.sampleApprovalRejected = sampleApprovalRejected;
    }

    public String getNegotiatingPerson() {
        return negotiatingPerson;
    }

    public void setNegotiatingPerson(String negotiatingPerson) {
        this.negotiatingPerson = negotiatingPerson;
    }

    public String getDesignationNegotiatingPerson() {
        return designationNegotiatingPerson;
    }

    public void setDesignationNegotiatingPerson(String designationNegotiatingPerson) {
        this.designationNegotiatingPerson = designationNegotiatingPerson;
    }

    public String getContactNoNegotiatingPerson() {
        return contactNoNegotiatingPerson;
    }

    public void setContactNoNegotiatingPerson(String contactNoNegotiatingPerson) {
        this.contactNoNegotiatingPerson = contactNoNegotiatingPerson;
    }

    public String getEmailNegotiatingPerson() {
        return emailNegotiatingPerson;
    }

    public void setEmailNegotiatingPerson(String emailNegotiatingPerson) {
        this.emailNegotiatingPerson = emailNegotiatingPerson;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getMoM() {
        return moM;
    }

    public void setMoM(String moM) {
        this.moM = moM;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public String getFloorTypeOthers() {
        return floorTypeOthers;
    }

    public void setFloorTypeOthers(String floorTypeOthers) {
        this.floorTypeOthers = floorTypeOthers;
    }

    public String getConcreteFloorStrength() {
        return concreteFloorStrength;
    }

    public void setConcreteFloorStrength(String concreteFloorStrength) {
        this.concreteFloorStrength = concreteFloorStrength;
    }

    public String getFloorHardnerOrAnyCuringAgent() {
        return floorHardnerOrAnyCuringAgent;
    }

    public void setFloorHardnerOrAnyCuringAgent(String floorHardnerOrAnyCuringAgent) {
        this.floorHardnerOrAnyCuringAgent = floorHardnerOrAnyCuringAgent;
    }

    public String getFloorHardnerOrAnyCuringAgentYes() {
        return floorHardnerOrAnyCuringAgentYes;
    }

    public void setFloorHardnerOrAnyCuringAgentYes(String floorHardnerOrAnyCuringAgentYes) {
        this.floorHardnerOrAnyCuringAgentYes = floorHardnerOrAnyCuringAgentYes;
    }

    public String getSoundnessOfTheFloor() {
        return soundnessOfTheFloor;
    }

    public void setSoundnessOfTheFloor(String soundnessOfTheFloor) {
        this.soundnessOfTheFloor = soundnessOfTheFloor;
    }

    public String getScratchingTheSurface() {
        return scratchingTheSurface;
    }

    public void setScratchingTheSurface(String scratchingTheSurface) {
        this.scratchingTheSurface = scratchingTheSurface;
    }

    public String getCheckofMoisture() {
        return checkofMoisture;
    }

    public void setCheckofMoisture(String checkofMoisture) {
        this.checkofMoisture = checkofMoisture;
    }

    public String getCracksPitPots() {
        return cracksPitPots;
    }

    public void setCracksPitPots(String cracksPitPots) {
        this.cracksPitPots = cracksPitPots;
    }

    public String getImpuritiesOnFloor() {
        return impuritiesOnFloor;
    }

    public void setImpuritiesOnFloor(String impuritiesOnFloor) {
        this.impuritiesOnFloor = impuritiesOnFloor;
    }

    public String getFloorUndulations() {
        return floorUndulations;
    }

    public void setFloorUndulations(String floorUndulations) {
        this.floorUndulations = floorUndulations;
    }

    public String getMovementOnFloor() {
        return movementOnFloor;
    }

    public void setMovementOnFloor(String movementOnFloor) {
        this.movementOnFloor = movementOnFloor;
    }

    public String getExpansionJoints() {
        return expansionJoints;
    }

    public void setExpansionJoints(String expansionJoints) {
        this.expansionJoints = expansionJoints;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getExpansioJointCurrentStatus() {
        return expansioJointCurrentStatus;
    }

    public void setExpansioJointCurrentStatus(String expansioJointCurrentStatus) {
        this.expansioJointCurrentStatus = expansioJointCurrentStatus;
    }

    public String getConstructionJoints() {
        return constructionJoints;
    }

    public void setConstructionJoints(String constructionJoints) {
        this.constructionJoints = constructionJoints;
    }

    public String getConstructionJointsCurrentStatus() {
        return constructionJointsCurrentStatus;
    }

    public void setConstructionJointsCurrentStatus(String constructionJointsCurrentStatus) {
        this.constructionJointsCurrentStatus = constructionJointsCurrentStatus;
    }

    public String getCoving() {
        return coving;
    }

    public void setCoving(String coving) {
        this.coving = coving;
    }

    public String getCovingCurrentStatus() {
        return covingCurrentStatus;
    }

    public void setCovingCurrentStatus(String covingCurrentStatus) {
        this.covingCurrentStatus = covingCurrentStatus;
    }

    public String getWidthJoints() {
        return widthJoints;
    }

    public void setWidthJoints(String widthJoints) {
        this.widthJoints = widthJoints;
    }

    public String getHeightCoving() {
        return heightCoving;
    }

    public void setHeightCoving(String heightCoving) {
        this.heightCoving = heightCoving;
    }

    public String getFloorCheckImage() {
        return floorCheckImage;
    }

    public void setFloorCheckImage(String floorCheckImage) {
        this.floorCheckImage = floorCheckImage;
    }

    public String getJointsCheckImage() {
        return jointsCheckImage;
    }

    public void setJointsCheckImage(String jointsCheckImage) {
        this.jointsCheckImage = jointsCheckImage;
    }

    public String getExpansionJointsCheckImage() {
        return expansionJointsCheckImage;
    }

    public void setExpansionJointsCheckImage(String expansionJointsCheckImage) {
        this.expansionJointsCheckImage = expansionJointsCheckImage;
    }

    public String getCovingsImage() {
        return covingsImage;
    }

    public void setCovingsImage(String covingsImage) {
        this.covingsImage = covingsImage;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getSoundnessOfTheFloorProblems() {
        return soundnessOfTheFloorProblems;
    }

    public void setSoundnessOfTheFloorProblems(String soundnessOfTheFloorProblems) {
        this.soundnessOfTheFloorProblems = soundnessOfTheFloorProblems;
    }

    public String getSampleApprover() {
        return sampleApprover;
    }

    public void setSampleApprover(String sampleApprover) {
        this.sampleApprover = sampleApprover;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPrimerImage() {
        return primerImage;
    }

    public void setPrimerImage(String primerImage) {
        this.primerImage = primerImage;
    }

    public String getScreedImage() {
        return screedImage;
    }

    public void setScreedImage(String screedImage) {
        this.screedImage = screedImage;
    }

    public String getTopcoatImage() {
        return topcoatImage;
    }

    public void setTopcoatImage(String topcoatImage) {
        this.topcoatImage = topcoatImage;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getFormStage() {
        return formStage;
    }

    public void setFormStage(String formStage) {
        this.formStage = formStage;
    }

    public String getDepartmentGI() {
        return departmentGI;
    }

    public void setDepartmentGI(String departmentGI) {
        this.departmentGI = departmentGI;
    }

    public String getDepartmentInspection() {
        return departmentInspection;
    }

    public void setDepartmentInspection(String departmentInspection) {
        this.departmentInspection = departmentInspection;
    }

    public String getDepartmentsampling() {
        return departmentsampling;
    }

    public void setDepartmentsampling(String departmentsampling) {
        this.departmentsampling = departmentsampling;
    }

    public String getDepartmentNegotiatingPerson() {
        return departmentNegotiatingPerson;
    }

    public void setDepartmentNegotiatingPerson(String departmentNegotiatingPerson) {
        this.departmentNegotiatingPerson = departmentNegotiatingPerson;
    }

    public String getAddREDetail() {
        return addREDetail;
    }

    public void setAddREDetail(String addREDetail) {
        this.addREDetail = addREDetail;
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

    public ArrayList<FormHistoryDatum> getFormHistoryData() {
        return formHistoryData;
    }

    public void setFormHistoryData(ArrayList<FormHistoryDatum> formHistoryData) {
        this.formHistoryData = formHistoryData;
    }
}
