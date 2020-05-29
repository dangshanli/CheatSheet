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
@Table(name = "redAppUser")
public class RedAppUser {
    @Id
    private String userId;
    private String userLogName;
    private String userPasswd;
    private String userName;
    private String userSex;
    private String userTel;
    private String userEmail;
    private String uerJob;
    private String userAdress;
    private String userIntroduce;
    private String userPicturePath;
    private String assign;
    private String departmentId;
    private String communityId;

    public RedAppUser() {
    }

    public RedAppUser(String userId, String userLogName, String userPasswd, String userName, String userSex, String userTel, String userEmail, String uerJob, String userAdress, String userIntroduce, String userPicturePath, String assign, String departmentId, String communityId) {
        this.userId = userId;
        this.userLogName = userLogName;
        this.userPasswd = userPasswd;
        this.userName = userName;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.uerJob = uerJob;
        this.userAdress = userAdress;
        this.userIntroduce = userIntroduce;
        this.userPicturePath = userPicturePath;
        this.assign = assign;
        this.departmentId = departmentId;
        this.communityId = communityId;
    }

    @Override
    public String toString() {
        return "RedAppUser{" +
                "userId='" + userId + '\'' +
                ", userLogName='" + userLogName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", uerJob='" + uerJob + '\'' +
                ", userAdress='" + userAdress + '\'' +
                ", userIntroduce='" + userIntroduce + '\'' +
                ", userPicturePath='" + userPicturePath + '\'' +
                ", assign='" + assign + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", communtityId='" + communityId + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLogName() {
        return userLogName;
    }

    public void setUserLogName(String userLogName) {
        this.userLogName = userLogName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUerJob() {
        return uerJob;
    }

    public void setUerJob(String uerJob) {
        this.uerJob = uerJob;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public String getUserPicturePath() {
        return userPicturePath;
    }

    public void setUserPicturePath(String userPicturePath) {
        this.userPicturePath = userPicturePath;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
}
