package tasktwo;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class MainClass {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        Scanner scanner = new Scanner(System.in);
        //enter the mathematical expression that we want the answer
        //ex: 2*4+5 or 9-2*10
        System.out.println("Enter the Mathematical Expression :");
        String expression = scanner.nextLine().trim();

        //we have to provide the variable names for each number that we are providing in the mathematical expression
        //ex: variable1,variable2,variable3
        System.out.println("Enter variable names (separated by commas):");
        String variables = scanner.nextLine().trim();

        //We have to get every value present in the expression separated by commas
        //suppose if there are three values in the expression
        //we have to send input like this: 12,23,34
        System.out.println("Enter every value in the expression (separated by commas):");
        String values = scanner.nextLine().trim();

        AsyncEvaluateExpression.evaluateExpressions(expression, variables, values);
        scanner.close();
    }
}
