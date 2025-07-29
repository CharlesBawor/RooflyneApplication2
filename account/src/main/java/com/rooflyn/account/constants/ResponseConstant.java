package com.rooflyn.account.constants;

public class ResponseConstant {

    public enum ResponseStatus {

        // ✅ Success
        SUCCESS_200("200", "Request processed successfully"),
        CREATED_201("201", "Account created successfully"),
        ACCEPTED_202("202", "Request accepted but processing is pending"),
        NO_CONTENT_204("204", "Request processed successfully. No content to return"),

        // ❌ Client Errors
        BAD_REQUEST_400("400", "Bad request. Please check your input"),
        UNAUTHORIZED_401("401", "Unauthorized. Please login again"),
        FORBIDDEN_403("403", "Access denied. You don't have permission"),
        NOT_FOUND_404("404", "Resource not found"),
        CONFLICT_409("409", "Conflict. Resource already exists or duplicate data"),
        UNPROCESSABLE_ENTITY_422("422", "Validation failed. Invalid data input"),
        TOO_MANY_REQUESTS_429("429", "Too many requests. Please slow down"),

        // ⚠️ Server Errors
        INTERNAL_SERVER_ERROR_500("500", "An error occurred. Please try again or contact Dev team"),
        BAD_GATEWAY_502("502", "Bad gateway. Unable to reach upstream service"),
        SERVICE_UNAVAILABLE_503("503", "Service unavailable. Please try again later"),
        GATEWAY_TIMEOUT_504("504", "Gateway timeout. Server took too long to respond");

        private final String code;
        private final String message;

        ResponseStatus(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    private ResponseConstant() {
    }
}
