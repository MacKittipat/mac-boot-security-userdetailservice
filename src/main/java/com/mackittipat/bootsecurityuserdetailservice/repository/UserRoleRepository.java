package com.mackittipat.bootsecurityuserdetailservice.repository;

import com.mackittipat.bootsecurityuserdetailservice.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    UserRole findByUserId(Long userId);

}
