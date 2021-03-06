package br.com.cinq.spring.data.sample.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

import br.com.cinq.spring.data.sample.resource.SampleResource;

/**
 * Register Jersey modules
 * @author Adriano Kretschmer
 */
@Configuration
@ApplicationPath("rest")
public class Config extends ResourceConfig {

    public Config() {
        register(SampleResource.class);
//        		packages("br.com.cinq.greet.resource");
        		property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }


}