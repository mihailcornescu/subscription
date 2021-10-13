package com.example.subscription.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscription", indexes = { @Index(name = "subscription_unique_idx", unique = true, columnList = "userId,subscriptionId") })
public class SubscriptionEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;
    private Integer subscriptionId;
}
