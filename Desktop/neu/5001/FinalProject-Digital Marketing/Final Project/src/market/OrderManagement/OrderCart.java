/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.OrderManagement;

import java.util.ArrayList;
import java.util.List;
import market.AdsManagement.Bundle;
import market.CustomerManagement.Customer;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */
public class OrderCart {
    private List<Bundle> bundles;
    private List<Product> products;
    private int totalPrice;
    private Customer customer;
   public OrderCart(Customer customer) {
        this.bundles = new ArrayList<>();
        this.products = new ArrayList<>();
        this.totalPrice = 0;
        this.customer = customer;
    }

    public List<Bundle> getBundles() {
        return bundles;
    }
   
    public List<Product> getProducts() {
        return products;
    }
    
    public void addBundle(Bundle b){
        bundles.add(b);
        totalPrice+=b.getPrice() * b.getDiscount();
    }
    
    public void addProduct(Product p){
        products.add(p);
        totalPrice+=p.getPrice();
    }
    
    public void removeBundle(int id) {
        Bundle b = bundles.get(id);
        totalPrice -= b.getPrice() * b.getDiscount();
        bundles.remove(b);
    }
    
    public void removeProduct(int id) {
        totalPrice -= products.get(id).getPrice();
        products.remove(id);
    }
    
    public void removeAll() {
        this.bundles.clear();
        this.products.clear();
        this.totalPrice = 0;
    }

    public int getTotal() {
        return (int)(totalPrice * customer.getCustomertype().getDiscount()*customer.getMarket().getDiscount());
    }

    public Customer getCustomer() {
        return customer;
    }
    
    
}
