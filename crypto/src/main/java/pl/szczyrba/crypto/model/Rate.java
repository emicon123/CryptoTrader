package pl.szczyrba.crypto.model;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {
    //private String source;
    //private List<CryptoCurrency> rates;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
