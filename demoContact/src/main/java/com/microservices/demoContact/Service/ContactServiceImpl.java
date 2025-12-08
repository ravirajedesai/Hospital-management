package com.microservices.demoContact.Service;

import com.microservices.demoContact.Entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    //private Contact contact;
    List<Contact>list=List.of(
            new Contact(1,"sup","sup@gmail",12345),
            new Contact(2,"sonu","sonu@gmail",67890),
            new Contact(3,"niha","niha@gmail",45678)
    );
    @Override
    public List<Contact> getContact(Long userId) {
        return list.stream()
                .filter(contact ->contact.getUserId()
                        == userId)
                        .collect(Collectors.toList());
    }
}
