package com.sumato.rpn;

import com.sumato.rpn.model.Request;
import com.sumato.rpn.model.Response;
import com.sumato.rpn.parser.request.IRequestParser;
import com.sumato.rpn.parser.response.IResponseParser;
import com.sumato.rpn.processor.RPNCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Slf4j
@Controller
public class RPNProcessor {
    @Autowired
    @Qualifier("consoleRequestParser")
    private IRequestParser requestParser;

    @Autowired
    @Qualifier("consoleResponseParser")
    private IResponseParser responseParser;

    @Autowired
    private RPNCalculator calculator;

    public void process(){
        try {
            Request request = requestParser.readRequest();
            log.info(String.format("Received RPN from console is: %s", request));
            Response response = calculator.calculate(request);
            log.info(String.format("Response calculated is: %s", response));
            responseParser.writeResponse(response);
        } catch (Exception e) {
           log.error("##ERROR## exception occurs is", e);
        }
    }
}