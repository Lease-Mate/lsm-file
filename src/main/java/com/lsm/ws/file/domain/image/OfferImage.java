package com.lsm.ws.file.domain.image;

public class OfferImage {

    private final String imageId;
    private final String offerId;
    private Integer order;

    public OfferImage(String imageId, String offerId, Integer order) {
        this.imageId = imageId;
        this.offerId = offerId;
        this.order = order;
    }

    public String imageId() {
        return imageId;
    }

    public String offerId() {
        return offerId;
    }

    public Integer order() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
