package com.proba.artifact.exceptions.user;

import com.proba.artifact.exceptions.BaseException;

public class UserAlreadyExistException extends BaseException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
