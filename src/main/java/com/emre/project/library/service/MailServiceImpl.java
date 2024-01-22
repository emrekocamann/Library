package com.emre.project.library.service;

import com.emre.project.library.repo.user.SystemUser;

public class MailServiceImpl implements MailService {
    @Override
    public void sendUserUpdatedMail(SystemUser user) {
        System.out.printf("Hello %s, your user information is updated. %n", user.getUsername());
    }

    @Override
    public void sendUserCreatedMail(SystemUser user) {
        System.out.printf("Welcome %s", user.getUsername());
    }
}
