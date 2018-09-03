package com.sumato.rpn.parser.request;

import com.sumato.rpn.model.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Repository
public class FileRequestParser implements IRequestParser {

    @Value("${input.file.path}")
    private String inputFilePath;

    @Override
    public Request readRequest() throws IOException {
        Request request;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFilePath))) {
            request = new Request(br.readLine());
        }
        return request;
    }
}