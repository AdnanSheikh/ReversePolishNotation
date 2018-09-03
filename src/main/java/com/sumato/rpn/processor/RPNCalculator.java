package com.sumato.rpn.processor;

import com.sumato.rpn.model.Request;
import com.sumato.rpn.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.BiFunction;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@Service
public class RPNCalculator {

    public Response calculate(final Request request) {
        Deque<Double> numbers = new ArrayDeque<>();
        Arrays.asList(request.getInput().split(" "))
            .stream()
            .forEach(number -> {
                switch(number) {
                    case "+":
                        calculateOperator(numbers, (n1, n2) -> n2 + n1);
                        break;
                    case "-":
                        calculateOperator(numbers, (n1, n2) -> n2 - n1);
                        break;
                    case "*":
                    case "×":
                        calculateOperator(numbers, (n1, n2) -> n2 * n1);
                        break;
                    case "÷":
                    case "/":
                        calculateOperator(numbers, (n1, n2) -> n2 / n1);
                        break;
                    default:
                        numbers.push(Double.parseDouble(number));
            }
        });
        return new Response(numbers.pop());
    }


    private void calculateOperator(Deque<Double> numbers, BiFunction<Double, Double, Double> operation) {
        numbers.push(operation.apply(numbers.pop(), numbers.pop()));
    }
}