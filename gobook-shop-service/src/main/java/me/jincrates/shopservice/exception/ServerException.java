package me.jincrates.shopservice.exception;

public class ServerException extends RuntimeException {
    private Integer code;
    private String message;

    ServerException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

class NotFoundException extends ServerException {
    NotFoundException(String message) {
        super(404, message);
    }
}

class UnauthorizedException extends ServerException {
    private String message = "인증 정보가 잘못되었습니다.";
    UnauthorizedException(String message) {
        super(404, message);
    }
}

class OutOfStockException extends ServerException {
    OutOfStockException(String message) {
        super(400, message);
    }
}