package com.technical.assessment.configurations.factory;

import com.technical.assessment.configurations.context.ApplicationContextHolder;
import com.technical.assessment.serviceImpl.CommonResponseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BeanServiceProvider {
    private static class SingletonHelper {
        private static final BeanServiceProvider INSTANCE = new BeanServiceProvider();
    }

    public static BeanServiceProvider getService() {
        return SingletonHelper.INSTANCE;
    }

    public CommonResponseServiceImpl setcommonResponseService (){
        return ApplicationContextHolder.getContext().getBean(CommonResponseServiceImpl.class);
    }

}
