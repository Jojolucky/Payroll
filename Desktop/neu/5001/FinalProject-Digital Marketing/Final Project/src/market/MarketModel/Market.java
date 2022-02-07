/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.MarketModel;

import java.util.ArrayList;
import java.util.List;
import market.OrderManagement.Order;

/**
 *
 * @author jojo
 */
public class Market implements Comparable<Market>{
//    private Ads ads;
    private String market;
    private List<Channel> channels;
    private List<Order> orders;
    private long revenues;
    private float discount;
    
    public Market(String market,float discount) {
        this.market = market;
        this.channels= new ArrayList<>();
        this.orders = new ArrayList<>();
        this.revenues = 0;
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    public List<Channel> getChannels() {
        return channels;
    }
    
    public void addChannel(Channel c){
        channels.add(c);
        
    }
    public Channel getChannel(int id){
        return channels.get(id);
        
    }
        
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
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
    public int compareTo(Market m) {
        if (this.revenues < m.getRevenues()) {
            return 1;
        }
        else if (this.revenues > m.getRevenues()) {
            return -1;
        }
        return 0;
    }
    
    public String toString() {
        return this.market + "    Total Sales Revenues: " + this.revenues;
    }
}
