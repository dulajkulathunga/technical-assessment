package com.technical.assessment.controllers;

import com.technical.assessment.configurations.mediator.RequestMediator;
import com.technical.assessment.processor.CatalogueRequestProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private RequestMediator requestMediator;

    public CartController(RequestMediator requestMediator) {
        this.requestMediator = requestMediator;
    }

    @PatchMapping(value = "/item/{id}")
    public ResponseEntity<Map<String, Object>> addCart(HttpServletRequest httpServletRequest) {
        log.info("addCart");
        return requestMediator.handleRequest(httpServletRequest,null, CatalogueRequestProcessor.ConstantCommand.ADD_ITEM_TO_CART);
    }


    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<Map<String, Object>> deleteItem(HttpServletRequest httpServletRequest) {
        log.info("deleteItem");
        return requestMediator.handleRequest(httpServletRequest,null, CatalogueRequestProcessor.ConstantCommand.DELETE_FROM_CART);
    }
}
