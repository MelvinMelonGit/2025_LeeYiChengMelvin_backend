package com.github.melvinmelongit.cointargetappbackend.resources;

import com.github.melvinmelongit.cointargetappbackend.models.CoinRequest;
import com.github.melvinmelongit.cointargetappbackend.services.CoinService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.*;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoinResource {

    private final CoinService coinService;

    public CoinResource() {
        this.coinService = new CoinService();
    }

    @POST
    @Path("/count")
    public List<Number> getCoinDenominations(CoinRequest coinRequest) {
        double amount = coinRequest.getAmount();
        List<Number> denominationsList = coinRequest.getDenominationsList();

        // target amount should only be 0.0 to 10000.0 inclusive
        if (amount < 0.0 || amount > 10000.0) return null;

        return coinService.getCoinDenominations(amount, denominationsList);
    }
}
