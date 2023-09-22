package com.spring.board.eia.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.spring.board.eia.entity.Organization;
import com.spring.board.eia.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrgRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Organization addPerson(Organization org) {
        mapper.save(org);
        return org;
    }

    public Organization findOrgById(String orgId) {
        return mapper.load(Organization.class, orgId);
    }

    public String deleteOrg(Organization org) {
        mapper.delete(org);
        return "Organization removed !!";
    }

    public List<Organization> findOrgs()
    {
        return mapper.scan(Organization.class, new DynamoDBScanExpression());
    }

    public String editOrg(Organization org) {
        mapper.save(org, buildExpression(org));
        return "Organization updated ...";
    }

    private DynamoDBSaveExpression buildExpression(Organization org) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("orgId", new ExpectedAttributeValue(new AttributeValue().withS(org.getOrgId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }


}
