/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.MarketModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojo
 */
public class MarketCatalog {
    private List<Market> markets;

    public MarketCatalog() {
        this.markets = new ArrayList<>();
    }

    public List<Market> getMarkets() {
        return markets;
    }
    
    public void addMarket(Market m){
        markets.add(m);
        
    }
    
    public Market getMarket(int id) {
        return markets.get(id);
    }
}
