/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import market.AdsManagement.Ads;
import market.AdsManagement.Bundle;
import market.MarketModel.Channel;
import market.MarketModel.Market;
import market.MarketModel.MarketCatalog;
import market.ProductManagement.Product;
import market.ProductManagement.ProductCatalog;

/**
 *
 * @author jojo
 */
public class ManagerOperations {

    public static void revenuesByMarket(MarketCatalog mc, ProductCatalog pc) {
        System.out.println("**** Top Market by sales revenues ****");
        List<Market> markets = mc.getMarkets();
        Collections.sort(markets);
        for (Market m : markets) {
            System.out.println("Market: " + m);
        }
    }

    public static void revenuesByChannel(MarketCatalog mc, ProductCatalog pc) {

        for (Market m : mc.getMarkets()) {
            System.out.println("*******" + m.getMarket() + "*******");
            System.out.println("**** Top Channel by sales revenues ****");
            List<Channel> channels = new ArrayList<>();
            for (Channel c : m.getChannels()) {
                channels.add(c);
            }
            Collections.sort(channels);
            for (Channel c : channels) {
                System.out.println("Channel: " + c);
            }
        }

    }

    public static void revenuesByBundle(MarketCatalog mc, ProductCatalog pc) {
        Set<Bundle> bundles = new HashSet<>();
        System.out.println("**** Top Bundles by sales revenues ****");
        for (Market m : mc.getMarkets()) {
            for (Channel c : m.getChannels()) {
                for (Ads ad : c.getAds()) {
                    for (Bundle b : ad.getBundles()) {
                        bundles.add(b);
                    }
                }
            }

        }
        List<Bundle> bundleList= new ArrayList<>(bundles);
        Collections.sort(bundleList);
        for (Bundle b : bundleList) {
            System.out.println("**************************************");
            System.out.println("Bundle Details: " + b);
            System.out.println("Sales Revenues: " + b.getRevenues());
        }
    }

    public static void revenuesByProduct(ProductCatalog pc) {
        System.out.println("**** Top Products by sales revenues ****");
        List<Product> products = pc.getProducts();
        Collections.sort(products);
        for (Product p : products) {
            System.out.println("**************************************");
            System.out.println(p);
            System.out.println("Sales Revenues: " + p.getRevenues());
        }
    }

    public static void manageSalesRevenues(Scanner scn, MarketCatalog mc, ProductCatalog pc) {
        OUTER:
        while (true) {
            System.out.println("*********** Operation List ***********");
            System.out.println("Type 1: Check by Market");
            System.out.println("Type 2: Check by Channel");
            System.out.println("Type 3: Check by Bundle");
            System.out.println("Type 4: Check by Product");
            System.out.println("Type -1: To Exit");
            System.out.println("**************************************");
            try {
                int type = Integer.parseInt(scn.nextLine());
                switch (type) {
                    case -1:
                        break OUTER;
                    case 1:
                        revenuesByMarket(mc, pc);
                        break;
                    case 2:
                        revenuesByChannel(mc, pc);
                        break;
                    case 3:
                        revenuesByBundle(mc, pc);
                        break;
                    case 4:
                        revenuesByProduct(pc);
                        break;
                    default:
                        System.out.println("INPUT Should be Integer!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, INPUT out of bounds!");
            }
        }
    }

    public static void managerRelated(Scanner scn, MarketCatalog mc, ProductCatalog pc) {
        OUTER:
        while (true) {
            System.out.println("********* Manager Operation *********");
            System.out.println("Which operation do you want to do?");
            System.out.println("Type 1: Manage Sales Revenues");
            System.out.println("Type -1: Exit");
            System.out.println("**************************************");
            try {
                int op = Integer.parseInt(scn.nextLine());
                switch (op) {
                    case -1:
                        break OUTER;
                //to do: add more
                    case 1:
                        manageSalesRevenues(scn, mc, pc);
                        break;
                    default:
                        System.out.println("**************************************");
                        System.out.println("Sorry, INPUT out of bounds!");
                        break;
                }
            }catch (NumberFormatException e) {
                System.out.println("**************************************");
                System.out.println("INPUT Should be Integer!");
            }
        }
    }
}
