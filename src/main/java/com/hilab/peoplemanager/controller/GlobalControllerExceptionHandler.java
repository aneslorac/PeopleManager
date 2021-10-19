package com.hilab.peoplemanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {

    List<ObjectError> errors = ex.getBindingResult().getAllErrors();

    Map<String, String> errorsMap = new HashMap<>();
    errors.stream().forEach( error -> {
      errorsMap.put(((FieldError) error).getField(), error.getDefaultMessage());
    });

    return ResponseEntity.badRequest().body(errorsMap);
  }
}
