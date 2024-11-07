package com.lsm.ws.file.infrastructure.persistance.model;

import com.lsm.ws.file.domain.image.Image;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import org.hibernate.engine.jdbc.BlobProxy;

import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Lob
    @Column(name = "content")
    private Blob content;

    @Column(name = "extension")
    private String extension;

    public Image toImage() {
        try {
            return new Image(id, content.getBytes(1, (int) content.length()), extension);
        } catch (SQLException e) {
            throw new RuntimeException("Error while accessing image", e);
        }
    }

    public void from(Image image) {
        setId(image.id());
        setContent(image.content());
        setExtension(image.extension());
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(byte[] content) {
        this.content = BlobProxy.generateProxy(content);
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
