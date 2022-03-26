package pl.szczyrba.crypto.model;

import java.util.List;
import java.util.Map;

public class Record {
    private String source;
    private Map<String, String> rates;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    public Record(String source, Map<String, String> rates) {
        this.source = source;
        this.rates = rates;
    }
}
