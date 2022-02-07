/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.Scanner;
import market.AdsManagement.Ads;
import market.AdsManagement.Bundle;
import market.CustomerManagement.Customer;
import market.CustomerManagement.Customer.CustomerType;
import market.MarketModel.Channel;
import market.MarketModel.Market;
import market.MarketModel.MarketCatalog;
import market.ProductManagement.Product;
import market.ProductManagement.ProductCatalog;

/**
 *
 * @author jojo
 */
public class AppleMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create two markets in the market catalog;
        MarketCatalog mc = new MarketCatalog();
        Market USMarket = new Market("USMarket", 0.98f);
        mc.addMarket(USMarket);
        Market CNMarket = new Market("CNMarket", 1);
        mc.addMarket(CNMarket);

        //create three channels for each market;
        Channel amz = new Channel("Amazon");
        USMarket.addChannel(amz);
        Channel Apple = new Channel("Apple");
        USMarket.addChannel(Apple);
        Channel Bbuy = new Channel("Best Buy");
        USMarket.addChannel(Bbuy);
        Channel AppleCN = new Channel("AppleCN");
        CNMarket.addChannel(AppleCN);
        Channel Jingdong = new Channel("Jingdong");
        CNMarket.addChannel(Jingdong);
        Channel Taobao = new Channel("Taobao");
        CNMarket.addChannel(Taobao);

        //create six products in the product catalog;
        ProductCatalog pc = new ProductCatalog();
        pc.addProduct(new Product("MacBook", 1299), mc);  //0
        pc.addProduct(new Product("iPhone", 829), mc);  //1
        pc.addProduct(new Product("AirPods", 179), mc);  //2
        pc.addProduct(new Product("iPad", 329), mc);  //3
        pc.addProduct(new Product("HomePod", 99), mc);  //4
        pc.addProduct(new Product("Apple Gift Card", 100), mc);  //5

        //create two ads and three bundles; ads1 contains two bundles, ads2 contains one bundle;
        Ads ads1 = new Ads("Gift for your new semester!");
        Ads ads2 = new Ads("New colorful sound!");
        Bundle bundle1 = new Bundle(0.9f);
        Bundle bundle2 = new Bundle(0.94f);
        Bundle bundle3 = new Bundle(0.95f);
        ads1.addBundle(bundle1);
        ads1.addBundle(bundle2);
        ads2.addBundle(bundle3);
        bundle1.addProduct(pc.getProduct(0));
        bundle1.addProduct(pc.getProduct(1));
        bundle1.addProduct(pc.getProduct(2));
        bundle1.addProduct(pc.getProduct(3));
        bundle2.addProduct(pc.getProduct(0));
        bundle2.addProduct(pc.getProduct(4));
        bundle3.addProduct(pc.getProduct(1));
        bundle3.addProduct(pc.getProduct(2));

        //put all ads into all channels;
        amz.addAds(ads1);
        Apple.addAds(ads1);
        Bbuy.addAds(ads1);
        AppleCN.addAds(ads1);
        Jingdong.addAds(ads1);
        Taobao.addAds(ads1);

        amz.addAds(ads2);
        Apple.addAds(ads2);
        Bbuy.addAds(ads2);
        AppleCN.addAds(ads2);
        Jingdong.addAds(ads2);
        Taobao.addAds(ads2);

        // create 3 customers of different type and make 3 orders
        Customer c1 = new Customer("Jack", "jack@gmail.com", USMarket, Apple, CustomerType.STUDENT);
        c1.addBundleToOrderCart(bundle3);
        c1.addProductToOrderCart(pc.getProduct(0));
        c1.makeNewOrder();

        Customer c2 = new Customer("Jojo", "jojo@gmail.com", CNMarket, AppleCN, CustomerType.DENTIST);
        c2.addBundleToOrderCart(bundle2);
        c2.addProductToOrderCart(pc.getProduct(4));
        c2.makeNewOrder();

        Customer c3 = new Customer("Jemmy", "jemmy@gmail.com", USMarket, amz, CustomerType.TEACHER);
        c3.addBundleToOrderCart(bundle1);
        c3.addProductToOrderCart(pc.getProduct(5));
        c3.makeNewOrder();

        //use scanner to interact with customers or managers.  
        //They can choose those operations by typing index;
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("******* Welcome to Apple products *******");
            System.out.println("Please enter your identity ");
            System.out.println(" Type 0: for Manager ");
            System.out.println(" Type 1: for Customer");
            System.out.println(" Type -1: Exit");
            System.out.println("**************************************");
            try {
                int isCustomer = Integer.parseInt(scn.nextLine());  //transfer string into integer;
                if (isCustomer == 1) {
                    CustomerOperations.customerRelated(scn, mc);
                } else if (isCustomer == 0) {
                    ManagerOperations.managerRelated(scn, mc, pc);
                } else if (isCustomer == -1) {
                    break;
                } else {
                    System.out.println("Please Input 0, 1, -1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Select Manager/Customer/Exit Input Error!");
            }
        }

    }

}
