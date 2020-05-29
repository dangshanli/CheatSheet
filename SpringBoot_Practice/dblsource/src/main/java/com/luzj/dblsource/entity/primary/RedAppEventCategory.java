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
@Table(name = "redAppEventCategory")
public class RedAppEventCategory {
    @Id
    private String detailCategoryId;
    private String detailCategoryName;
    private String categoryId;
    private String categoryName;
    private String bigCategoryId;
    private String bigCategoryName;
    private String smallCategoryId;
    private String smallCategoryName;

    public RedAppEventCategory() {
    }

    public RedAppEventCategory(String detailCategoryId, String detailCategoryName, String categoryId, String categoryName, String bigCategoryId, String bigCategoryName, String smallCategoryId, String smallCategoryName) {
        this.detailCategoryId = detailCategoryId;
        this.detailCategoryName = detailCategoryName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.bigCategoryId = bigCategoryId;
        this.bigCategoryName = bigCategoryName;
        this.smallCategoryId = smallCategoryId;
        this.smallCategoryName = smallCategoryName;
    }

    @Override
    public String toString() {
        return "RedAppEventCategory{" +
                "detailCategoryId='" + detailCategoryId + '\'' +
                ", detailCategoryName='" + detailCategoryName + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", bigCategoryId='" + bigCategoryId + '\'' +
                ", bigCategoryName='" + bigCategoryName + '\'' +
                ", smallCategoryId='" + smallCategoryId + '\'' +
                ", smallCategoryName='" + smallCategoryName + '\'' +
                '}';
    }

    public String getDetailCategoryId() {
        return detailCategoryId;
    }

    public void setDetailCategoryId(String detailCategoryId) {
        this.detailCategoryId = detailCategoryId;
    }

    public String getDetailCategoryName() {
        return detailCategoryName;
    }

    public void setDetailCategoryName(String detailCategoryName) {
        this.detailCategoryName = detailCategoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(String bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public String getBigCategoryName() {
        return bigCategoryName;
    }

    public void setBigCategoryName(String bigCategoryName) {
        this.bigCategoryName = bigCategoryName;
    }

    public String getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(String smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public String getSmallCategoryName() {
        return smallCategoryName;
    }

    public void setSmallCategoryName(String smallCategoryName) {
        this.smallCategoryName = smallCategoryName;
    }
}
