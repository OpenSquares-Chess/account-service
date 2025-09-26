package com.project.distributed_online_chess;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@TestConfiguration
public class MongoTestConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        // Use an in-memory MongoDB or local MongoDB URI for testing
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        return new MongoTemplate(mongoClient, "test_db"); // 'test_db' can be your test DB
    }
}
