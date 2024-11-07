package com.lsm.ws.file.infrastructure.persistance.facade;

import com.lsm.ws.file.domain.image.Image;
import com.lsm.ws.file.domain.image.ImageRepository;
import com.lsm.ws.file.domain.image.OfferImage;
import com.lsm.ws.file.infrastructure.persistance.jpa.ImageJpaRepository;
import com.lsm.ws.file.infrastructure.persistance.jpa.OfferImageJpaRepository;
import com.lsm.ws.file.infrastructure.persistance.model.ImageEntity;
import com.lsm.ws.file.infrastructure.persistance.model.OfferImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OfferImageFacadeRepository implements ImageRepository {

    private final OfferImageJpaRepository offerImageJpaRepository;
    private final ImageJpaRepository imageJpaRepository;

    public OfferImageFacadeRepository(OfferImageJpaRepository offerImageJpaRepository, ImageJpaRepository imageJpaRepository) {
        this.offerImageJpaRepository = offerImageJpaRepository;
        this.imageJpaRepository = imageJpaRepository;
    }

    @Override
    @Transactional
    public OfferImage save(OfferImage offerImage, Image image) {
        var imageEntity = new ImageEntity();
        imageEntity.from(image);
        imageJpaRepository.save(imageEntity);

        var offerImageEntity = new OfferImageEntity();
        offerImageEntity.from(offerImage);
        return offerImageJpaRepository.save(offerImageEntity)
                                      .toOfferImage();
    }

    @Override
    @Transactional
    public Optional<Image> getById(String imageId) {
        return imageJpaRepository.findById(imageId)
                                 .map(ImageEntity::toImage);
    }

    @Override
    public List<OfferImage> getByOfferId(String offerId) {
        return offerImageJpaRepository.findByOfferId(offerId)
                                      .stream().map(OfferImageEntity::toOfferImage)
                                      .toList();
    }
}
