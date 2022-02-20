package com.example.demo.utiles.response;

import java.io.Serializable;


public class StatusResponse implements Serializable {
    private Integer statusCode;
    private String statusMessage = "";
    private StatusResponse.Type statusType;
    private Integer totalCount;

    public StatusResponse(StatusCode statusCode, StatusResponse.Type statusType, Integer totalCount) {
        this.statusType = StatusResponse.Type.SUCCESS;
        this.statusCode = statusCode.getCode();
        this.statusMessage = statusCode.getMessage();
        this.statusType = statusType;
        if (statusCode instanceof SuccessCodes) {
            this.statusType = StatusResponse.Type.SUCCESS;
        } else {
            this.statusType = StatusResponse.Type.ERROR;
        }

        this.totalCount = totalCount;
    }

    public StatusResponse(StatusCode statusCode, Integer totalCount) {
        this.statusType = StatusResponse.Type.SUCCESS;
        this.statusCode = statusCode.getCode();
        this.statusMessage = statusCode.getMessage();
        if (statusCode instanceof SuccessCodes) {
            this.statusType = StatusResponse.Type.SUCCESS;
        } else {
            this.statusType = StatusResponse.Type.ERROR;
        }

        this.totalCount = totalCount;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public StatusResponse.Type getStatusType() {
        return this.statusType;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setStatusType(StatusResponse.Type statusType) {
        this.statusType = statusType;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }


    public String toString() {
        return "StatusResponse(statusCode=" + this.getStatusCode() + ", statusMessage=" + this.getStatusMessage() + ", statusType=" + this.getStatusType() + ", totalCount=" + this.getTotalCount() + ")";
    }

    public StatusResponse(Integer statusCode, String statusMessage, StatusResponse.Type statusType, Integer totalCount) {
        this.statusType = StatusResponse.Type.SUCCESS;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.statusType = statusType;
        this.totalCount = totalCount;
    }

    public StatusResponse() {
        this.statusType = StatusResponse.Type.SUCCESS;
    }

    public static enum Type {
        ERROR,
        SUCCESS,
        WARNING;

        private Type() {
        }
    }
}
