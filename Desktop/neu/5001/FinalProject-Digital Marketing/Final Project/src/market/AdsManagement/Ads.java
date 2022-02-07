/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.AdsManagement;

import java.util.ArrayList;
import java.util.List;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */
public class Ads{
    private List<Bundle> bundles;
    private List<Product> products;
    private String description;
    
    public Ads(String description) {
        this.description = description;
        this.bundles = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public List<Bundle> getBundles() {
        return bundles;
    }
   
    public List<Product> getProducts() {
        return products;
    }
    
    public Bundle getBuddle(int id) {
        return bundles.get(id);
    }
    
    public Product getProduct(int id) {
        return products.get(id);
    }
    
    public void addBundle(Bundle b){
        bundles.add(b);
    }
    
    public void addProduct(Product p){
        products.add(p);
    }
    
    @Override
    public String toString(){
        return this.description;
    }
    
}
