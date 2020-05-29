package com.luzj.dblsource.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luzj
 * @description:
 * @date 2018/8/21
 */
@Entity
@Table(name = "redAppProcessExample")
public class RedAppProcessExample {
    @Id
    private String exampleId;
    private String exampleName;
    private String userId;
    private String createTime;
    private String eventId;
    private String eventTxt;
    private String eventPicturePath;
    private String pictureName;
    private String address;
    private String lng;
    private String lat;
    private String typeId;
    private String status;
    private String isChuiShao;
    private String levelId;
    private String categoryId;
    private String bigCategoryId;
    private String smallCategoryId;
    private String detailCategoryId;
    private String jrjId;
    private String grid;
    private String communityId;
    private String bigPeoCateId;
    private String smallPeoCateId;
    private String imageId;

    public RedAppProcessExample() {
    }

    public RedAppProcessExample(String exampleId, String exampleName, String userId, String createTime, String eventId, String eventTxt, String eventPicturePath, String pictureName, String address, String lng, String lat, String typeId, String status, String isChuiShao, String levelId, String categoryId, String bigCategoryId, String smallCategoryId, String detailCategoryId, String jrjId, String grid, String communityId, String bigPeoCateId, String smallPeoCateId, String imageId) {
        this.exampleId = exampleId;
        this.exampleName = exampleName;
        this.userId = userId;
        this.createTime = createTime;
        this.eventId = eventId;
        this.eventTxt = eventTxt;
        this.eventPicturePath = eventPicturePath;
        this.pictureName = pictureName;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
        this.typeId = typeId;
        this.status = status;
        this.isChuiShao = isChuiShao;
        this.levelId = levelId;
        this.categoryId = categoryId;
        this.bigCategoryId = bigCategoryId;
        this.smallCategoryId = smallCategoryId;
        this.detailCategoryId = detailCategoryId;
        this.jrjId = jrjId;
        this.grid = grid;
        this.communityId = communityId;
        this.bigPeoCateId = bigPeoCateId;
        this.smallPeoCateId = smallPeoCateId;
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "RedAppProcessExample{" +
                "exampleId='" + exampleId + '\'' +
                ", exampleName='" + exampleName + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", eventId='" + eventId + '\'' +
                ", eventTxt='" + eventTxt + '\'' +
                ", eventPicturePath='" + eventPicturePath + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", address='" + address + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", typeId='" + typeId + '\'' +
                ", status='" + status + '\'' +
                ", isChuiShao='" + isChuiShao + '\'' +
                ", levelId='" + levelId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", bigCategoryId='" + bigCategoryId + '\'' +
                ", smallCategoryId='" + smallCategoryId + '\'' +
                ", detailCategoryId='" + detailCategoryId + '\'' +
                ", jrjId='" + jrjId + '\'' +
                ", grid='" + grid + '\'' +
                ", communityId='" + communityId + '\'' +
                ", bigPeoCateId='" + bigPeoCateId + '\'' +
                ", smallPeoCateId='" + smallPeoCateId + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }

    public String getExampleId() {
        return exampleId;
    }

    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleName() {
        return exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTxt() {
        return eventTxt;
    }

    public void setEventTxt(String eventTxt) {
        this.eventTxt = eventTxt;
    }

    public String getEventPicturePath() {
        return eventPicturePath;
    }

    public void setEventPicturePath(String eventPicturePath) {
        this.eventPicturePath = eventPicturePath;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsChuiShao() {
        return isChuiShao;
    }

    public void setIsChuiShao(String isChuiShao) {
        this.isChuiShao = isChuiShao;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(String bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public String getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(String smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public String getDetailCategoryId() {
        return detailCategoryId;
    }

    public void setDetailCategoryId(String detailCategoryId) {
        this.detailCategoryId = detailCategoryId;
    }

    public String getJrjId() {
        return jrjId;
    }

    public void setJrjId(String jrjId) {
        this.jrjId = jrjId;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getBigPeoCateId() {
        return bigPeoCateId;
    }

    public void setBigPeoCateId(String bigPeoCateId) {
        this.bigPeoCateId = bigPeoCateId;
    }

    public String getSmallPeoCateId() {
        return smallPeoCateId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public void setSmallPeoCateId(String smallPeoCateId) {

        this.smallPeoCateId = smallPeoCateId;
    }
}
