package pl.szczyrba.crypto.model;

import java.util.Map;

public record Record(String source, Map<String, Double> rates) {
    public Map<String, Double> getRates() {
        return rates;
    }
}
