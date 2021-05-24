package com.technical.assessment.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
@Service
public class CommonJsonResponse implements Serializable {

public CommonJsonResponse(){}

    private String status;
    private Object data;
    private String message;
    private String pagination;
    private String redirectUrl;
    public CommonJsonResponse(String status, Object data, String message, String pagination, String redirectUrl){
        this.status=status;
        this.data=data;
        this.message=message;
        this.pagination=pagination;
        this.redirectUrl=redirectUrl;

    }


}
