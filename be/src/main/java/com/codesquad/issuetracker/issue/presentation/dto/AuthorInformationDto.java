package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AuthorInformationDto {

    private long userId;
    private String profileImage;
    private String name;

    public AuthorInformationDto(long userId, String profileImage, String name) {
        this.userId = userId;
        this.profileImage = profileImage;
        this.name = name;
    }

    public static AuthorInformationDto from(User user) {
        return new AuthorInformationDto(user.getId(), user.getProfileImage(), user.getName());
    }
}
