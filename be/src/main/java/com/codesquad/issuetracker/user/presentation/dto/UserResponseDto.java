package com.codesquad.issuetracker.user.presentation.dto;

import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private long id;
    private String username;
    private String name;
    private String profileImage;

    public UserResponseDto(long id, String username, String name, String profileImage) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.profileImage = profileImage;
    }

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getName(), user.getProfileImage());
    }
}
