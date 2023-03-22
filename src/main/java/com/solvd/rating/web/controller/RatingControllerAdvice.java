package com.solvd.rating.web.controller;

import com.solvd.rating.web.dto.InternalError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RatingControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalError handleOtherExceptions(Exception ex) {
        log.error(ex.getMessage(), ex);
        return InternalError.builder()
                .message("Please, try later!")
                .build();
    }

}
