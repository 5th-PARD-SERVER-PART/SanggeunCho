package com.pard.seminar4.user.repo;


import com.pard.seminar4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {


}
