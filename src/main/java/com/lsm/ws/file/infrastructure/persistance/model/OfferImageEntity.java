package com.lsm.ws.file.infrastructure.persistance.model;

import com.lsm.ws.file.domain.image.OfferImage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "offer_image")
public class OfferImageEntity {

    @Id
    @Column(name = "image_id")
    private String imageId;

    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "order_no")
    private Integer order;

    public OfferImage toOfferImage() {
        try {
            return new OfferImage(
                    imageId,
                    offerId,
                    order
            );
        } catch (Exception e) {
            throw new RuntimeException("Error while accessing image", e);
        }
    }

    public void from(OfferImage offerImage) {
        setImageId(offerImage.imageId());
        setOfferId(offerImage.offerId());
        setOrder(offerImage.order());
    }

    public void setImageId(String id) {
        this.imageId = id;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
