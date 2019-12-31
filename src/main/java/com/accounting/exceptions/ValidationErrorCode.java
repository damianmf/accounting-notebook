package com.accounting.exceptions;

import org.springframework.http.HttpStatus;

public enum ValidationErrorCode {

    INVALID_DATA(4006, "Invalid data", HttpStatus.BAD_REQUEST),
    NOT_ENOUGH_MONY(4007, "Not enough money", HttpStatus.BAD_REQUEST),
    RESOURCE_NOT_FOUND(4008, "Resource Not Found", HttpStatus.BAD_REQUEST),
    GENERIC_ERROR(4009, "Generic error", HttpStatus.BAD_REQUEST);

    private Integer code;
    private String message;
    private HttpStatus httpStatus;

    ValidationErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static ValidationErrorCode get(int code) {
        for (ValidationErrorCode errorCode: ValidationErrorCode.values()) {
            if (errorCode.code == code) {
                return errorCode;
            }
        }
        return GENERIC_ERROR;
    }
}
