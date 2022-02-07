/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.OrderManagement;

import market.MarketModel.Market;
import market.MarketModel.Channel;
import market.CustomerManagement.Customer;
import java.util.ArrayList;

/**
 *
 * @author jojo
 */
public class Order {
    private ArrayList<OrderItem> orderItems;
    private Customer customer;
    private Channel channel;
    private Market market;
    private int totalPrice;
    
    public Order(Customer customer, Channel channel, Market market) {
        this.customer = customer;
        this.channel = channel;
        this.market = market;
        this.orderItems = new ArrayList<>();
        this.totalPrice= 0;
    }

    public void addOrderItem(OrderItem oi) {
        orderItems.add(oi);
        this.totalPrice += oi.getActualPrice();
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Channel getChannel() {
        return channel;
    }

    public Market getMarket() {
        return market;
    }

    public int getTotal() {
        return totalPrice;
    }
    
}

