package com.hilab.peoplemanager.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
public class MongodbConfiguration extends AbstractMongoClientConfiguration{

  private final MongoProperties properties;

  public MongodbConfiguration(MongoProperties properties) {
    super();
    this.properties = properties;
  }

  @Override
  public MongoClient mongoClient() {
    return MongoClients.create(properties.getUri());
  }

  @Override
  protected String getDatabaseName() {
    return properties.getDatabase();
  }

}
