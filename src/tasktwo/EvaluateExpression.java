package tasktwo;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class EvaluateExpression {
    public static String EvaluateExpressionMethod(String expression, String variables, String values) throws IOException, InterruptedException {
        //variables to store the API key and URL
        final String apiKey = "6e87274bd6msh955907e34aa9f28p1b58fdjsne0daf32e925b";
        final String apiUrl = "https://mathematical-symbolic-expression-manipulator.p.rapidapi.com/Evaluate";

        //Getting the information for variables,expressions and values to encode and pass it in the api request
        String encodedVariables = URLEncoder.encode(variables, StandardCharsets.UTF_8);
        String encodedValues = URLEncoder.encode(values, StandardCharsets.UTF_8);
        String encodedExpression = URLEncoder.encode(expression, StandardCharsets.UTF_8);

        String uriParameters = String.format("variables=%s&values=%s&expression=%s",
                encodedVariables, encodedValues, encodedExpression);

        //creating a http request and passing all the parameters for sending API request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl + "?" + uriParameters))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "mathematical-symbolic-expression-manipulator.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
