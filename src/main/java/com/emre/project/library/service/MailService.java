package com.emre.project.library.service;

import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.repo.user.SystemUser;

public interface MailService {
    void sendUserUpdatedMail(SystemUser user);
    void sendUserCreatedMail(SystemUser user);
}
