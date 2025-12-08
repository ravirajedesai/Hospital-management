package com.microservices.demoContact.Service;

import com.microservices.demoContact.Entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact>getContact(Long userId);
}
