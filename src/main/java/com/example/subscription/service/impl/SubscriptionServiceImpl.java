package com.example.subscription.service.impl;

import com.example.subscription.api.dto.SubscriptionDto;
import com.example.subscription.persistence.entity.SubscriptionEntity;
import com.example.subscription.persistence.repository.SubscriptionRepository;
import com.example.subscription.service.SubscriptionService;
import com.example.subscription.service.mapper.SubscriptionMapper;
import com.example.subscription.util.exceptions.InvalidInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;
    private final SubscriptionMapper mapper;

    @Override
    @Transactional
    public void addSubscriptionForUser(SubscriptionDto subscriptionDto) {
        repository.findFirstByUserIdAndSubscriptionId(subscriptionDto.getUserId(), subscriptionDto.getSubscriptionId())
                .ifPresent(x -> {
                    throw new InvalidInputException("There is already a subscription for user");
                });
        final SubscriptionEntity entity = mapper.dtoToEntity(subscriptionDto);
        repository.save(entity);
    }
}
