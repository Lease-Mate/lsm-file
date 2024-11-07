package com.lsm.ws.file.configuration.exception;

public class NoSuchImageException extends ValidationException {

    public NoSuchImageException() {
        super(ErrorCode.IMAGE_DOES_NOT_EXIST);
    }
}
