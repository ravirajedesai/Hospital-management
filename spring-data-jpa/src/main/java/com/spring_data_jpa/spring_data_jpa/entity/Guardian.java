package com.spring_data_jpa.spring_data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Guardian {
    @JsonProperty(namespace = "gurdian_name")
    private String name;
    @JsonProperty(namespace = "guridan_email")
    private String email;
    @JsonProperty(namespace = "gurdian_mobile")
    private String mobile;
}
