/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.ProductManagement;

import java.util.ArrayList;
import java.util.List;
import market.MarketModel.Channel;
import market.MarketModel.Market;
import market.MarketModel.MarketCatalog;

/**
 *
 * @author jojo
 */
public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        products= new ArrayList<>();
    }
    
    
    
    public void addProduct(Product p, MarketCatalog mc ){
        products.add(p);
        
        for(Market m: mc.getMarkets()){
            for(Channel c: m.getChannels()){
                c.getProducts().add(p);
            }
            
        }
        
    }

    public List<Product> getProducts() {
        return products;
    }
    

    public Product getProduct(int id){
        return products.get(id);
    }
   
}
