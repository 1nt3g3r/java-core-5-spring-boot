package com.goit5.testapp.feature.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private UserDTO user;
    private List<String> addresses;
}
