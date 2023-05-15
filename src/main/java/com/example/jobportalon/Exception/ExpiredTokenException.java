package com.example.jobportalon.Exception;

public class ExpiredTokenException extends RuntimeException{

    public ExpiredTokenException() {
        super();

    }

    public ExpiredTokenException(String message) {
        super(message);
    }
}


