package com.fawad.walletapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<?> handleWalletException(WalletException ex, WebRequest request){
        WalletExceptionResponse response = new WalletExceptionResponse(ex.getMessage());
        return new ResponseEntity<WalletExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
