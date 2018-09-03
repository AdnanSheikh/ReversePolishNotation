package com.sumato.rpn;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Adnan Ahmad on 9/3/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootConsoleApplication.class)
public class TestRPNApplication {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    
    @Autowired
    private RPNProcessor processor;

    @Test
    public void testValidRPN() throws Exception {
        String inputRPN = "5 3 +";
        System.setIn(new ByteArrayInputStream(inputRPN.getBytes()));
        processor.process();
        assertTrue(systemOutRule.getLog().contains("Output: 8.00"));
    }

    @Test
    public void testInvalidRPN() throws Exception {
        String inputRPN = "a 3 +";
        System.setIn(new ByteArrayInputStream(inputRPN.getBytes()));
        processor.process();
        assertTrue(systemOutRule.getLog().contains("NumberFormatException"));
    }

    @Test
    public void testLongRPN() throws Exception {
        String inputRPN = "15 7 1 1 + - ÷ 3 × 2 1 1 + + -";
        System.setIn(new ByteArrayInputStream(inputRPN.getBytes()));
        processor.process();
        assertTrue(systemOutRule.getLog().contains("Output: 5.00"));
    }

    @After
    public void tearDown(){
        systemOutRule.clearLog();
    }
}