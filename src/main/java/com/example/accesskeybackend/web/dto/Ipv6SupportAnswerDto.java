package com.example.accesskeybackend.web.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Ipv6SupportAnswerDto {
    @Value("false")
    private boolean success;
}
