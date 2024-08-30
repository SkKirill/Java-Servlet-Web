package com.flower.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Profile {
    private Long id;
    private final String fio;
    private final String login;
    private final String password;

}
