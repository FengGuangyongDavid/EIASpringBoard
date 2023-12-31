package com.spring.board.eia.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
public class File implements Serializable {
    private String name;
    private String category;
    private String desc;
    private String updatedTime;

    public File(String name, String category, String desc, String updatedTime) {
        this.name = name;
        this.category = category;
        this.desc = desc;
        this.updatedTime = updatedTime;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public String getCategory() {
        return category;
    }
}
