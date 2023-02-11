package pl.szczyrba.crypto.controller;

import org.springframework.web.bind.annotation.*;
import pl.szczyrba.crypto.model.exchange.Exchange;
import pl.szczyrba.crypto.service.ExchangeService;
import pl.szczyrba.crypto.service.RateService;

@RestController
@RequestMapping("/currencies")
public class CryptoCurrenciesController {

    //TODO: Errors handling, work on app logic and structure

    /* for some reason Tomcat doesn't allow [] signs in requests due to some security reason
    for know I decided to ignore this problem by deleting [] from request params
    example: /currencies/BTC?filter=USDT&filter=ETH */
    @GetMapping("/{currency}")
    public String getCurrenciesRate(@PathVariable String currency, @RequestParam(value = "filter", required = false) String[] filters) {
        return new RateService(currency, filters).getCurrencyRates();
    }


    //given request body gave me an error in postman. I changed the body to:
    //{
    //    "from":"currencyA",
    //    "to":[
    //            "currencyB",
    //            "currencyC"
    //        ],
    //    "amount":121
    //}
    @PostMapping("/exchange")
    public String exchangeCurrencies(@RequestBody Exchange exchangeData) {
        return new ExchangeService(exchangeData).exchangeCurrencies();
    }

    @PostMapping("/exchange")
    public String exchangeCurrencies(@RequestBody Exchange exchangeData) {
        return new ExchangeService(exchangeData).getCurrencyRates();
    }
}
