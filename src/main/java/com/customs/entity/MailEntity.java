package com.customs.entity;

import java.io.File;

/** 邮件实体类 */
public class MailEntity {
    // 发送人
    private String sender;
    // 收件人
    private String[] receiver;
    // 主题
    private String theme;
    // 文本内容
    private String content;
    // 附件
    private File Attachment;
    // 附件名称
    private String attachmentName;
    // 图片
    private File imgFile;
    // 图片id
    private String imgId;

    public String getSender() {
	return sender;
    }

    public void setSender(String sender) {
	this.sender = sender;
    }

    public String[] getReceiver() {
	return receiver;
    }

    public void setReceiver(String[] receiver) {
	this.receiver = receiver;
    }

    public String getTheme() {
	return theme;
    }

    public void setTheme(String theme) {
	this.theme = theme;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public File getAttachment() {
	return Attachment;
    }

    public void setAttachment(File attachment) {
	Attachment = attachment;
    }

    public String getAttachmentName() {
	return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
	this.attachmentName = attachmentName;
    }

    public File getImgFile() {
	return imgFile;
    }

    public void setImgFile(File imgFile) {
	this.imgFile = imgFile;
    }

    public String getImgId() {
	return imgId;
    }

    public void setImgId(String imgId) {
	this.imgId = imgId;
    }

}
