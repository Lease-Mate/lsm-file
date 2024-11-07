package com.lsm.ws.file.context.image.dto;

import com.lsm.ws.file.domain.image.OfferImage;

public class ImageIdDto {

    public String id;
    public int order;

    public static ImageIdDto from(OfferImage offerImage) {
        var dto = new ImageIdDto();
        dto.id = offerImage.imageId();
        dto.order = offerImage.order();

        return dto;
    }
}
