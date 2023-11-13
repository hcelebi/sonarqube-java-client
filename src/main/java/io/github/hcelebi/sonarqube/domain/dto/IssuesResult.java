package io.github.hcelebi.sonarqube.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssuesResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 6568559959732132932L;
    private Integer total;
    private Integer p;
    private Integer ps;
    private List<Issue> issues;
}
