package com.customs.services.impl;

import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.customs.entity.MailEntity;
import com.customs.services.IMailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {
    @Autowired
    private IMailService mailService;
    @Autowired
    private Environment env;

    @Test
    public void sendMail() throws Exception {
	MailEntity mail = new MailEntity();
	mail.setSender(env.getProperty("spring.mail.username"));
	mail.setContent("这是测试发多个附件");
	mail.setReceiver(new String[] { "2318965095@qq.com" });
	mail.setTheme("祝福");
	File[] attachmentArray = new File[] { new File("d:/test.xls"), new File("d:/test.doc") };
	mail.setAttachmentArray(attachmentArray);
	mailService.sendMail(mail);
    }

}
