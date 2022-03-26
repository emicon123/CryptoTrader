package pl.szczyrba.crypto.service;

import pl.szczyrba.crypto.model.Pair;

import java.util.List;

//TODO: Try to get rid of this class. Get rid of Pair class later
public class PairsService {

    private List<Pair> symbols;

    public List<Pair> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Pair> symbols) {
        this.symbols = symbols;
    }
}
