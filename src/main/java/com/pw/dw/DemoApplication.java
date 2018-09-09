package com.pw.dw;

import com.pw.dw.resources.PersonsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DemoApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
    }

    @Override
    public void run(AppConfiguration configuration,
                    Environment environment) {
        final PersonsResource resource = new PersonsResource();

        environment.jersey().register(resource);
    }  

}
