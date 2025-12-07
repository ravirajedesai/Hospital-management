package com.microservices.user.service.userservice.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_users")
public class User {
    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="Name",length = 15)
    private String name;
    @Column(name="Email")
    private String email;
    @Column(name="About")
    private String about;

    @Transient
    private List<Rating>ratings=new ArrayList<>();
}
