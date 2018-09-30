package com.customs.controller;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.customs.entity.MailEntity;
import com.customs.entity.MailPicEntity;
import com.customs.entity.Person;
import com.customs.services.IMailService;
import com.customs.services.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
//    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private IPersonService personService;
    @Autowired
    private IMailService mailService;
    @Autowired
    private Environment env;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public Person getById(@PathVariable Long id) {
	Person person = personService.getById(id);
	return person;
    }

    @RequestMapping("/index")
    public String toIndex() {
	return "/index";
    }

    @RequestMapping("/sendMail")
    @ResponseBody
    public void sendMail() {
	MailEntity mail = new MailEntity();
	mail.setSender(env.getProperty("spring.mail.username"));
	mail.setContent("这是测试发多个附件");
	mail.setReceiver(new String[] { "2318965095@qq.com" });
	mail.setTheme("祝福");
	File[] attachmentArray = new File[] { new File("d:/test.xls"), new File("d:/test.doc") };
	mail.setAttachmentArray(attachmentArray);
	try {
	    mailService.sendMail(mail);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @RequestMapping("/sendPic")
    @ResponseBody
    public void sendPic() {
	MailPicEntity picEntity = new MailPicEntity();
	picEntity.setSender(env.getProperty("spring.mail.username"));
	picEntity.setAdditionalContent("测试多个图片");
	picEntity.setTheme("多个图片");
	picEntity.setReceiver(new String[] { "2318965095@qq.com" });
	File[] picArray = new File[] { new File("d:/test1.jpg"), new File("d:/test2.jpg") };
	picEntity.setPicArray(picArray);
	try {
	    mailService.sendPic(picEntity);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
