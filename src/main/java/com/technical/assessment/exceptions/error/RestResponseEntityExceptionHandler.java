package com.technical.assessment.exceptions.error;

import com.technical.assessment.dto.ExceptionResponseDto;
import com.technical.assessment.utilities.constants.ExceptionConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final ExceptionResponseDto exceptionResponseDto;

    public RestResponseEntityExceptionHandler(ExceptionResponseDto exceptionResponseDto) {
        super();
        this.exceptionResponseDto = exceptionResponseDto;
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.error("400 Status Code", exception);
        return handleExceptionInternal(exception, responseBuilder("", ExceptionConstants.INVALID_ARGUMENT.toString(), HttpStatus.BAD_REQUEST), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.error("400 Status Code", exception);
        return handleExceptionInternal(exception, responseBuilder("", exception.getMessage(), HttpStatus.BAD_REQUEST), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Object> handleInternal(final RuntimeException exception, final WebRequest request, HttpServletRequest servletRequest) {
        logger.error("500 Status Code", exception);
        return handleExceptionInternal(exception, responseBuilder(servletRequest.getServletPath(), ExceptionConstants.INVALID_INPUT_NOT_ALLOWED.toString(), HttpStatus.INTERNAL_SERVER_ERROR), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ExceptionResponseDto responseBuilder(String servletPath, String message, HttpStatus httpStatus) {
        exceptionResponseDto.setStatus(httpStatus.value());
        exceptionResponseDto.setMessage(message);
        exceptionResponseDto.setTimestamp(LocalTime.now());
        exceptionResponseDto.setPath(servletPath);
        return exceptionResponseDto;
    }


}
