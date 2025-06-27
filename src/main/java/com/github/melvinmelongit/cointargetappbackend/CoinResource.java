package com.github.melvinmelongit.cointargetappbackend;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.*;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoinResource {

    Double[] coinDenominations = {0.01, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 50.0, 100.0, 1000.0};

    @GET
    @Path("/count")
    public List<Double> getCoins(@QueryParam("amount") double amount) {

        // this list is to convert the coinDenominations array to an Integer List for further processing
        List<Integer> coinDenominationsList = new ArrayList<>();

        for (Double denomination : coinDenominations) {
            // multiply by 100 and type cast to int to prevent floating point error
            coinDenominationsList.add((int)(denomination * 100));
        }

        // variables for looping construct
        int maxListIndex = coinDenominationsList.size() - 1;

        // temp variable to store the specific denomination used for deduction
        int selectedDenomination = 0;

        // multiply by 100 and type cast to int to prevent floating point error
        int remainder = (int)(amount * 100);

        // this list is to consolidate the return result
        List<Double> result = new ArrayList<>();

        // as long as remainder is above 0
        while (remainder > 0) {

            // loop through to ensure that the denomination deductible is valid
            for (int i = maxListIndex; i >= 0; i--) {
                selectedDenomination = coinDenominationsList.get(i);
                if ((remainder - selectedDenomination) >= 0) break;
            }

            // deduct from remaining amount
            remainder -= selectedDenomination;

            // add the denomination to the result list
            result.add(selectedDenomination/100.0);
        }

        // sort the list in numerical order
        Collections.sort(result);

        return result;
    }
}
