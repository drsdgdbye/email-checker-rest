package com.example.restemailchecker.services;

import com.example.restemailchecker.entities.Email;
import com.example.restemailchecker.repositories.EmailRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    @Setter(onMethod_ = {@Autowired})
    private EmailRepository emailRepository;

    public void save(Email email) {
        emailRepository.save(email);
    }

    public boolean isExist(String address) {
        return emailRepository.findByAddress(address) != null;
    }
}
