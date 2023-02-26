package com.bamshadit.tomcatchatandinteractapp.repository;

import com.bamshadit.tomcatchatandinteractapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query ("SELECT user from User user WHERE user.username =: username")
    User findUser(@Param("username") String username);

}


 */