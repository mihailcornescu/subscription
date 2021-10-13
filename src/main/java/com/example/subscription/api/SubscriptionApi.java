package com.example.subscription.api;

import com.example.subscription.api.dto.SubscriptionDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/subscription")
public interface SubscriptionApi {

    @PostMapping("/subscribe")
    void subscribe(@RequestBody SubscriptionDto subscriptionDto);
}
