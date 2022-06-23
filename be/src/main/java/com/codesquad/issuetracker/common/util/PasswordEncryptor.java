package com.codesquad.issuetracker.common.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptor {

    private PasswordEncryptor() {
    }

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
