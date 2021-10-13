package com.example.subscription.persistence.repository;

import com.example.subscription.persistence.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Integer> {

    Optional<SubscriptionEntity> findFirstByUserIdAndSubscriptionId(Integer userId, Integer subscriptionId);
}
