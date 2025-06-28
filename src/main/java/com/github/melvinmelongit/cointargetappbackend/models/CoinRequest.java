package com.github.melvinmelongit.cointargetappbackend.models;

import java.util.List;

public class CoinRequest {
    private double amount;
    private List<Number> denominationsList;

    public CoinRequest() {}

    public double getAmount() {
        return amount;
    }

    public List<Number> getDenominationsList() {
        return denominationsList;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDenominationsList(List<Number> denominationsList) {
        this.denominationsList = denominationsList;
    }
}
