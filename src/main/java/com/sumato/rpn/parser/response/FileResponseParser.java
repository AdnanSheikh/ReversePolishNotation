package com.sumato.rpn.parser.response;

import com.sumato.rpn.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Repository
public class FileResponseParser implements IResponseParser {

    @Value("${output.file.path}")
    private String outputFilePath;

    @Override
    public void writeResponse(Response response) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            bw.write(Double.toString(response.getOutput()));
        }
    }
}