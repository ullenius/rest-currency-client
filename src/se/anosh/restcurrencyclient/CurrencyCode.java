/**
 *
 * This file defines the permissible currency codes
 * accepted by the REST-service
 *
 * The codes are defined in ISO 4217
 *
 * Enum code by Istvan Devai 2018
 *
 */
package se.anosh.restcurrencyclient;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public enum CurrencyCode {
    
    EUR(1), // € euro is the default base-currency for the REST-server
    AUD(2),
    BGN(3),
    BRL(4),
    CAD(5),
    CHF(6),
    CNY(7),
    CZK(8),
    DKK(9),
    GBP(10),
    HKD(11),
    HRK(12),
    HUF(13),
    IDR(14),
    ILS(15),
    INR(16),
    ISK(17),
    JPY(18),
    KRW(19),
    MXN(20),
    MYR(21),
    NOK(22),
    NZD(23),
    PHP(24),
    PLN(25),
    RON(26),
    RUB(27),
    SEK(28),
    SGD(29),
    THB(30),
    TRY(31),
    USD(32),
    ZAR(33);

    private int code;
     private static final Map<Integer,CurrencyCode> lookup 
          = new HashMap<Integer,CurrencyCode>();

     static {
          for(CurrencyCode w : EnumSet.allOf(CurrencyCode.class))
               lookup.put(w.getCode(), w);
     }

     private CurrencyCode(int code) {
          this.code = code;
     }

     public int getCode() { return code; }

     public static CurrencyCode get(int code) { 
          return lookup.get(code); 
     }
}
