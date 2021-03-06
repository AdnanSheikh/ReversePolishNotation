<h1>Problem Statement</h1>

Implement RPN (Reverse Polish Notation) expressions parser

 - Parser has to be a Java application that can be run on a JVM
 - Parser has to consume RPN expression given in a string form (ie. as java main method parameter) but should be implemented in a way that allows to easily extend this (ie. to read RPN expression from file or database)
 - Parser has to print the result of RPN expression evaluation on a screen (ie. System.out) but should be implemented in a way that allows to easily extend this (ie. to write RPN expression evaluation result to file or database)
 - Parser has to handle 2 kinds of arithmetical operations (addition and subtraction) but should be implemented in a way that allows to easily extend the number of supported operations (multiplication, division, etc.)
 - Parser has to be buildable and runnable using maven. The solution should be of “production quality”.

<h2>Technology Stack</h2>
 
 - Java 8
 - Spring Boot
 - Maven 
 - Lombok

<h2>Test Application</h2>

 - mvn test