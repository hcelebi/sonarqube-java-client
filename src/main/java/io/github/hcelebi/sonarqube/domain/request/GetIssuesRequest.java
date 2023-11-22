package io.github.hcelebi.sonarqube.domain.request;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

@Data
public class GetIssuesRequest {
    private Integer p;
    private Integer ps;
    private List<String> projects;
    private Boolean resolved;
    private DateTime createdAfter;
    private DateTime createdBefore;
}
