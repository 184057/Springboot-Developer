package me.jeong.SpringbootDeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jeong.SpringbootDeveloper.domain.RefreshToken;
import me.jeong.SpringbootDeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
