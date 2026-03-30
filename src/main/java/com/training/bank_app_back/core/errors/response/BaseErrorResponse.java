package com.training.bank_app_back.core.errors.response;

import org.springframework.http.HttpStatusCode;

public class BaseErrorResponse {
    public String message;
    public HttpStatusCode status;
    public ErrorResponseCode code;
    public String traceId;
    public BaseErrorResponse(String message, HttpStatusCode status, ErrorResponseCode code, String traceId){
        this.message = message;
        this.status = status;
        this.code = code;
        this.traceId = traceId;
    }
}
