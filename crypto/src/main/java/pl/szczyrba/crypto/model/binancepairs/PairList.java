package pl.szczyrba.crypto.model.binancepairs;

import java.util.List;

public record PairList(List<Pair> symbols) {

    public List<Pair> getSymbols() {
        return symbols;
    }

}
