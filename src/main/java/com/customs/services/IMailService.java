package com.customs.services;

import com.customs.entity.MailEntity;

public interface IMailService {
    public boolean sendPlainText(MailEntity mail) throws Exception;
}
