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
import pojo.ClosePrice;
import pojo.Stock;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;




// TODO - add your @Path here
public class StockResource {

    // resource to get stock data
    // return data based on 3 inputs
    // (Stock ticker, start date and end dates)

    public GregorianCalendar turntoDate(String date) {
        String[] comp = date.split("/");
        return new GregorianCalendar(Integer.parseInt(comp[2]), Integer.parseInt(comp[0]), Integer.parseInt(comp[1]));
    }

    public List<ClosePrice> getAllStockPrices(String stockTicker, String start, String end) throws Exception {
        List<Stock> stocks = FileHelper.readAllStocks("historicalStockData.json");
        List<ClosePrice> dailyClosePrices = new ArrayList<ClosePrice>();
        GregorianCalendar star = turntoDate(start);
        GregorianCalendar en = turntoDate(end);
        // look for company
        for (Stock company : stocks) {
            // if stock data found, create close price list
            if (stockTicker.equals(company.getName())) {
                for( Object c: company.getDaily()) {
                    ClosePrice p = (ClosePrice) c;
                    GregorianCalendar curr = turntoDate(p.getDate());
                    if (curr.before(en) && curr.after(star)) {
                        dailyClosePrices.add(p);
                    }
                }
                return dailyClosePrices;
            }
        }
        // stock ticker not found
        /*Response r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error: Stock Ticker not found.").build();
        System.out.println(r.toString());*/
        return null;
    }
}
