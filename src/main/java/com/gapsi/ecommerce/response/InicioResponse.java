package com.gapsi.ecommerce.response;

import java.util.Date;

public class InicioResponse {

    private Integer status;
    private String welcome;
    private String version;
    private Date timestamp;

    public InicioResponse() {}

    public InicioResponse(Integer status, String welcome, String version, Date timestamp) {
        this.status = status;
        this.welcome = welcome;
        this.version = version;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
