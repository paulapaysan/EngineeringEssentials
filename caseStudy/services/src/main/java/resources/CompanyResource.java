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

package resources;
import pojo.Company;
import utility.FileHelper;

import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("company")
public class CompanyResource{

    // resource to get company data
    // return data for a given stock ticke
    @GET
    @Path("info/{company}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getCompanyInfo(@PathParam("company") String stockTicker) throws Exception {
        List<Company> companies = FileHelper.readCompaniesFromFile("companyInfo.json");
        for (Company co : companies) {
            // if company found in given file
            if (stockTicker.equals(co.getSymbol())) {
                return Response.ok().entity(co).build();
            }
        }
        return null;
        // stock ticker not found
        //return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error: Stock Ticker not found.").build();
    }

}

