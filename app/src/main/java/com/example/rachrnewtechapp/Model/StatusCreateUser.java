package com.example.rachrnewtechapp.Model;

import java.io.Serializable;

public class StatusCreateUser implements Serializable {

    public StatusCreateUser() {
    }

    public String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
