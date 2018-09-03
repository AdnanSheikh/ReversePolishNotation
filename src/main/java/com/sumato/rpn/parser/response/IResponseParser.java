package com.sumato.rpn.parser.response;

import com.sumato.rpn.model.Response;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
public interface IResponseParser {
    void writeResponse(final Response response) throws Exception;
}