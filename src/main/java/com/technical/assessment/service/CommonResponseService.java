package com.technical.assessment.service;


import com.technical.assessment.dto.CommonJsonResponse;

public interface CommonResponseService {
    CommonJsonResponse commonJsonResponse(String message, String status, String redirectUrl, Object obj);
}
