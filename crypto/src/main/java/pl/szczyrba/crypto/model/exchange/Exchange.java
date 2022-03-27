package pl.szczyrba.crypto.model.exchange;

import java.util.List;

public record Exchange(String from, List<String> to, double amount) {
    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
