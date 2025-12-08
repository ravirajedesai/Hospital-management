package com.revision.startspringboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;


@Entity
public class UserEntity {
    @Id
    private long rollno;
    private String name;

    public long getRollno() {
        return rollno;
    }

    public void setRollno(long rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }
}
