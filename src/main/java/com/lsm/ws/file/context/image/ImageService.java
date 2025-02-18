package com.lsm.ws.file.context.image;

import com.lsm.ws.file.configuration.exception.NoSuchImageException;
import com.lsm.ws.file.configuration.exception.UnsupportedImageFormatException;
import com.lsm.ws.file.domain.image.Image;
import com.lsm.ws.file.domain.image.ImageRepository;
import com.lsm.ws.file.domain.image.OfferImage;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private static final List<String> SUPPORTED_IMAGE_FORMATS = List.of("jpg", "jpeg");

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String addImage(String offerId, MultipartFile file) throws IOException {
        var fileFormat = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        if (!SUPPORTED_IMAGE_FORMATS.contains(fileFormat)) {
            throw new UnsupportedImageFormatException(String.join(", ", SUPPORTED_IMAGE_FORMATS));
        }

        var image = new Image(
                UUID.randomUUID().toString(),
                file.getBytes(),
                FilenameUtils.getExtension(file.getOriginalFilename())
        );

        var existingImages = getImagesForOffer(offerId);
        var offerImage = new OfferImage(
                image.id(),
                offerId,
                existingImages.size() + 1
        );
        return imageRepository.save(offerImage, image)
                              .imageId();
    }

    public Image getImage(String imageId) {
        return imageRepository.getById(imageId)
                              .orElseThrow(NoSuchImageException::new);
    }

    public List<OfferImage> getImagesForOffer(String offerId) {
        var images = new ArrayList<>(imageRepository.getByOfferId(offerId));

        images.sort(Comparator.comparing(OfferImage::order));
        return images;
    }

    public void delete(String offerId, String imageId) {
        var image = imageRepository.getByOfferId(offerId)
                                   .stream().filter(it -> it.imageId().equals(imageId))
                                   .findFirst()
                                   .orElseThrow(NoSuchImageException::new);

        imageRepository.delete(image);
    }
}
