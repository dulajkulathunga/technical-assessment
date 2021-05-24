package com.technical.assessment.configurations.mediator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RequestMediator {

    public <T extends Enum<T> & ProcessHandlerScan.BeanRequestCommand<?>> ResponseEntity handleRequest(
            HttpServletRequest request,
            Object obj,
            ProcessHandlerScan.BeanRequestCommand<?> command) {

        return command.getController().processRequest(request, (T) command, obj);

    }
}
