package models;

import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterResponse {
    String status;
    String message;
    String country;
}
