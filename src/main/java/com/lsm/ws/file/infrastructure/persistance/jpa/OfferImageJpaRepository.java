package com.lsm.ws.file.infrastructure.persistance.jpa;

import com.lsm.ws.file.infrastructure.persistance.model.OfferImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferImageJpaRepository extends JpaRepository<OfferImageEntity, String> {

    List<OfferImageEntity> findByOfferId(String offerId);

    void deleteByImageId(String imageId);
}
