package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;

    public static ResponseEntity<Response> getOk(
            Map<?, ?> map,
            String message) {
        ResponseEntity<Response> response = ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(map)
                        .message(message)
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );

        return response;
    }

    public static ResponseEntity<Response> getInternalServerError(
            LocalDateTime timeStamp,
            Map<?, ?> map,
            String message) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(timeStamp)
                        .data(map)
                        .message(message)
                        .status(INTERNAL_SERVER_ERROR)
                        .statusCode(INTERNAL_SERVER_ERROR.value())
                        .build()
        );
    }
}
