package me.jincrates.shopservice.exception;

public class ServerException extends RuntimeException {
    private Integer code;
    private String message;
}