package com.luzj.dblsource.entity.secondary;

import javax.persistence.*;
import java.util.Date;

/**
 * @author luzj
 * @description:
 * @date 2018/8/21
 */
@Entity
@Table(name = "RegisterAffairInfo")
public class RegisterAffairInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String sourceCode;
    private String description;
    private String address;
    private String originId;
    private Float coordX;
    private Float CoordY;
    private String typeFirstId;
    private String typeFirstName;
    private String typeSecondId;
    private String typeSecondName;
    private String levelName;
    private String levelId;
    private String streetId;
    private String streetName;
    private String communityId;
    private String communityName;
    private String smallDutyAreaId;
    private String smallDutyAreaName;
    private String submitterName;
    private String submitterPhone;
    private Date occurTime;
    private String reporterName;
    private String reporterPhone;
    private String attachmentName1;
    private byte[] attachment1;
    private String attachmentName2;
    private byte[] attachment2;
    private String attachmentName3;
    private byte[] attachment3;

    private String TypeThreeId;
    private String TypeThreeName;
    private String TypeFourId;
    private String TypeFourName;

    public RegisterAffairInfo() {
    }

    public RegisterAffairInfo(String sourceCode, String description, String address, String originId, Float coordX, Float coordY, String typeFirstId, String typeFirstName, String typeSecondId, String typeSecondName, String levelName, String levelId, String streetId, String streetName, String communityId, String communityName, String smallDutyAreaId, String smallDutyAreaName, String submitterName, String submitterPhone, Date occurTime, String reporterName, String reporterPhone, String attachmentName1, byte[] attachment1, String attachmentName2, byte[] attachment2, String attachmentName3, byte[] attachment3, String typeThreeId, String typeThreeName, String typeFourId, String typeFourName) {
        this.sourceCode = sourceCode;
        this.description = description;
        this.address = address;
        this.originId = originId;
        this.coordX = coordX;
        CoordY = coordY;
        this.typeFirstId = typeFirstId;
        this.typeFirstName = typeFirstName;
        this.typeSecondId = typeSecondId;
        this.typeSecondName = typeSecondName;
        this.levelName = levelName;
        this.levelId = levelId;
        this.streetId = streetId;
        this.streetName = streetName;
        this.communityId = communityId;
        this.communityName = communityName;
        this.smallDutyAreaId = smallDutyAreaId;
        this.smallDutyAreaName = smallDutyAreaName;
        this.submitterName = submitterName;
        this.submitterPhone = submitterPhone;
        this.occurTime = occurTime;
        this.reporterName = reporterName;
        this.reporterPhone = reporterPhone;
        this.attachmentName1 = attachmentName1;
        this.attachment1 = attachment1;
        this.attachmentName2 = attachmentName2;
        this.attachment2 = attachment2;
        this.attachmentName3 = attachmentName3;
        this.attachment3 = attachment3;
        TypeThreeId = typeThreeId;
        TypeThreeName = typeThreeName;
        TypeFourId = typeFourId;
        TypeFourName = typeFourName;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTypeThreeId() {
        return TypeThreeId;
    }

    public void setTypeThreeId(String typeThreeId) {
        TypeThreeId = typeThreeId;
    }

    public String getTypeThreeName() {
        return TypeThreeName;
    }

    public void setTypeThreeName(String typeThreeName) {
        TypeThreeName = typeThreeName;
    }

    public String getTypeFourId() {
        return TypeFourId;
    }

    public void setTypeFourId(String typeFourId) {
        TypeFourId = typeFourId;
    }

    public String getTypeFourName() {
        return TypeFourName;
    }

    public void setTypeFourName(String typeFourName) {
        TypeFourName = typeFourName;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public Float getCoordX() {
        return coordX;
    }

    public void setCoordX(Float coordX) {
        this.coordX = coordX;
    }

    public Float getCoordY() {
        return CoordY;
    }

    public void setCoordY(Float coordY) {
        CoordY = coordY;
    }

    public String getTypeFirstId() {
        return typeFirstId;
    }

    public void setTypeFirstId(String typeFirstId) {
        this.typeFirstId = typeFirstId;
    }

    public String getTypeFirstName() {
        return typeFirstName;
    }

    public void setTypeFirstName(String typeFirstName) {
        this.typeFirstName = typeFirstName;
    }

    public String getTypeSecondId() {
        return typeSecondId;
    }

    public void setTypeSecondId(String typeSecondId) {
        this.typeSecondId = typeSecondId;
    }

    public String getTypeSecondName() {
        return typeSecondName;
    }

    public void setTypeSecondName(String typeSecondName) {
        this.typeSecondName = typeSecondName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getSmallDutyAreaId() {
        return smallDutyAreaId;
    }

    public void setSmallDutyAreaId(String smallDutyAreaId) {
        this.smallDutyAreaId = smallDutyAreaId;
    }

    public String getSmallDutyAreaName() {
        return smallDutyAreaName;
    }

    public void setSmallDutyAreaName(String smallDutyAreaName) {
        this.smallDutyAreaName = smallDutyAreaName;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getSubmitterPhone() {
        return submitterPhone;
    }

    public void setSubmitterPhone(String submitterPhone) {
        this.submitterPhone = submitterPhone;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getReporterPhone() {
        return reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public String getAttachmentName1() {
        return attachmentName1;
    }

    public void setAttachmentName1(String attachmentName1) {
        this.attachmentName1 = attachmentName1;
    }

    public byte[] getAttachment1() {
        return attachment1;
    }

    public void setAttachment1(byte[] attachment1) {
        this.attachment1 = attachment1;
    }

    public String getAttachmentName2() {
        return attachmentName2;
    }

    public void setAttachmentName2(String attachmentName2) {
        this.attachmentName2 = attachmentName2;
    }

    public byte[] getAttachment2() {
        return attachment2;
    }

    public void setAttachment2(byte[] attachment2) {
        this.attachment2 = attachment2;
    }

    public String getAttachmentName3() {
        return attachmentName3;
    }

    public void setAttachmentName3(String attachmentName3) {
        this.attachmentName3 = attachmentName3;
    }

    public byte[] getAttachment3() {
        return attachment3;
    }

    public void setAttachment3(byte[] attachment3) {
        this.attachment3 = attachment3;
    }
}
