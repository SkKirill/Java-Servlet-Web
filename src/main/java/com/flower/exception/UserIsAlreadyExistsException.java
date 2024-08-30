package com.flower.exception;

public class UserIsAlreadyExistsException extends Exception{
    public UserIsAlreadyExistsException(String e){
        super(e);
    }
}
