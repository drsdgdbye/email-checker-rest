package com.example.restemailchecker.services;

import com.example.restemailchecker.entities.Email;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void save(Email email);

    boolean isExist(String address);
}
