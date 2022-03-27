package pl.szczyrba.crypto.model.binancepairs;


public record Pair(String symbol) {

    public String getSymbol() {
        return symbol;
    }
}
