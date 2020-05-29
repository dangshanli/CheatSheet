package com.luzj.dblsource.entity.secondary;

import javax.persistence.*;
import java.util.Date;


/**
 * @author luzj
 * @description:
 * @date 2018/8/21
 */
@Entity
@Table(name = "EndAffairInfo")
public class EndAffairInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String sourceCode;
    private String attachmentName1;
    private byte[] attachment1;
    private String attachmentName2;
    private byte[] attachment2;
    private String attachmentName3;
    private byte[] attachment3;
    private Date overTime;
    private String operateName;
    private Date operateTime;
    private String operatetType;
    private String operateOpinion;

    public EndAffairInfo() {
    }

    public EndAffairInfo(String sourceCode, String attachmentName1, byte[] attachment1, String attachmentName2, byte[] attachment2, String attachmentName3, byte[] attachment3, Date overTime, String operateName, Date operateTime, String operatetType, String operateOpinion) {
        this.sourceCode = sourceCode;
        this.attachmentName1 = attachmentName1;
        this.attachment1 = attachment1;
        this.attachmentName2 = attachmentName2;
        this.attachment2 = attachment2;
        this.attachmentName3 = attachmentName3;
        this.attachment3 = attachment3;
        this.overTime = overTime;
        this.operateName = operateName;
        this.operateTime = operateTime;
        this.operatetType = operatetType;
        this.operateOpinion = operateOpinion;
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

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperatetType() {
        return operatetType;
    }

    public void setOperatetType(String operatetType) {
        this.operatetType = operatetType;
    }

    public String getOperateOpinion() {
        return operateOpinion;
    }

    public void setOperateOpinion(String operateOpinion) {
        this.operateOpinion = operateOpinion;
    }
}
