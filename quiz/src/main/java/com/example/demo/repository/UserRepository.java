package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.name = :name")
    public User findByUserName(@Param("name") String name);

    @Query("select name from User u where u.name=:name")
    public String findName(String name);

}
