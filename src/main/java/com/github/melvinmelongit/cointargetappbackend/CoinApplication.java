package com.github.melvinmelongit.cointargetappbackend;

import com.github.melvinmelongit.cointargetappbackend.resources.CoinResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import java.util.EnumSet;

public class CoinApplication extends Application<CoinConfiguration> {
    public static void main(String[] args) throws Exception {
        new CoinApplication().run(args);
    }

    @Override
    public void run(CoinConfiguration configuration, Environment environment) {
        // Register resources
        environment.jersey().register(new CoinResource());

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
