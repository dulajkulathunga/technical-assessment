package com.technical.assessment.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Data
@Service
public class ExceptionResponseDto {
    private LocalTime timestamp;
    private int status;
    private String message;
    private String path;

}
