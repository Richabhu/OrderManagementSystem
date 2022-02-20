package com.example.demo.utiles.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    private StatusResponse status;

    public BaseResponse() {
    }

    public StatusResponse getStatus() {
        return this.status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public String toString() {
        return "BaseResponse(status=" + this.getStatus() + ")";
    }
}
