package com.lsm.ws.file.context.image.dto;

public class IdWrapperDto {

    public String id;

    public static IdWrapperDto fromId(String id) {
        var dto = new IdWrapperDto();
        dto.id = id;
        return dto;
    }
}
