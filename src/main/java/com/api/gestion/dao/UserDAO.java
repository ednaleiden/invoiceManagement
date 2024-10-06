package com.api.gestion.dao;

import com.api.gestion.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
//consultas personalizadas

    @Query
    User findByEmail(@Param(("email"))String email);

}
