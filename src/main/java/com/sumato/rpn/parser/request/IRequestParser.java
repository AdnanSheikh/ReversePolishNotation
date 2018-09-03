package com.sumato.rpn.parser.request;

import com.sumato.rpn.model.Request;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
public interface IRequestParser {
    Request readRequest() throws Exception;
}