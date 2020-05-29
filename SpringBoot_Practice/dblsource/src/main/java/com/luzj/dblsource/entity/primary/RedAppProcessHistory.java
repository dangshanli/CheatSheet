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
@Table(name = "redAppProcessHistory")
public class RedAppProcessHistory {
    @Id
    private String historyId;
    private String runId;
    private String exampleId;
    private String stepId;
    private String starTime;
    private String endTime;
    private String reviews;
    private String userId;
    private String pictureName;
    private String picturePath;
    private String imageId;

    @Override
    public String toString() {
        return "RedAppProcessHistory{" +
                "historyId='" + historyId + '\'' +
                ", runId='" + runId + '\'' +
                ", exampleId='" + exampleId + '\'' +
                ", stepId='" + stepId + '\'' +
                ", starTime='" + starTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", reviews='" + reviews + '\'' +
                ", userId='" + userId + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }

    public RedAppProcessHistory() {
    }

    public RedAppProcessHistory(String historyId, String runId, String exampleId, String stepId, String starTime, String endTime, String reviews, String userId, String pictureName, String picturePath, String imageId) {
        this.historyId = historyId;
        this.runId = runId;
        this.exampleId = exampleId;
        this.stepId = stepId;
        this.starTime = starTime;
        this.endTime = endTime;
        this.reviews = reviews;
        this.userId = userId;
        this.pictureName = pictureName;
        this.picturePath = picturePath;
        this.imageId = imageId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getExampleId() {
        return exampleId;
    }

    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}



