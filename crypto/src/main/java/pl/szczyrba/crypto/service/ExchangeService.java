package pl.szczyrba.crypto.service;

import pl.szczyrba.crypto.model.Currency;

import java.util.List;

public class ExchangeService {

    private Currency fromCurrency;
    private List<Currency> toCurrencies;
    private double amount;

    public ExchangeService(Currency fromCurrency, List<Currency> toCurrencies, double amount) {
        this.fromCurrency = fromCurrency;
        this.toCurrencies = toCurrencies;
        this.amount = amount;
    }

    public ExchangeService(Currency fromCurrency, List<Currency> toCurrencies) {
        this.fromCurrency = fromCurrency;
        this.toCurrencies = toCurrencies;
    }

    public void exchangeCurrencies() {
        fromCurrency.getPrice();
    }
}
