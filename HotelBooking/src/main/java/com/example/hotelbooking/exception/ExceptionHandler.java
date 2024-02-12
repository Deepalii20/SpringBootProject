package com.example.hotelbooking.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(RoomUnavailableException.class)
    public ResponseEntity<Object> handleRoomUnavailableException(RoomUnavailableException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of(
                "message", ex.getMessage()
                
            ));}
	@org.springframework.web.bind.annotation.ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of(
                "message", ex.getMessage()
                
            ));}
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<Object> handleInvalidBookingException(InvalidBookingException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of(
                "message", ex.getMessage()
                
            ));}
	//to show the default message 
			@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
			public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidExcep(MethodArgumentNotValidException ex) {
	 
				Map<String, String> resp = new HashMap<>();
				ex.getBindingResult().getAllErrors().forEach((error) -> {
					String fieldName = ((FieldError) error).getField();
					String message = error.getDefaultMessage();
					resp.put(fieldName, message);
				});
	 
				return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	 
			}
        
        

}
