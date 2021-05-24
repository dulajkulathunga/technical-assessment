package com.technical.assessment.processor;

import com.technical.assessment.configurations.factory.BeanServiceProvider;
import com.technical.assessment.configurations.mediator.ProcessHandlerScan;
import com.technical.assessment.dto.CommonJsonResponse;
import com.technical.assessment.exceptions.customs.MethodNotImplement;
import com.technical.assessment.utilities.constants.ExceptionConstants;
import com.technical.assessment.utilities.constants.WebResponseConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class CatalogueRequestProcessor extends ProcessHandlerScan {

    public enum ConstantCommand implements ProcessHandlerScan.BeanRequestCommand<CatalogueRequestProcessor> {
        ADD_ITEM_TO_CART, DELETE_FROM_CART
    }

    public <T extends Enum<T> & BeanRequestCommand<?>> ResponseEntity<T> processRequest(
            HttpServletRequest request, T command, Object dataTransferObject) {

        if (command.equals(ConstantCommand.ADD_ITEM_TO_CART)) {

            CommonJsonResponse commonJsonResponse = BeanServiceProvider
                    .getService().setcommonResponseService()
                    .commonJsonResponse(WebResponseConstants.CART_ADDED.toString(), HttpStatus.OK.toString(), "", null);

            return new ResponseEntity(commonJsonResponse, HttpStatus.OK);

        }
        throw new MethodNotImplement(ExceptionConstants.METHOD_NOT_IMPLEMENT.toString());
    }

}
