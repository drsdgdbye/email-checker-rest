package com.example.restemailchecker.controllers;

import com.example.restemailchecker.entities.Email;
import com.example.restemailchecker.services.EmailServiceImpl;
import com.example.restemailchecker.utils.ResponseSender;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
class EmailController {
    @Setter(onMethod_ = {@Autowired})
    private EmailServiceImpl emailService;

    @PostMapping("/new")
    public ResponseEntity<ResponseSender> newEmail(@RequestBody Email newEmail) {
        if (newEmail.getAddress() == null) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        boolean isDuplicate = emailService.isExist(newEmail.getAddress());
        if (isDuplicate) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseSender(true));
        } else {
            emailService.save(newEmail);
        }

        return ResponseEntity
                .ok()
                .build();
    }
}
