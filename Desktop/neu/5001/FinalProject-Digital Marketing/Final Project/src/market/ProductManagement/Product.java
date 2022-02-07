/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.ProductManagement;

import market.OrderManagement.OrderItem;
import java.util.ArrayList;
import market.MarketModel.Market;

/**
 *
 * @author jojo
 */
public class Product implements Comparable<Product>{
    private String name;
    private int price;
    private ArrayList<OrderItem> orderItems;
    private long revenues;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
        this.orderItems = new ArrayList<>();
        this.revenues = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void addOrderItem(OrderItem oi){
        orderItems.add(oi);
        revenues += oi.getActualPrice();
    }
    // price before discount;
    @Override
    public String toString(){
        return "Product Name: "+this.name +"    Price:" +this.price;  
    }
    // price with market discount;
   public String toString(Market m){
        return "Product Name: "+this.name +"     Price:" +(int)(this.price*m.getDiscount());  
    } 
  
    @Override
    public int compareTo(Product p) {
        if (this.revenues < p.getRevenues()) {
            return 1;
        }
        else if(this.revenues > p.getRevenues()) {
            return -1;
        }
        return 0;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public long getRevenues() {
        return revenues;
    }
    
}
