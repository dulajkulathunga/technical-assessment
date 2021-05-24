package com.technical.assessment.configurations.mediator;

import com.technical.assessment.exceptions.customs.MethodNotImplement;
import com.technical.assessment.utilities.constants.ExceptionConstants;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class ProcessHandlerScan {
    public interface BeanRequestCommand<T extends ProcessHandlerScan> {
        default ProcessHandlerScan getController() {

            AnnotationConfigApplicationContext contextBeans = new AnnotationConfigApplicationContext();
            contextBeans.register(this.getClass().getEnclosingClass());
            contextBeans.refresh();
            return (ProcessHandlerScan )contextBeans.getBean(this.getClass().getEnclosingClass());
        }
    }
    public <T extends Enum<T> & BeanRequestCommand<?>> ResponseEntity<T> processRequest(
            HttpServletRequest request, T command, Object entityObject) {
        throw new MethodNotImplement(ExceptionConstants.METHOD_NOT_IMPLEMENT.toString());
    }
}
