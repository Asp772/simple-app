package com.example.simpleProj.model;

import javax.persistence.*;

/**
 * Created by Kamarou_S on 29.06.2018.
 */
@Entity
@Table(name = "image")
public class Image {
    private long idImage;
    private String imageUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idimage", nullable = false)
    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    @Basic
    @Column(name = "imageurl", nullable = false, length = 255)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (idImage != image.idImage) return false;
        if (imageUrl != null ? !imageUrl.equals(image.imageUrl) : image.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idImage ^ (idImage >>> 32));
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
