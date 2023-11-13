package io.github.hcelebi.sonarqube.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class GetIssuesRequest {
    private Integer p;
    private Integer ps;
    private List<String> projects;
}
