package pl.szczyrba.crypto.model;

public record Rate(Double price) {
    public Double getPrice() {
        return price;
    }
}
