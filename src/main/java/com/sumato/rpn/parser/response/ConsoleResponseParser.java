package com.sumato.rpn.parser.response;

import com.sumato.rpn.model.Response;
import org.springframework.stereotype.Repository;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Repository
public class ConsoleResponseParser implements IResponseParser {
    @Override
    public void writeResponse(Response response) {
        System.out.println("################ Output ################");
        System.out.printf("%.2f\n",response.getOutput());
    }
}