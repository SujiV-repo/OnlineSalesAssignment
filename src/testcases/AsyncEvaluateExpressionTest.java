package testcases;

import org.junit.Test;
import tasktwo.AsyncEvaluateExpression;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AsyncEvaluateExpressionTest {
    @Test
    public void testEvaluateExpressionsWithValidInput() {
        String expression = "2+6*8";
        String variables = "variable1,variable2,variable3";
        String values = "2,6,8";

        assertDoesNotThrow(() ->
                AsyncEvaluateExpression.evaluateExpressions(expression, variables, values));
    }

    @Test
    public void testEvaluateExpressionsWithInvalidInput() {

        String expression = "invalid expression";
        String variables = "variable1";
        String values = "2";

        assertThrows(RuntimeException.class,
                () -> AsyncEvaluateExpression.evaluateExpressions(expression, variables, values));
    }
}
