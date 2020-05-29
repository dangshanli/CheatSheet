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
@Table(name = "redAppProcessRunExample")
public class RedAppProcessRunExample {
    @Id
    private String runId;
    private String exampleId;
    private String stepId;
    private String userId;
    private String starTime;
    private String status;

    public RedAppProcessRunExample() {
    }

    public RedAppProcessRunExample(String runId, String exampleId, String stepId, String userId, String starTime, String status) {
        this.runId = runId;
        this.exampleId = exampleId;
        this.stepId = stepId;
        this.userId = userId;
        this.starTime = starTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RedAppProcessRunExample{" +
                "runId='" + runId + '\'' +
                ", exampleId='" + exampleId + '\'' +
                ", stepId='" + stepId + '\'' +
                ", userId='" + userId + '\'' +
                ", starTime='" + starTime + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
