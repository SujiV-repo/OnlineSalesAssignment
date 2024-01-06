package tasktwo;

import java.io.IOException;
import java.util.concurrent.*;

public class AsyncEvaluateExpression {
    //maximum number of requests per second
    private static final int MAX_REQUEST_PER_SECOND = 50;
    //semaphore for ratelimiting to ensure maximium requests
    private static final Semaphore rateLimiter = new Semaphore(MAX_REQUEST_PER_SECOND);

    public static void evaluateExpressions(String expression, String variables, String values) throws ExecutionException, InterruptedException, TimeoutException {
        // Run the expression evaluation asynchronously using CompletableFuture
        CompletableFuture.runAsync(() -> {
            try {
                //acquiring a permit for the rate limiter
                rateLimiter.acquire();
                String str = EvaluateExpression.EvaluateExpressionMethod(expression, variables, values);
                System.out.println(expression + "-> " + str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                //release the permit after expression evaluate is complete
                rateLimiter.release();
            }
        }).get(5, TimeUnit.SECONDS); // wait time of 5 seconds to complete the async task
    }
}
