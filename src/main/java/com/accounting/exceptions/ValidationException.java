package com.accounting.exceptions;

public class ValidationException extends Exception {

    private ValidationErrorCode validationErrorCode;

    public ValidationException(ValidationErrorCode validationErrorCode, String message) {
        super(message);
        this.validationErrorCode = validationErrorCode;
    }

    public ValidationException(ValidationErrorCode validationErrorCode, String message, Throwable cause) {
        super(message, cause);
        this.validationErrorCode = validationErrorCode;
    }

    public ValidationErrorCode getValidationErrorCode() {
        return validationErrorCode;

    }
}
