package com.example.accesskeybackend.web.service;

import com.example.accesskeybackend.web.dto.Ipv6SupportAnswerDto;
import org.springframework.stereotype.Service;

import java.net.*;

@Service
public class Ipv6SupportService {
    public Ipv6SupportAnswerDto checkIpv6Support(String siteUrl) throws UnknownHostException {
        Ipv6SupportAnswerDto result = new Ipv6SupportAnswerDto();

        String domain =  getDomainFromUrl(siteUrl);
        InetAddress[] addresses = InetAddress.getAllByName(domain);
        for (InetAddress address : addresses) {
            if (address instanceof Inet6Address) {
                result.setSuccess(true);
                return result;
            }
        }
        return result;
    }

    private String getDomainFromUrl(String url) {
        return url.replaceAll("http(s)?://|www\\.|/.*", "");
    }
}
