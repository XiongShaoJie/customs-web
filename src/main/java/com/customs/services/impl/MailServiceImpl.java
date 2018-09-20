package com.customs.services.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.customs.entity.MailEntity;
import com.customs.services.IMailService;

@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendPlainText(MailEntity mail) throws Exception {
	MimeMessage message = javaMailSender.createMimeMessage();
	boolean flag = false;
	try {
	    // true表示需要创建一个multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setFrom(mail.getSender());
	    helper.setTo(mail.getReceiver());
	    helper.setSubject(mail.getTheme());
	    helper.setText(mail.getContent(), true);
	    File attachment = mail.getAttachment();
	    File imgFile = mail.getImgFile();
	    // 附件
	    if (attachment != null) {
		FileSystemResource attachmentResource = new FileSystemResource(attachment);
		helper.addAttachment(mail.getAttachmentName(), attachmentResource);
	    }
	    // 图片(正文有图片)
	    if (imgFile != null) {
		FileSystemResource imgResource = new FileSystemResource(imgFile);
		helper.addInline(mail.getImgId(), imgResource);
	    }
	    javaMailSender.send(message);
	    flag = true;
	} catch (MessagingException e) {
	    e.printStackTrace();
	    throw new Exception("发送邮件出错");
	}
	return flag;
    }
}
