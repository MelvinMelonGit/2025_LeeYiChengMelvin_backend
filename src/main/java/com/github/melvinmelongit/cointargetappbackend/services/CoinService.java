package com.github.melvinmelongit.cointargetappbackend.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CoinService {

    public List<Number> getCoinDenominations(double amount, List<Number> denominationsList) {
        // this list is to convert the coinDenominations array to an Integer List for further processing
        List<Integer> coinDenominationsList = processCoinDenominations(denominationsList);

        // this list is to consolidate the return result
        List<Number> selectedDenominationsList = selectCoinDenominations(coinDenominationsList, amount);

        // sort the list in numerical order
        selectedDenominationsList.sort(Comparator.comparingDouble(Number::doubleValue));

        return selectedDenominationsList;
    }

    private List<Integer> processCoinDenominations(List<Number> denominationsList) {

        List<Integer> coinDenominationsList = new ArrayList<>();

        for (Number denomination : denominationsList) {
            // multiply by 100 and type cast to int to prevent floating point error
            if (denomination instanceof Integer) {
                coinDenominationsList.add(denomination.intValue() * 100);
            } else {
                coinDenominationsList.add((int)(denomination.doubleValue() * 100));
            }
        }

        return coinDenominationsList;
    }

    private List<Number> selectCoinDenominations(List<Integer> coinDenominationsList, double amount) {

        List<Number> selectedDenominationsList = new ArrayList<>();

        // variables for looping construct
        int maxListIndex = coinDenominationsList.size() - 1;

        // temp variable to store the specific denomination used for deduction
        int selectedDenomination = coinDenominationsList.get(maxListIndex);

        // multiply by 100 and type cast to int to prevent floating point error
        int remainder = (int)(amount * 100);

        // as long as remainder is above 0
        while (remainder > 0) {
            // loop through to ensure that the selected denomination to deduct is valid
            // e.g. (70.3 - 100) would not be valid
            for (int i = maxListIndex; i >= 0; i--) {
                selectedDenomination = coinDenominationsList.get(i);
                if ((remainder - selectedDenomination) >= 0) break;
            }

            // deduct from remaining amount
            remainder -= selectedDenomination;

            // add the denomination to the result list. If less than 1, it is a double, else integer.
            if ((selectedDenomination/100.0) < 1.0) {
                selectedDenominationsList.add(selectedDenomination/100.0);
            } else {
                selectedDenominationsList.add(selectedDenomination/100);
            }
        }

        return selectedDenominationsList;
    }
}
