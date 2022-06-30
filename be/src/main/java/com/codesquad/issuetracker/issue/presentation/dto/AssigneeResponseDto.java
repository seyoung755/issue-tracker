package com.codesquad.issuetracker.issue.presentation.dto;

import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssigneeResponseDto {

    private String name;
    private String profileImage;

    private AssigneeResponseDto(String name, String profileImage) {
        this.name = name;
        this.profileImage = profileImage;
    }

    public static AssigneeResponseDto from(User user) {
        return new AssigneeResponseDto(user.getName(), user.getProfileImage());
    }
}
