package com.example.rachrnewtechapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class EditDepartmentFormWrapper implements Serializable {

    public EditDepartmentFormWrapper() {
    }

    public ArrayList<FormReceiverDepartmentList> formReceiverDepartmentList;

    public ArrayList<FormReceiverDepartmentList> getFormReceiverDepartmentList() {
        return formReceiverDepartmentList;
    }

    public void setFormReceiverDepartmentList(ArrayList<FormReceiverDepartmentList> formReceiverDepartmentList) {
        this.formReceiverDepartmentList = formReceiverDepartmentList;
    }
}
