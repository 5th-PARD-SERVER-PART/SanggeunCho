package com.pard.seminar2.user.repository;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.entiry.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class UserRepository {
    private static final Map<Long, User> handong = new HashMap<>();
    // DB가 없어 로직을 처리하기 위해 Map 사용

    public void save(UserDto userDto) {
        User user = User.builder()
                .studentID(userDto.getStudentID())
                .studentName(userDto.getStudentName())
                .build();
            handong.put(userDto.getStudentID(), user);
    }

    public UserDto findByID(Long studentID){
        User user = handong.get(studentID);
        // 나중에 DB 쓰면 option 없으면 거부 처리

        return UserDto.builder()
                .studentID(user.getStudentID())
                .studentName(user.getStudentName())
                .build();
    }

    public void updateByID(Long studentID, UserDto userDto) {
        User user = handong.get(studentID);

        user.setStudentID(userDto.getStudentID());
        user.setStudentName(userDto.getStudentName());
    }

    public void delete(Long studentID) {
        handong.remove(studentID);
    }

    public List<UserDto> findAll() {
        return handong.values().stream() // 하나씩 흘려보내겠다
                .map(user -> UserDto.builder() // user를 dto로 바꾸겠다
                        .studentID(user.getStudentID())
                        .studentName(user.getStudentName())
                        .build()).toList();
    }
}
