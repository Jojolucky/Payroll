/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.CustomerManagement;

import java.util.ArrayList;
import java.util.List;
import market.AdsManagement.Bundle;
import market.MarketModel.Channel;
import market.MarketModel.Market;
import market.OrderManagement.Order;
import market.OrderManagement.OrderCart;
import market.OrderManagement.OrderItem;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */

public class Customer {
    private String name;
    private String email;
    private Market market;
    private Channel channel;
    private CustomerType customertype;
    private List<Order> orderList;
    private OrderCart orderCart;

    

    public enum CustomerType{
        STUDENT{
            @Override
            public float getDiscount(){
                return 0.85f;
            }
        },
        DENTIST{
            @Override
            public float getDiscount(){
                return 0.95f;
            }
        },
        TEACHER{
            @Override
            public float getDiscount(){
                return 0.9f;
            }
        },
        OTHERS{
            @Override
            public float getDiscount(){
                return 1;
            }
        };
        abstract public float getDiscount();
    }
    
    public Customer() {
        this.orderCart = new OrderCart(this);
        this.customertype = CustomerType.OTHERS;
        this.orderList = new ArrayList<>();
    }

    
    public Customer(String name, String email,Market market, 
            Channel channel, CustomerType customertype) {
        this.name = name;
        this.email = email;
        this.market = market;
        this.channel = channel;
        this.customertype = customertype;
        this.orderCart = new OrderCart(this);
        this.orderList = new ArrayList<>();
    }
    
     
    public boolean makeNewOrder(){
        if (orderCart.getProducts().isEmpty() && orderCart.getBundles().isEmpty())
            return false;
        Order order= new Order(this,this.channel,this.market);
        for(Product p: orderCart.getProducts()){
            
            OrderItem oi = new OrderItem(p, (int)(p.getPrice()*this.customertype.getDiscount()*this.market.getDiscount()), this.market, this.channel);
            p.addOrderItem(oi);
            order.addOrderItem(oi);
            
        }
        
        for (Bundle b: orderCart.getBundles()) {
            for (Product p: b.getProducts()) {
                OrderItem oi = new OrderItem(p, (int)(p.getPrice()*this.customertype.getDiscount()*b.getDiscount()*this.market.getDiscount()), 
                        this.market, this.channel);
                p.addOrderItem(oi);
                order.addOrderItem(oi);
                b.addOrderItem(oi);
            }
            
        }
        this.market.addOrder(order);
        this.channel.addOrder(order);
        
        this.orderList.add(order);
        this.orderCart.removeAll();
        return true;
    }
    
    public void addProductToOrderCart(Product p){
        orderCart.addProduct(p);
    }
    
    public void addBundleToOrderCart(Bundle b){
        orderCart.addBundle(b);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public CustomerType getCustomertype() {
        return customertype;
    }

    public void setCustomertype(CustomerType customertype) {
        this.customertype = customertype;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public OrderCart getOrderCart() {
        return orderCart;
    }

    public void setOrderCart(OrderCart orderCart) {
        this.orderCart = orderCart;
    }
    
    

}
