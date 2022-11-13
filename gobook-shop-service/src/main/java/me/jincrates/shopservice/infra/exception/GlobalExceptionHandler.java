package me.jincrates.shopservice.infra.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public ErrorResponse handleServerException(ServerException ex) {
        //에러 로깅
        log.error(ex.getMessage());

        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        log.error(ex.getMessage());

        //보안취약점: 서버오류가 클라이언트에게 노출이 되면 되지 않기 때문에 log로만 디버깅을 통해서 확인하도록
        return new ErrorResponse(500, "Internal Server Error");
    }
}
