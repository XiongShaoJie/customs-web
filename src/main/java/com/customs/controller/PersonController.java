package com.customs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.customs.entity.MailEntity;
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

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public Person getById(@PathVariable Long id) {
	Person person = personService.getById(id);
	return person;
    }

    @RequestMapping("/sendMail")
    @ResponseBody
    public void sendMail() {
	MailEntity mail = new MailEntity();
	mail.setSender(env.getProperty("spring.mail.username"));
	mail.setContent("这是一封邮件");
	mail.setReceiver("2318965095@qq.com");
	mail.setTheme("祝福");
	try {
	    mailService.sendPlainText(mail);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
