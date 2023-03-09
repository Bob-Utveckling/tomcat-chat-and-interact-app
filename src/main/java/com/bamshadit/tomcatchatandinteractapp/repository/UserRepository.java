package com.bamshadit.tomcatchatandinteractapp.repository;

import com.bamshadit.tomcatchatandinteractapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
//public interface UserRepository extends JpaRepository<User, Integer> {

    @Query (value="SELECT user from User user WHERE user.username =:username")
    User findUser(@Param("username") String username);

}


