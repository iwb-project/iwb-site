package org.iwb.site.bootstrap;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;

/**
 * Holds the main configuration for spring bootstrap.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"org.iwb.site"})
@PropertySources({
        @PropertySource(value = "classpath:legacy.properties", ignoreResourceNotFound = false),
        @PropertySource(value = "classpath:default-configuration.properties", ignoreResourceNotFound = false)
}
)
@EnableMongoRepositories(basePackages = "org.iwb.site.repository")
public class ApplicationConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public Mongo mongo() throws UnknownHostException {
        MongoCredential.createMongoCRCredential(this.env.getProperty("mongodb.user"), this.env.getProperty("mongodb.base"), this.env.getProperty("mongodb.pass").toCharArray());
        return new MongoClient(this.env.getProperty("mongodb.host"), this.env.getProperty("mongodb.port", Integer.class));
    }

}
