package com._minRestApi.RestApi.User;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<user>users=new ArrayList<>();
    static {
        users.add(new user(1,"Ravi",35));
        users.add(new user(2,"raj",36));
        users.add(new user(3,"sup",27));
        users.add(new user(4,"niha",5));
    }
    public List<user>findAll(){
        return users;
    }
    public user getUserById(int id){
        Predicate<? super user> predicate=user->user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
    public void save(user user){
        users.add(user);
    }
    public void deleteById(int id){
        Predicate<? super user> predicate=user -> user.getId().equals(id);
        users.remove(id);
    }

}
