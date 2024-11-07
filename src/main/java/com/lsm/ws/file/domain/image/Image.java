package com.lsm.ws.file.domain.image;

public class Image {

    private final String id;
    private final byte[] content;
    private final String extension;

    public Image(String id, byte[] content, String extension) {
        this.id = id;
        this.content = content;
        this.extension = extension;
    }

    public String id() {
        return id;
    }

    public byte[] content() {
        return content;
    }

    public String extension() {
        return extension;
    }
}
