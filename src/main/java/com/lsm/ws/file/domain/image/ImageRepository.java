package com.lsm.ws.file.domain.image;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {

    OfferImage save(OfferImage offerImage, Image image);

    Optional<Image> getById(String imageId);

    List<OfferImage> getByOfferId(String offerId);

    void delete(OfferImage image);
}
