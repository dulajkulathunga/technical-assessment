package com.technical.assessment.serviceImpl;

import com.technical.assessment.dto.CommonJsonResponse;
import com.technical.assessment.service.CommonResponseService;
import org.springframework.stereotype.Service;

@Service
public class CommonResponseServiceImpl implements CommonResponseService {
    private CommonJsonResponse commonJsonResponse;
    public CommonResponseServiceImpl(CommonJsonResponse commonJsonResponse){
        this.commonJsonResponse=commonJsonResponse;
    }

    @Override
    public CommonJsonResponse commonJsonResponse(String message, String status, String redirectUrl,Object obj) {

        commonJsonResponse.setMessage(message);
        commonJsonResponse.setStatus(status);
        commonJsonResponse.setRedirectUrl(redirectUrl);
        commonJsonResponse.setData(obj);


        return commonJsonResponse;
    }
}
