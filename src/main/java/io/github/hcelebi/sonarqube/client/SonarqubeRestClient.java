package io.github.hcelebi.sonarqube.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hcelebi.sonarqube.domain.dto.IssuesResult;
import io.github.hcelebi.sonarqube.domain.request.GetIssuesRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

public class SonarqubeRestClient {

    private final String baseUri;
    private final String token;
    private final HttpClient client;

    public SonarqubeRestClient(String baseUri, String token, HttpClient httpClient) {
        this.baseUri = baseUri;
        this.token = token;
        this.client = httpClient;
    }

    public IssuesResult getIssues(GetIssuesRequest getIssuesRequest) {
        try {
            String query = "?p=" + getIssuesRequest.getP() + "&ps=" + getIssuesRequest.getPs();
            if (getIssuesRequest.getProjects() != null) {
                query += "&projects=" + getIssuesRequest.getProjects().stream().collect(Collectors.joining(","));
            }
            URI uri = URI.create(baseUri + "/issues/search" + query);
            HttpResponse<String> response = getHttpResponse(uri);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), IssuesResult.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpResponse<String> getHttpResponse(URI uri) throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                .uri(uri)
                .version(HttpClient.Version.HTTP_1_1)
                .header("Authorization", "Basic " + token)
                .header("Content-Type", "application/json")
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
