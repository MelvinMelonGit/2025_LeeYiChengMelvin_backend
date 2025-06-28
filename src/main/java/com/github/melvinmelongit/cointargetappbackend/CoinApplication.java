package com.github.melvinmelongit.cointargetappbackend;

import com.github.melvinmelongit.cointargetappbackend.resources.CoinResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

public class CoinApplication extends Application<CoinConfiguration> {
    public static void main(String[] args) throws Exception {
        new CoinApplication().run(args);
    }

    @Override
    public void run(CoinConfiguration configuration, Environment environment) {
        environment.jersey().register(new CoinResource());
    }
}
