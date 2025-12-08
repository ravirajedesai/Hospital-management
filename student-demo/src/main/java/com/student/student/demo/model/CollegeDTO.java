package com.student.student.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDTO {

    @JsonProperty("college_id")
    private Long collegeId;
    @JsonProperty("college_name")
    private String collegeName;
    @JsonProperty("college_city")
    private String collegeCity;
}
