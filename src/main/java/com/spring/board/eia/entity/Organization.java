package com.spring.board.eia.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

import java.io.Serializable;

public class Organization implements Serializable {
    @DynamoDBAttribute
    private String orgId;
    @DynamoDBAttribute
    private String orgName;
    @DynamoDBAttribute
    private long service;
}

