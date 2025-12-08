package com.microservices.demoContact.Controller;

import com.microservices.demoContact.Entity.Contact;
import com.microservices.demoContact.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/{userId}")
    public List<Contact>getContact(@PathVariable("userId") Long userId){
        return this.contactService.getContact(userId);
    }
}
