package com.revision.startspringboot.Controller;

import com.revision.startspringboot.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends JpaRepository<UserEntity, Long> {

}
