package com.example.accesskeybackend.web.controller;

import com.example.accesskeybackend.exception.IllegalArgumentException;
import com.example.accesskeybackend.web.dto.Ipv6SupportAnswerDto;
import com.example.accesskeybackend.web.service.Ipv6SupportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/web/checkIpv6Support")
@AllArgsConstructor
public class Ipv6SupportController {
    private final Ipv6SupportService supportService;

    @GetMapping
    public Ipv6SupportAnswerDto checkIpv6Support(@RequestParam final String siteUrl) {
        try {
            return this.supportService.checkIpv6Support(siteUrl);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(String.format("Bad siteUrl: %s", siteUrl));
        }
    }
}
