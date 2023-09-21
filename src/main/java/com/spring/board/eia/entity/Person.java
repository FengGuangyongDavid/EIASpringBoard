package com.spring.board.eia.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "eia.person")
public class Person implements Serializable {
    @DynamoDBHashKey(attributeName = "personId")
    @DynamoDBAutoGeneratedKey
    private String personId;
    @DynamoDBAttribute
    private String cabinNo;
    @DynamoDBAttribute
    private String firstName;
    @DynamoDBAttribute
    private String lastName;
    @DynamoDBAttribute
    private String MHProvider;
    @DynamoDBAttribute
    private String SUDProvider;
    @DynamoDBAttribute
    private String caseManagement;
    @DynamoDBAttribute
    private String need;
    @DynamoDBAttribute
    private String phoneNo;
    @DynamoDBAttribute
    private String cabinStatus;  //active/inactive
    @DynamoDBAttribute
    private int startDate;
    @DynamoDBAttribute
    private int endDate;
    @DynamoDBAttribute
    private String gender;
    @DynamoDBAttribute
    private String racial;
    @DynamoDBAttribute
    private int age;
    @DynamoDBAttribute
    private String historyOfUse;
    @DynamoDBAttribute
    private String activeUser;
    @DynamoDBAttribute
    private String activeOtherSubstances;
    @DynamoDBAttribute
    private String previousUser;
    @DynamoDBAttribute
    private String opiateTreatmentAtResidency;
    @DynamoDBAttribute
    private String inTreatmentForOtherSubstances;
    @DynamoDBAttribute
    private String inMentalHealthTreatment;
    @DynamoDBAttribute
    private String nameOfProvider;
    @DynamoDBAttribute
    private String dualDX;
    @DynamoDBAttribute
    private String permanentHouse;
    @DynamoDBAttribute
    private String entrustedAssertiveCommunity;
    @DynamoDBAttribute
    private String live;
    @DynamoDBAttribute
    private String longerTermSubstanceReturn;
    @DynamoDBAttribute
    private String decidedMove;
    @DynamoDBAttribute
    private String exitByRuleViolations;
    @DynamoDBAttribute
    private String documentationAssistance;
    @DynamoDBAttribute
    private String achievements;


}
