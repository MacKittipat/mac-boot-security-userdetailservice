package com.mackittipat.bootsecurityuserdetailservice.repository;

import com.mackittipat.bootsecurityuserdetailservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
