package io.github.hcelebi.sonarqube.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements Serializable {
    @Serial
    private static final long serialVersionUID = -5832919633628973764L;

    private String key;
    private String project;
    private String resolution;
    private String status;
    private DateTime creationDate;
    private DateTime closeDate;
    private String type;
}
