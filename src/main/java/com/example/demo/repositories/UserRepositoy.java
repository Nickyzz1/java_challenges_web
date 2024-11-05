package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserModel;

@Repository
public interface UserRepositoy extends JpaRepository<UserModel, Long> {

    List<UserModel> findByUserNameCol(String name);
    List<UserModel> findByEmailCol(String email);

    @Modifying // Indica que é uma operação de modificação
    @Query("UPDATE UserModel u SET u.passWordCol = ?1 WHERE u.userNameCol = ?2")
    void updatePassWordCol(String newPass, String userName);


}
