package com.luzj.dblsource.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luzj
 * @description:
 * @date 2018/8/27
 */
@Entity
@Table(name = "redAppImage")
public class RedAppImage {
    @Id
    private String imagePathId;
    private String imageId;
    private String imagePath;
    private String imageName;

    public RedAppImage() {
    }

    public RedAppImage(String imagePathId, String imageId, String imagePath, String imageName) {
        this.imagePathId = imagePathId;
        this.imageId = imageId;
        this.imagePath = imagePath;
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "RedAppImage{" +
                "imagePathId='" + imagePathId + '\'' +
                ", imageId='" + imageId + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }

    public String getImagePathId() {
        return imagePathId;
    }

    public void setImagePathId(String imagePathId) {
        this.imagePathId = imagePathId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
