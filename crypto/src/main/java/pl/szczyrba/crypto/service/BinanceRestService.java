package pl.szczyrba.crypto.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;
import pl.szczyrba.crypto.model.binancepairs.PairList;
import pl.szczyrba.crypto.model.Rate;

public class BinanceRestService {

    @Cacheable("allBinancePairs") //TODO: caching not working
    public static PairList getAllPairs() {
        // didn't find how to get pairs for specific coin, so I have to get all existing pairs on Binance exchange. Hurts a lot.
        return new RestTemplate().getForObject("https://api.binance.com/api/v1/exchangeInfo", PairList.class);
    }

    public static Rate getRate(String symbol) {
        String url = "https://api.binance.com/api/v3/avgPrice?symbol=" + symbol;
        return new RestTemplate().getForObject(url, Rate.class);
    }
}
