package pl.szczyrba.crypto.service;

import org.springframework.web.client.RestTemplate;
import pl.szczyrba.crypto.model.Pair;
import pl.szczyrba.crypto.model.Rate;

public class BinanceRestService {

    public static PairsService getAllPairs() {
        // didn't find how to get pairs for specific coin, so I have to get all existing pairs on Binance exchange. Hurts a lot.
        //TODO: this PairService class doesn't make sense. Try to return just a List<Pair> or even List<String>
        return new RestTemplate().getForObject("https://api.binance.com/api/v1/exchangeInfo", PairsService.class);
    }

    public static Rate getRate(String symbol) {
        String url = "https://api.binance.com/api/v3/avgPrice?symbol=" + symbol;
        return new RestTemplate().getForObject(url, Rate.class);
    }
}
