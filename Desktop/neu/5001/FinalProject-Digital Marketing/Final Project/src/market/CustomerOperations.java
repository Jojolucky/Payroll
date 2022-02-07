/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package market;

import java.util.List;
import java.util.Scanner;
import market.AdsManagement.Ads;
import market.AdsManagement.Bundle;
import market.CustomerManagement.Customer;
import market.CustomerManagement.Customer.CustomerType;
import market.Email.EmailSection;
import market.MarketModel.Channel;
import market.MarketModel.Market;
import market.MarketModel.MarketCatalog;
import market.OrderManagement.Order;
import market.OrderManagement.OrderCart;
import market.OrderManagement.OrderItem;
import market.ProductManagement.Product;

/**
 *
 * @author jojo
 */
public class CustomerOperations {
    public static void viewAds(Ads ad, Scanner scn, Customer customer) {
        while(true) {
            System.out.println("**************************************");
            System.out.println("All Bundles and Products available for you, type the index you prefer.");
            System.out.println("******* Bundles *******");
            int bid=1;
            for(Bundle b: ad.getBundles()){
                System.out.println("Type "+bid+": "+b.toString(customer.getMarket()));
                bid++;
            }
            System.out.println("******* Products *******");
            int pid = bid;
            for(Product p: ad.getProducts()){
                System.out.println("Type "+pid+ ": "+ p.toString(customer.getMarket()));
                pid++;
            }
            System.out.println("The total price of your shopping cart is: " + 
                    customer.getOrderCart().getTotal());
            System.out.println("Type -1: Back to previous page.");
            try {
                int selectedItem = Integer.parseInt(scn.nextLine());
                if (selectedItem == -1 ) {
                    break;
                }
                else if (selectedItem < bid) {
                    customer.addBundleToOrderCart(ad.getBuddle(selectedItem-1));
                }
                else {
                    customer.addProductToOrderCart(ad.getProduct(selectedItem-bid));
                }
                
            }
            catch(NumberFormatException e) {
                System.out.println("INPUT Should be Integer!");
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
        }
    }
    
    public static void showCart(Scanner scn, OrderCart cart){
        while (true) {
            System.out.println("**************************************");
            System.out.println("This is your shopping cart.");
            System.out.println("As " + cart.getCustomer().getCustomertype() + 
                    ", the total price of your shopping cart is: " + cart.getTotal());
            int bid = 1;
            for(Bundle b: cart.getBundles()){
                System.out.println("Type "+bid+ ": " + b.toString(cart.getCustomer().getMarket()));
                bid++;
            }
            int pid = bid;
            for(Product p: cart.getProducts()){
                System.out.println("Type "+pid + ": " + p.toString(cart.getCustomer().getMarket()));
                pid++;
            }
            
            System.out.println("To remove item please select item index.");
            System.out.println("Type -1: To exit");
            try {
                int selectedItem = Integer.parseInt(scn.nextLine());
                if (selectedItem == -1) {
                    break;
                }
                else if(selectedItem < bid) {
                    cart.removeBundle(selectedItem-1);
                }
                else {
                    cart.removeProduct(selectedItem-bid);
                }
            }
            catch(NumberFormatException e) {
                System.out.println("INPUT Should be Integer!");
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
        }
    }
    
    public static void checkout(Customer customer) {
        if (customer.makeNewOrder())
            System.out.println("Successfully checkout!");
        else
            System.out.println("No items in Cart!");
    }
    
    public static void showOrderHistory(Scanner scn, Customer customer) {
        while (true) {
            List<Order> orders = customer.getOrderList();
            System.out.println("******* Order History *******");
            int orderid = 1;
            for (Order order: orders) {
                System.out.println("******* Order " + orderid +" *******");
                for(OrderItem oi: order.getOrderItems()) {
                    System.out.println(oi);
                }
                orderid++;
            } 
            System.out.println("Type -1: To exit");
            System.out.println("**************************************");
            if (scn.nextLine().equals("-1"))
                break;
        }
        
    }
    
    public static void viewItems(Channel selectedChannel, Scanner scn, Customer customer) {
        while(true) {
            System.out.println("**************************************");
            System.out.println("All Ads and Products available for you, type the index you prefer.");
            System.out.println("******* Ads *******");
            int aid=1;
            for(Ads a: selectedChannel.getAds()){
                System.out.println("Type "+aid+": "+a);
                aid++;
            }
            
            System.out.println("******* Products *******");
            int pid = aid;
            for(Product p: selectedChannel.getProducts()){
                System.out.println("Type "+pid+ ": "+ p.toString(customer.getMarket())); 
                pid++;
            }
            
            System.out.println("The total price of your shopping cart is: " + 
                customer.getOrderCart().getTotal());
            System.out.println("******* Please Input the index below *******");
            System.out.println("Type -4: Show your order history");
            System.out.println("Type -3: Show your cart details");
            System.out.println("Type -2: To Proceed to Checkout");
            System.out.println("Type -1: To Exit");
            System.out.println("**************************************");
            try {
                int selectedItem = Integer.parseInt(scn.nextLine());
                if (selectedItem == -1)
                    break;
                else if (selectedItem == -2) {
                    checkout(customer);
                }
                else if (selectedItem == -3) {
                    showCart(scn, customer.getOrderCart());
                }
                else if (selectedItem == -4) {
                    showOrderHistory(scn, customer);
                }
                else if (selectedItem < aid) {
                    viewAds(selectedChannel.getAd(selectedItem-1),scn,customer);
                }
                else {
                    customer.addProductToOrderCart(selectedChannel.getProduct(selectedItem-aid));
                }
            }
            catch(NumberFormatException e) {
                 System.out.println("INPUT Should be Integer!");
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
        }
    }
    
    public static Market selectMarket(MarketCatalog mc, Scanner scn, Customer customer) { 
        while(true) {
            System.out.println("Which Market do you want to choose?");
            System.out.println("******* Input Market index *******");
            int mid = 1;
            for(Market m: mc.getMarkets()){
                System.out.println("Type "+mid +": "+ m.getMarket());
                mid++;
            }
            System.out.println("**************************************"); 
            try {
                Market selectedMarket = mc.getMarket(Integer.parseInt(scn.nextLine())-1);  //-1 because the mid starts with 1;
                System.out.println("You have selected " + selectedMarket.getMarket());    //return the name of market;
                customer.setMarket(selectedMarket);
                return selectedMarket;
            }
            catch(NumberFormatException e) {
                 System.out.println("INPUT Should be Integer!");
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
             
        }
        
    }
    
    public static Channel selectChannel(Market selectedMarket, Scanner scn, Customer customer) { 
        while(true) {
            System.out.println("Which Channel do you want to choose?");
            System.out.println("******* Input Channel index *******");
            int cid=1;
            for(Channel c: selectedMarket.getChannels()){
                System.out.println("Type "+cid+": "+ c.getChannel());
                cid++;
            }
            System.out.println("**************************************");
            try {
                Channel selectedChannel = selectedMarket.getChannel(Integer.parseInt(scn.nextLine())-1); 
                System.out.println("You have selected " + selectedChannel.getChannel());
                customer.setChannel(selectedChannel);
                return selectedChannel;
            }
            catch(NumberFormatException e) {
                 System.out.println("INPUT Should be Integer!");
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
        }
    }
    
    public static void selectCustomerType(Scanner scn, Customer customer) {
        while(true) {
            System.out.println("******* Input Customer Type index *******");
            int ctid = 1;
            for (CustomerType ct: CustomerType.values()) {
                System.out.println("Type "+ctid + ": "+ ct);
                ctid++;
            }
            System.out.println("**************************************");
            try {
                int selectedCustomerType = Integer.parseInt(scn.nextLine());
                customer.setCustomertype(CustomerType.values()[selectedCustomerType-1]);
                break;
            }
            catch(NumberFormatException e) {
                 System.out.println("INPUT Should be Integer!");
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
        }
    }
    
    private static void verifyEmail(Scanner scn, Customer customer) {
        EmailSection emailOP = new EmailSection();
        String emailaddress = "";
        while(true) {
            System.out.println("**************************************");
            System.out.println("Please provide email address.");
            emailaddress = scn.nextLine();
            try {
                emailOP.sendEmail(emailaddress);
                break;
            }   
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Email sending fails!");
            }
                
        }
        while(true) {
            System.out.println("The verify code has been sent, please input below.");
            System.out.println("**************************************");
            String verifyCode = scn.nextLine();
            if(!verifyCode.equals(emailOP.getConfirmCode())){
                System.out.println("Verify code is not correct!");
            }
            else {
                System.out.println("Verify Success!");
                customer.setEmail(emailaddress);
                break;
            }
        }    
    }
    
    public static void customerRelated(Scanner scn, MarketCatalog mc) {
        
        Customer customer= new Customer();
        
        //customer select market
        Market selectedMarket = selectMarket(mc,scn,customer);
        //customer select type
        selectCustomerType(scn, customer);
        //customer select channel
        Channel selectedChannel = selectChannel(selectedMarket,scn,customer);
        //customer set email
        verifyEmail(scn, customer);
        //add items into cart and checkout
        viewItems(selectedChannel,scn,customer);
    }
    
    
}
