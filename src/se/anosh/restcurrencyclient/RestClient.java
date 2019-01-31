 /**
  *
  * ITHS 2019 Rest client exercise
  *
  * Obtains currency exchange rates in JSON from server using
  * REST and stores them as a POJO (plain old java object)
  * 
  * Uses: https://exchangeratesapi.io/
  * 
  * Thanks to Madis Väin (EST) for the API :)
  *
  */

package se.anosh.restcurrencyclient;

import se.anosh.restcurrencyclient.domain.ExchangeRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Anosh D. Ullenius <anosh@anosh.se>
 */
public class RestClient {
    
    private String url = "https://api.exchangeratesapi.io/latest";
    
    public static void main(String[] args) {
        
        RestClient client = new RestClient();
        client.run();
    }
    
    private void run() {
        
        System.out.println("RestCurrency - Foreign Exchange rates REST-client\n");
       
        menu(); // user IO
        
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target(url);
        Invocation invocation = target.request("application/JSON").buildGet();
        Response response = invocation.invoke();
        
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
        
        if (response.getStatus() != 200) {
            System.out.println("Network error! Obtained code : " + response.getStatus());
            System.out.println("Exiting program");
            return;
        }

        String result = response.readEntity(String.class);

        //System.out.println(result);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ExchangeRate valuta = gson.fromJson(result, ExchangeRate.class);
        response.close();
        
        System.out.println("Base: " + valuta.getBase());
        System.out.println("Date: " + valuta.getDate());
        
        Map<String,Double> map = new HashMap(valuta.getRates());
        for (String key : map.keySet()) {
            System.out.println(key + "\t" + map.get(key));
        }
        
    }
    
    private void menu() {
        
        Scanner sc = new Scanner(System.in);
        int input = 1;
        final List<String> codes = CurrencyCodes.getAllCodes();
        final int size = codes.size();
        
        System.out.println("Menu");
        System.out.println("1. Use € Euro as base currency");
        System.out.println("2. Choose different base currency");
        
        // Prints the list
        for (int i = 0; i < codes.size(); i++) {
            System.out.println((i+1) + "\t" + codes.get(i));
        }
        
        do {
            System.out.println("\nPlease make your selection: ");
            input = sc.nextInt();
        } while (input > size || input < 1);
        
        if (input != 1)
            url = url.concat("?base=" + codes.get(input-1));
        sc.close(); // closes Scanner
    }
    
    
}
