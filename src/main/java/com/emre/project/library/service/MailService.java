package com.emre.project.library.service;

import com.emre.project.library.repo.user.Customer;

public interface MailService {
    void sendUserUpdatedMail(Customer customer);
    void sendUserCreatedMail(Customer customer);
}
