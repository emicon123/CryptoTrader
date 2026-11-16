# CryptoTrader

A small Spring Boot REST API written as a recruitment task (2022): it reads live market data from
the public Binance API and exposes crypto exchange-rate lookups and a currency-exchange
calculator.

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/currencies/{currency}?filter=USDT&filter=ETH` | Average prices of `{currency}` against every quote asset Binance lists, optionally limited to the given `filter` symbols. |
| `POST` | `/currencies/exchange` | Converts an amount from one currency into several others, returning the rate, the amount, the result and a 1% exchange fee for each target. |

Example request body for `/currencies/exchange`:

```json
{
  "from": "BTC",
  "to": ["USDT", "ETH"],
  "amount": 1.5
}
```

## How it works

- `BinanceRestService` calls `GET /api/v1/exchangeInfo` for the list of trading pairs and
  `GET /api/v3/avgPrice` for each pair's average price (no API key needed).
- `RateService` filters the pairs by base and quote symbol (exact matching, because symbols such
  as `BULLUSDT` would break a suffix match).
- `ExchangeService` computes the converted amount and the fee for each requested target.

## Tech stack

Java 17, Spring Boot 2.6 (Web), `RestTemplate`, Java records, Maven wrapper.

## Running

```bash
cd crypto
./mvnw spring-boot:run      # http://localhost:8081
```
