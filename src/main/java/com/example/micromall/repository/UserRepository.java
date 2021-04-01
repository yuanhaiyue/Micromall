package com.example.micromall.repository;

import com.example.micromall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 14760
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByNameAndPassword(String name,String password);

}
