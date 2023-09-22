package com.spring.board.eia.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    //public static final String SERVICE_ENDPOINT = "https://dynamodb-fips.us-east-1.amazonaws.com";
    public static final String SERVICE_ENDPOINT = "https://dynamodb.us-east-1.amazonaws.com";
    public static final String REGION = "us-east-1";
    public static final String ACCESS_KEY = "";
    public static final String SECRET_KEY = "";
//    public static final String ACCESS_KEY = "AKIAWQPN2BRUEQKQU5AP";
//    public static final String SECRET_KEY = "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";


    @Bean
    public DynamoDBMapper mapper() {
        return new DynamoDBMapper(amazonDynamoDBConfig());
    }


    private AmazonDynamoDB amazonDynamoDBConfig() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
    }
}
