package pl.szczyrba.crypto.model.exchange;

import java.util.Map;

public record ExchangeOutput(String from, Map<String, ExchangeResult> to) {
}
