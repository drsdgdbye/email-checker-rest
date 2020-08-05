package com.example.restemailchecker.repositories;

import com.example.restemailchecker.entities.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findByAddress(String address);
}
