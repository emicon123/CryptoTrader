package pl.szczyrba.crypto.service;

import com.google.gson.Gson;
import pl.szczyrba.crypto.model.exchange.Exchange;
import pl.szczyrba.crypto.model.exchange.ExchangeResult;
import pl.szczyrba.crypto.model.Record;
import pl.szczyrba.crypto.model.exchange.ExchangeOutput;

import java.util.HashMap;
import java.util.Map;

public record ExchangeService(Exchange exchange) {

    public String exchangeCurrencies() {

        Record record = getRecordsForExchange();
        Map<String, ExchangeResult> exchangeResults = calculateExchangeResults(record);

        return new Gson().toJson(new ExchangeOutput(exchange.getFrom(), exchangeResults));
    }

    private Record getRecordsForExchange() {
        Map<String, Double> records = new HashMap<>();
        exchange.getTo().forEach(e -> records.put(e, BinanceRestService.getRate(exchange.getFrom() + e).getPrice()));

        return new Record(exchange.getFrom(), records);
    }

    private Map<String, ExchangeResult> calculateExchangeResults(Record record) {
        Map<String, ExchangeResult> exchangeResults = new HashMap<>();
        record.getRates().forEach((k, v) -> {
            double exchangeResult = v * exchange.getAmount();
            double exchangeFee = exchangeResult * 0.01;
            exchangeResults.put(k, new ExchangeResult(v, exchange.getAmount(), exchangeResult, exchangeFee));
        });
        return exchangeResults;
    }
}
