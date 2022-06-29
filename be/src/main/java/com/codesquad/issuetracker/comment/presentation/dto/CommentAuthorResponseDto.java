package com.codesquad.issuetracker.comment.presentation.dto;

import com.codesquad.issuetracker.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentAuthorResponseDto {

    private long userId;
    private String profileImage;
    private String name;
    private boolean isIssueAuthor;

    public CommentAuthorResponseDto(long userId, String profileImage, String name, boolean isIssueAuthor) {
        this.userId = userId;
        this.profileImage = profileImage;
        this.name = name;
        this.isIssueAuthor = isIssueAuthor;
    }

    public static CommentAuthorResponseDto from(User user, boolean isIssueAuthor) {
        return new CommentAuthorResponseDto(user.getId(), user.getProfileImage(), user.getName(), isIssueAuthor);
    }
}
