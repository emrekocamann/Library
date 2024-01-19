package com.emre.project.library.service;

import com.emre.project.library.repo.user.Customer;

public class MailServiceImpl implements MailService {
    @Override
    public void sendUserUpdatedMail(Customer customer) {
        System.out.printf("Hello %s, your user information is updated. %n", customer.getFirstname()+" "+ customer.getLastname());
    }

    @Override
    public void sendUserCreatedMail(Customer customer) {
        System.out.printf("Welcome %s", customer.getFirstname()+" "+ customer.getLastname());
    }
}
