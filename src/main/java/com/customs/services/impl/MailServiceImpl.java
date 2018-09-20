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
import com.customs.entity.MailPicEntity;
import com.customs.services.IMailService;

@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendMail(MailEntity mail) throws Exception {
	MimeMessage message = javaMailSender.createMimeMessage();
	boolean flag = false;
	try {
	    // true表示需要创建一个multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setFrom(mail.getSender());
	    helper.setTo(mail.getReceiver());
	    helper.setSubject(mail.getTheme());
	    helper.setText(mail.getContent(), true);
	    File[] attachmentArray = mail.getAttachmentArray();
	    // 附件
	    if (attachmentArray != null) {
		for (File attachmentFile : attachmentArray) {
		    FileSystemResource attachmentResource = new FileSystemResource(attachmentFile);
		    helper.addAttachment(attachmentFile.getName(), attachmentResource);
		}
	    }
	    javaMailSender.send(message);
	    flag = true;
	} catch (MessagingException e) {
	    e.printStackTrace();
	    throw new Exception("发送邮件出错");
	}
	return flag;
    }

    @Override
    public boolean sendPic(MailPicEntity picEntity) throws Exception {
	MimeMessage message = javaMailSender.createMimeMessage();
	boolean flag = false;
	try {
	    // true表示需要创建一个multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setFrom(picEntity.getSender());
	    helper.setTo(picEntity.getReceiver());
	    helper.setSubject(picEntity.getTheme());
	    StringBuffer content = new StringBuffer();
	    content.append("<html><body>").append(picEntity.getAdditionalContent());
	    File[] picArray = picEntity.getPicArray();
	    for (File pic : picArray) {
		String picName = pic.getName();
		content.append("</br><img src='cid:" + picName + "'/></br>");
	    }
	    content.append("</body></html>");
	    helper.setText(content.toString(), true);
	    // 这里不可与上面for循环合并，我也表示很奇怪
	    for (File pic : picArray) {
		String picName = pic.getName();
		FileSystemResource attachmentResource = new FileSystemResource(pic);
		helper.addInline(picName, attachmentResource);
	    }
	    javaMailSender.send(message);
	    flag = true;
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception("发送图片邮件出错");
	}
	return flag;
    }

}
