/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing;

import com.github.javafaker.Faker;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.OrderManagement.MasterOrderList;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.Personnel.Person;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.ProductManagement.ProductSummary;
import digitalmarketing.ProductManagement.ProductsReport;
import digitalmarketing.Supplier.Supplier;
import digitalmarketing.Supplier.SupplierDirectory;
import java.util.Scanner;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("***************************************");
        System.out.println("1(a): Business - 1");
        Business walmart = new Business("Walmart Inc.");
        walmart.printTitle();

        DataLoader dataLoader = new DataLoader();
        dataLoader.populateBusiness(walmart);

        // cd.printCustomerNames();
        Supplier secondSupplier = walmart.getSupplierDirectory().findSupplierByIndex(1);

        ProductCatalog pc = secondSupplier.getProductcatalog();

        pc.newProduct(1, 1, 1, "asa");
        pc.newProduct(2, 1, 1, "bbn31d2");
        pc.newProduct(3, 1, 1, "cvvdsd3");
        pc.newProduct(4, 1, 1, "zzzadsas4");
        pc.newProduct(5, 1, 1, "xxxdas5");
        pc.newProduct(6, 1, 1, "yyy11126");

        // pc.printDetails();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please choose [1, 2, 3]: ");
//        int choice = sc.nextInt();
//        
//        System.out.println("You picked " + choice);
//        
    }

}
