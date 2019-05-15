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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


package resources;

// TODO - add your @Path here
public class StockResource {

    // resource to get stock data
    // return data based on 3 inputs
    // (Stock ticker, start date and end dates)

    public Stock getAllStockPrices(String stockTicker, String start, String end) throws Exception {
        List<Stock> stocks = FileHelper.readAllStocks("historicalStockData.json");
        List<ClosePrice> dailyClosePrices = new ArrayList<ClosePrice>();
        // look for company
        for (Stock company : companies) {
            // if stock data found, create close price list
            if (stockTicker.equals(company.name)) {
                dailyClosePrices = company.data;
                return dailyClosePrices; 
            }
        }
        // stock ticker not found
        Response r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error: Stock Ticker not found.").build();
        System.out.println(r.toString());
    }
}
