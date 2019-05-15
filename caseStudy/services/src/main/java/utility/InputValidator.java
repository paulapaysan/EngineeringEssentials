/**
 * Copyright 2019 Goldman Sachs.
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

package utility;

import pojo.Company;
import pojo.Stock;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Utility class to validate inputs
 */
public class InputValidator {

    // TODO - write a method that will validate your JSON input files

    // write a method that will validate the inputs to the Company Resource
    @GET
    @Path("companies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompanies() throws IOException {
        List<Company> companies = new ArrayList<Company>();
        try {
            companies = FileHelper.readCompaniesFromFile("companyInfo.json");
            return Response.ok().build();
        } catch (Exception e) {
            System.out.println("Failed to read information from file");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    // write a method that will validate the inputs to the Stock Resource
    @GET
    @Path("stocks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStocks() throws IOException {
        List<Stock> stocks = new ArrayList<Stock>();
        try {
            stocks = FileHelper.readAllStocks("historicalStockData.json");
            return Response.ok().build();
        } catch (Exception e) {
            System.out.println("Failed to read information from file");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
