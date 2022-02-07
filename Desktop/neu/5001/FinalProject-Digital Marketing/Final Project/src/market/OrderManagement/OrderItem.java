/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market.OrderManagement;

import market.MarketModel.Channel;
import market.MarketModel.Market;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */
public class OrderItem {
    private Product selectedproduct;
    private int actualPrice;
    private Market market;
    private Channel channel;

    public OrderItem(Product selectedproduct, int actualPrice, Market market, Channel channel) {
        this.selectedproduct = selectedproduct;
        this.actualPrice = actualPrice;
        this.market = market;
        this.channel = channel;
    }
    
    

    public Product getSelectedproduct() {
        return selectedproduct;
    }

    public void setSelectedproduct(Product selectedproduct) {
        this.selectedproduct = selectedproduct;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    
    public String toString() {
        return "Product Name: "+ this.selectedproduct.getName() + "\t" + "Price: "+this.actualPrice + "\t";
                
    }
    
    
}
