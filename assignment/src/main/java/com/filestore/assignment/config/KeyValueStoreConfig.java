package com.filestore.assignment.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyValueStoreConfig {

	 /*@Bean
	    public MongoTemplate mongoTemplate() throws IOException {
	        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	        mongo.setBindIp("localhost");
	        MongoClient mongoClient = mongo.getObject();
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "my_db");
	        return mongoTemplate;
	    }*/
}
