package com.revision.springFirstrevision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Program program;
    public void display(){
        program.show();
        System.out.println("in Display Method");
    }
}
