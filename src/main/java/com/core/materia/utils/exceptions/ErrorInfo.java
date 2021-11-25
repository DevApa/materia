package com.core.materia.utils.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
	@JsonProperty("mensaje")
    private String message;
    @JsonProperty("código")
    private Integer statusCode;
    @JsonProperty("uri_consultada")
    private String uriRequest;

    public ErrorInfo() {
    }
    public ErrorInfo(String message, Integer statusCode, String uriRequest) {
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequest = uriRequest;
    }
    public String getMessage() {
        return message;
    }
    public Integer getStatusCode() {
        return statusCode;
    }
    
    public String getUriRequest() {
        return uriRequest;
    } 
}
