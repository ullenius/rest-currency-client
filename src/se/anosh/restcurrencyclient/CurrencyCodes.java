/**
 *
 * This file defines the permissible currency codes
 * accepted by the REST-service
 *
 * The codes are defined in ISO 4217
 *
 *
 */
package se.anosh.restcurrencyclient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */

public final class CurrencyCodes {
    
    private static List<String> currencyCodes = null;
    private static final String[] codes = {"EUR",
        "HRK",
        "CHF",
        "MXN",
        "ZAR",
        "INR",
        "CNY",
        "THB",
        "AUD",
        "KRW",
        "ILS",
        "JPY",
        "PLN",
        "GBP",
        "IDR",
        "HUF",
        "PHP",
        "TRY",
        "RUB",
        "HKD",
        "ISK",
        "DKK",
        "CAD",
        "USD",
        "MYR",
        "BGN",
        "NOK",
        "RON",
        "SGD",
        "CZK",
        "SEK",
        "NZD",
        "BRL"};
    
    private CurrencyCodes() {
        throw new AssertionError(); // exits only to prevent instantiation
    }
    
    /**
     * 
     * Returns an umodifiable List
     * @return 
     */
    public static List<String> getAllCodes() {
        
        if (currencyCodes == null) {
            currencyCodes = new ArrayList<>();
            currencyCodes.addAll(Arrays.asList(codes));
        }
        return Collections.unmodifiableList(currencyCodes);
    }
}