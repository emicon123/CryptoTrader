package pl.szczyrba.crypto.model;

import java.util.List;

public class Currency {

    private String name;
    private double price;
    private List<Pair> pairs;

    public List<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public Currency(String name, double price, List<Pair> pairs) {
        this.name = name;
        this.price = price;
        this.pairs = pairs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

