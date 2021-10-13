package com.example.subscription.api.impl;

import com.example.subscription.api.SubscriptionApi;
import com.example.subscription.api.dto.SubscriptionDto;
import com.example.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SubscriptionController implements SubscriptionApi {

    private final SubscriptionService subscriptionService;
    @Override
    public void subscribe(SubscriptionDto subscriptionDto) {
        final Integer userId = subscriptionDto.getUserId();
        final Integer subscriptionId = subscriptionDto.getSubscriptionId();;
        log.info("trying to subscribe userId {} to {}", userId, subscriptionId);
        subscriptionService.addSubscriptionForUser(subscriptionDto);
    }
}
