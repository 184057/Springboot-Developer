package me.jeong.SpringbootDeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jeong.SpringbootDeveloper.dto.AddUserRequest;
import me.jeong.SpringbootDeveloper.domain.User;
import me.jeong.SpringbootDeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                // 패스워드 암호화
                // 패스워드를 저장할 때 시큐리티를 설정하며, 패스워드 인코딩용으로 등록한 빈을 사용해서 암호화한 후 저장
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
