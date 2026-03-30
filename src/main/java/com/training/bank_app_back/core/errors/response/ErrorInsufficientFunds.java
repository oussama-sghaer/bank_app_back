package com.training.bank_app_back.core.errors.response;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;

public class ErrorInsufficientFunds extends BaseErrorResponse {
    public ErrorInsufficientFunds(String message, HttpStatusCode status, ErrorResponseCode code, String traceId) {
        super(message, HttpStatusCode.valueOf(400), ErrorResponseCode.INSUFFICIENT_FUNDS, traceId);
    }
}
