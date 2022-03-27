package pl.szczyrba.crypto.service;

import com.google.gson.Gson;
import pl.szczyrba.crypto.model.binancepairs.Pair;
import pl.szczyrba.crypto.model.Rate;
import pl.szczyrba.crypto.model.Record;

import java.util.*;

public record RateService(String currency, String[] filters) {

    public String getCurrencyRates() {

        List<Pair> selectedPairs = selectPairs();
        Map<String, Double> records = getBinanceRecords(selectedPairs);

        return new Gson().toJson(new Record(currency, records));
    }

    private List<Pair> selectPairs() {
        List<Pair> selectedPairs = BinanceRestService.getAllPairs().getSymbols().stream()
                .filter(e -> e.getSymbol().startsWith(currency))
                .toList();

        if (filters != null) {
            selectedPairs = applyFilters(selectedPairs);
        }

        return selectedPairs;
    }

    private List<Pair> applyFilters(List<Pair> selectedPairs) {
        return selectedPairs.stream()
                .filter(e -> Arrays.stream(filters).toList().stream()
                        .anyMatch(n -> e.getSymbol().equals(currency + n))) //endsWith doesn't work - there are tokens like BULLUSDT, BEARUSDT
                .toList();
    }

    private Map<String, Double> getBinanceRecords(List<Pair> selectedPairs) {

        Map<String, Double> records = new HashMap<>();
        for (Pair pair : selectedPairs) {
            String pairedCurrency = pair.getSymbol().substring(currency.length());
            Rate rate = BinanceRestService.getRate(pair.getSymbol());
            records.put(pairedCurrency, rate.getPrice());
        }

        return records;
    }
}
