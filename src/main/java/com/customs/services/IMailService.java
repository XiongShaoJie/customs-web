package com.customs.services;

import java.io.File;

import com.customs.entity.MailEntity;
import com.customs.entity.MailPicEntity;

public interface IMailService {

    /** 发送邮件：文本，附件，HTML */
     boolean sendMail(MailEntity mail) throws Exception;

    /** 发送图片邮件 */
    public boolean sendPic(MailPicEntity picEntity) throws Exception;
}
