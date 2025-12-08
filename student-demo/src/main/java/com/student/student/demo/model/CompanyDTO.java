package com.student.student.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    @JsonProperty("Company_Id")
    private Long companyId;
    @JsonProperty("Company_Name")
    private String companyName;
    @JsonProperty("Company_Location")
    private String companyLocation;
}
