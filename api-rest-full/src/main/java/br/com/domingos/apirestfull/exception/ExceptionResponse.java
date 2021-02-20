package br.com.domingos.apirestfull.exception;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class ExceptionResponse {

    @Getter
    private final Date timestamp;

    @Getter
    private final String message;

    @Getter
    private final String details;
}
