package me.jeong.SpringbootDeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class CreateAccessTokenResponse {
    private String accessToken;
}
