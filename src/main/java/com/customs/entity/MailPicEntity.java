package com.customs.entity;

import java.io.File;

public class MailPicEntity {
    private String theme;
    private String sender;
    private String[] receiver;
    private File[] picArray;
    private String additionalContent;

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

    public File[] getPicArray() {
	return picArray;
    }

    public void setPicArray(File[] picArray) {
	this.picArray = picArray;
    }

    public String getAdditionalContent() {
	return additionalContent;
    }

    public void setAdditionalContent(String additionalContent) {
	this.additionalContent = additionalContent;
    }

    public String getTheme() {
	return theme;
    }

    public void setTheme(String theme) {
	this.theme = theme;
    }

}
