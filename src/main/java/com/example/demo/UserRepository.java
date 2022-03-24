package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsById(Long id);

    boolean existsByUserId(Long userId);

    @Query(value = "select u from User u where function('bitWiseAnd', u.userId, :value) <> 0")
    List<User> getUsers(@Param("value") Long value);

}
