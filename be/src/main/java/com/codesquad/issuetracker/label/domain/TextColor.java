package com.codesquad.issuetracker.label.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TextColor {

    DARK, LIGHT;

    @JsonCreator
    public static TextColor from(String name) {
        return TextColor.valueOf(name);
    }
}
