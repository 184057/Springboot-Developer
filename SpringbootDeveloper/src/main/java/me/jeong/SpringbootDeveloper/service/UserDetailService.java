package me.jeong.SpringbootDeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jeong.SpringbootDeveloper.domain.User;
import me.jeong.SpringbootDeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}
