/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.AdsManagement;

import java.util.ArrayList;
import java.util.List;
import market.MarketModel.Market;
import market.OrderManagement.OrderItem;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */
public class Bundle implements Comparable<Bundle>{
    private List<Product> products;
    private int price;
    private float discount;
    private List<OrderItem> orderItems;
    private long revenues;
    
    public Bundle(float discount) {
        this.products = new ArrayList<>();
        this.price = 0;
        this.discount = discount;
        this.orderItems = new ArrayList<>();
        this.revenues = 0;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    
    public void addProduct(Product p){
        products.add(p);
        this.price += p.getPrice();        
    }
    
    public void removeProduct(Product p){
        products.remove(p);
        this.price -= p.getPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Product p: this.products) {
            sb.append(p.getName()).append('*');
        }
        sb.append("    Price: ").append(price);
        return sb.toString();
    }
    public String toString(Market m) {
        StringBuilder sb = new StringBuilder();
        for(Product p: this.products) {
            sb.append(p.getName()).append('*');
        }
        sb.append("    Price: ").append((int)(price*m.getDiscount()));
        return sb.toString();
    }
    
    public void addOrderItem(OrderItem oi) {
        this.orderItems.add(oi);
        this.revenues += oi.getActualPrice();
    }
    
    public long getRevenues() {
        return this.revenues;
    }
    
    @Override
    public int compareTo(Bundle b) {
        if (this.revenues < b.getRevenues()) {
            return 1;
        }
        else if (this.revenues > b.getRevenues()) {
            return -1;
        }
        return 0;
    }
    
}
