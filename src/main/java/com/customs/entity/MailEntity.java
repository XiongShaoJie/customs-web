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
    private File[] AttachmentArray;

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

    public File[] getAttachmentArray() {
	return AttachmentArray;
    }

    public void setAttachmentArray(File[] attachmentArray) {
	AttachmentArray = attachmentArray;
    }
}
