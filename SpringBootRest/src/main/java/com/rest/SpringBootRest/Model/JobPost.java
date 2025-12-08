package com.rest.SpringBootRest.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int postId;
    private String postprofile;
    private String posrDesc;
    private int reqExperience;
    private List<String> postTechstack;

}
