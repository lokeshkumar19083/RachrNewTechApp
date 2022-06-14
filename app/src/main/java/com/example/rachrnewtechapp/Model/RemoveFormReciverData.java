package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class RemoveFormReciverData implements Serializable {

    public RemoveFormReciverData() {
    }
    public String id;
    public boolean isDeleted;
    public String modifiedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
