package com.sumato.rpn.parser.request;


import com.sumato.rpn.model.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Slf4j
@Repository
public class ConsoleRequestParser implements IRequestParser{
    @Override
    public Request readRequest() {
        log.info("Input Reverse polish notation from console:");
        Scanner scanner = new Scanner(System.in);
        return new Request(scanner.nextLine());
    }
}