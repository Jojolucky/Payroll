/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.MarketModel;

import java.util.ArrayList;
import java.util.List;
import market.AdsManagement.Ads;
import market.OrderManagement.Order;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */
public class Channel implements Comparable<Channel>{
    private String channel;
    private List<Ads> ads;
    private List<Product> products;
    private List<Order> orders;
    private long revenues;
    public Channel(String channel) {
        this.channel = channel;
        this.ads = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.revenues = 0;
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void addAds(Ads ad){
        ads.add(ad);
        
    }
    public List<Ads> getAds(){
        return ads;
    }
    
    public Product getProduct(int id) {
        return this.products.get(id);
    }
    
    public Ads getAd(int id) {
        return ads.get(id);
    }

    public List<Order> getOrders() {
        return orders;
    }
    
    public void addOrder(Order o) {
        this.orders.add(o);
        this.revenues += o.getTotal();
    }
    
    public long getRevenues() {
        return this.revenues;
    }
    
    @Override
    public int compareTo(Channel ad) {
        if (this.revenues < ad.getRevenues()) {
            return 1;
        }
        else if (this.revenues > ad.getRevenues()) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return this.channel + "    Total Sales Revenues: " + this.revenues;
    }
    
}
