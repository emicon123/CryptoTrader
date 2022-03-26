package pl.szczyrba.crypto.controller;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import pl.szczyrba.crypto.model.Pair;
import pl.szczyrba.crypto.model.Record;
import pl.szczyrba.crypto.service.BinanceRestService;
import pl.szczyrba.crypto.service.PairsService;
import pl.szczyrba.crypto.model.Rate;

import java.util.*;

@RestController("/currencies")
public class RestSpringBootController {

    //TODO: clean the code. Put it to methods, make some classess for this code. Errors handling

    /* for some reason Tomcat doesn't allow [] signs in requests due to some security reason
    for know I decided to ignore this problem by deleting [] from request params
    example: /currencies/BTC?filter=USDT&filter=ETH */
    @GetMapping("/currencies/{currency}") //TODO: for sure I can get rid of /currencies here somehow
    public String getCurrenciesRate(@PathVariable String currency, @RequestParam(value = "filter", required = false) String[] filters) {

        List<Pair> selectedPairs = BinanceRestService.getAllPairs().getSymbols().stream()
                .filter(e -> e.getSymbol().startsWith(currency))
                .toList();

        if(filters != null) {
            selectedPairs = selectedPairs.stream()
                    .filter(e -> Arrays.stream(filters).toList().stream().anyMatch(n -> e.getSymbol().equals(currency+n))) //endsWith doesn't work - there are tokens like BULLUSDT, SOMETHINGUSDT
                    .toList();
        }

        Map<String, String> records = new HashMap<>();
        for(Pair pair : selectedPairs) {
            String pairedCurrency = pair.getSymbol().substring(currency.length());
            Rate rate = BinanceRestService.getRate(pair.getSymbol());
            records.put(pairedCurrency, rate.getPrice());
        }

        return new Gson().toJson(new Record(currency, records));
    }

    @PostMapping
    public void postMethod() {

    }
}
