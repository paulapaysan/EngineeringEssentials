package utility;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import resources.CompanyResource;
import resources.StockResource;

/**
 * Copyright 2018 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
public class Service extends Application<Configuration> {

    /**
     *
     * General Instructions:
     *
     * This is a rough guide of how each exercise will go:run
     * 1) Read the prompt
     * 2) Go to ResourcesTest.java and run the example test case, make sure that it fails
     *      - In some cases the test may not already be filled in for you, then you will have to write the test,
     *      - and see it fail
     * 3) Implement the solution in Example<#>Resource.java
     * 4) Go to ResourcesTest.java and run the test, make sure it passes
     * 5) Uncomment the example resource in the 'run' method below
     * 5) Restart the Server (if you get a "address-in-use bind" error, then you did not properly stop the server
     * 6) Visit the URL to confirm it is working (for GET requests)
     * 7) Check appropriate JSON file in "data" folder to make sure data was updated properly (for POST, PUT, DELETE)
     *
     *
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);


    public Service() {
    }

    @Override
    public void initialize(Bootstrap<Configuration> b) {

    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new CompanyResource());
        e.jersey().register(new StockResource());
        LOGGER.info("Successfully started REST Service.");
    }

    /**
     *
     * StarterApp Intellij Run Configuration:
     *
     * Program args: 'server'
     * Working Directory: path to EngineeringEssentialsTraining
     *  - '...\EngineeringEssentials\EngineeringEssentialsTraining"
     */
    public static void main(String[] args) throws Exception {

        Service restServer = new Service();
        restServer.run(args);

        System.out.println("Go to localhost:8080/hello/ok in your browser.");
    }

}