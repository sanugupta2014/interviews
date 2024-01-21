package org.phonepe.exceptions;

public class InvalidUserException extends Exception {

    public InvalidUserException(String errorMsg) {
        super(errorMsg);
    }
}
