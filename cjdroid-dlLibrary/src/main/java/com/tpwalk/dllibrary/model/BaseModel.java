package com.tpwalk.dllibrary.model;

/**
 * Created by Administrator on 2017/6/27.
 */

public class BaseModel {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String status;
    private String message;
}
