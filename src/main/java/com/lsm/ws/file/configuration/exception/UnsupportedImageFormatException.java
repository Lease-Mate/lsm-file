package com.lsm.ws.file.configuration.exception;

public class UnsupportedImageFormatException extends ValidationException {

    public UnsupportedImageFormatException(String supportedFormats) {
        super(ErrorCode.UNSUPPORTED_IMAGE_FORMAT, supportedFormats);
    }
}
