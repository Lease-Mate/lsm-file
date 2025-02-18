package com.lsm.ws.file.context.image;

import com.lsm.ws.file.context.image.dto.IdWrapperDto;
import com.lsm.ws.file.context.image.dto.ImageIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(name = "Images services")
@RestController
@RequestMapping("/v1/api/file/image")
public class ImageEndpoint {

    private static final String GET_IMAGE = "Get image";
    private static final String GET_IMAGE_DESC = "returns specific offer image";
    private static final String GET_OFFER_IMAGES = "Get list of offer images";
    private static final String GET_OFFER_IMAGES_DESC = "returns list of offer images";
    private static final String ADD_IMAGE = "Add offer image";
    private static final String ADD_IMAGE_DESC = "adds image to specific offer";

    private final ImageService imageService;

    public ImageEndpoint(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(summary = GET_IMAGE, description = GET_IMAGE_DESC)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageId) {
        var image = imageService.getImage(imageId);
        return ResponseEntity.ok(image.content());
    }

    @GetMapping("/offer/{offerId}")
    @Operation(summary = GET_OFFER_IMAGES, description = GET_OFFER_IMAGES_DESC)
    public ResponseEntity<List<ImageIdDto>> getOfferImages(@PathVariable String offerId) {
        var images = imageService.getImagesForOffer(offerId)
                                 .stream().map(ImageIdDto::from)
                                 .toList();

        return ResponseEntity.ok(images);
    }

    @PostMapping(value = "/offer/{offerId}/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = ADD_IMAGE, description = ADD_IMAGE_DESC)
    public ResponseEntity<IdWrapperDto> addImage(@PathVariable String offerId,
                                                 @RequestPart("file") MultipartFile file) throws IOException {
        var id = imageService.addImage(offerId, file);
        return ResponseEntity.ok(IdWrapperDto.fromId(id));
    }

    @Operation(summary = "Usuń zdjęcie", description = "Usuwa zdjęcie")
    @DeleteMapping("/offer/{offerId}/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable String imageId, @PathVariable String offerId) {
        imageService.delete(offerId,imageId);
        return ResponseEntity.ok().build();
    }
}
