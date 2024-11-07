package com.lsm.ws.file.configuration.exception;

public enum ErrorCode {

    IMAGE_DOES_NOT_EXIST("001", "Obraz nie istnieje"),
    UNSUPPORTED_IMAGE_FORMAT("002", "Niedozwolony format obrazu, dozwolone formaty: {}");

    private static final String MICROSERVICE_PREFIX = "lsm-file-";
    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = MICROSERVICE_PREFIX + code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
