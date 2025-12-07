package com.microservices.user.service.userservice.Payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
