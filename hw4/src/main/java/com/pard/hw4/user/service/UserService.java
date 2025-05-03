package com.pard.hw4.user.service;

import com.pard.hw4.user.dto.UserReqDto;
import com.pard.hw4.user.dto.UserResDto;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepo userRepo;

    public UserResDto.ReadUser readUser(Long id){
        Optional<User> u = userRepo.findById(id);
        User user = u.get();
        UserResDto.ReadUser ret = UserResDto.ReadUser.from(user);
        return ret;
    }

    public void createUser(UserReqDto.UserCreateRequest req){
        User u = new User(null, req.getName(), new ArrayList<>(), null);
        userRepo.save(u);
    }

    public void deleteUser(Long userId){
        User user = userRepo.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepo.delete(user);
    }
}
