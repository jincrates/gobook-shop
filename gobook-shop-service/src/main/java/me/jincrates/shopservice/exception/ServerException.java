package me.jincrates.shopservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.sql.rowset.serial.SerialException;


public class ServerException extends RuntimeException {


}
