package com.lsm.ws.file.infrastructure.persistance.jpa;

import com.lsm.ws.file.infrastructure.persistance.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageJpaRepository extends JpaRepository<ImageEntity, String> {
}
