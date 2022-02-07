/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalmarketing;

import com.github.javafaker.Faker;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.OrderManagement.OrderItem;
import digitalmarketing.Personnel.Person;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.Supplier.Supplier;
import digitalmarketing.Supplier.SupplierDirectory;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * @author alelashvili
 */
public class DataLoader {

    Faker faker;
    Random random;

    private final int supplierCount = 30;
    private final int supplierPicks = 5;
    private final int productsPerSupplier = 20;
    private final int customerCount = 30;
    private TreeMap<Integer, Integer> hash = new TreeMap<>();
    public Map<String, Integer> map = new HashMap<>();

    public DataLoader() {
        faker = new Faker();
        random = new Random();
    }

    public void populateBusiness(Business b) {
        populateSupplierDirectory(b.getSupplierDirectory(), supplierCount);
        populateCustomerDirectory(b.getCustomerDirectory(), customerCount);

        System.out.println("\n");
        System.out.println("***************************************");
        System.out.println("1(b): Suppliers - 30");
        SupplierDirectory sd = b.getSupplierDirectory();
        sd.printSupplierList();

        System.out.println("\n");
        System.out.println("***************************************");
        System.out.println("1(d): Customers - 30");
        CustomerDirectory cd = b.getCustomerDirectory();
        cd.printCustomerNames();

        System.out.println("\n");
        System.out.println("***************************************");
        System.out.println("1(c): Pick 5 Suppliers and add 20 Products to each!");

        ArrayList<Supplier> supplierPicks = new ArrayList<>();
        int count = 0;

        do {
            int randomIndex = random.nextInt(supplierCount);
            Supplier s = sd.findSupplierByIndex(randomIndex);
            if (!supplierPicks.contains(s)) {
                supplierPicks.add(s);
                this.populateProductCatalog(s.getProductcatalog(), productsPerSupplier);
                count++;
            }
        } while (count < 5);
        for (Supplier s : supplierPicks) {
            s.printSupplierDetails();
        }
        System.out.println("\n");
        System.out.println("***************************************");
        System.out.println("1(e): Pick 5 Customers and add 3 Orders with 5 Items to each!");
        ArrayList<CustomerProfile> customerPicks = new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < 5; i++) {
            int randomC=random.nextInt(30);
            while(set.contains(randomC)){
                randomC=random.nextInt(30);
            }
            set.add(randomC);
            customerPicks.add(CustomerDirectory.customerlist.get(randomC));
        }
        for (CustomerProfile cp : customerPicks) {
            for (int i = 0; i < 3; i++) {
                Order eachOrder = new Order(cp);
                for (int j = 0; j < 5; j++) {
                    Supplier rS = supplierPicks.get(random.nextInt(5));
                    Product p = rS.getProductcatalog().products.get(random.nextInt(20));
                    rS.reSetSaleProductsStatus(p);
                    eachOrder.newOrderItem(p, 1, p.getTargetPrice());
                }
                cp.addCustomerOrder(eachOrder);
            }
        }

        for (CustomerProfile cp : customerPicks) {
            System.out.println("-----------------------");
            System.out.println("Customer：" + cp.getName());

            for (int i = 0; i < cp.getOrders().size(); i++) {
                System.out.println("Current order: " + (i + 1));
                String info = "";

                for (int j = 0; j < 5; j++) {
                    String productName = cp.getOrders().get(i).orderitems.get(j).selectedproduct.getName();
                    info += cp.getOrders().get(i).orderitems.get(j).selectedproduct.getName() + ",";
                    if (hash.containsValue(productName)) {
//                       hash.
                    }
                }
                System.out.println("random product: " + info);
            }
        }

        // statistics
        for (CustomerProfile cp : customerPicks) {
            for (Order order : cp.getOrders()) {
                for (OrderItem item : order.getOrderItems()) {
                    String name = item.selectedproduct.getName();
                    map.put(name, map.getOrDefault(name, 0) + 1);
                }
            }
        }

        //OrderItem with top 10
        for (int i = 0; i < 10; i++) {
            chooseTop();
        }
        System.out.println("\n");
        System.out.println("***************************************");
        System.out.println("2: Top 10 products with best sales with sale valume:");
        
        for(int i=0; i<10; i++){
            System.out.println("Products Name: "+top10products.get(i)[0]+"   Sales Valume: "+top10products.get(i)[1]);
        }
       
        

        //top 3 suppliers
        for (int i = 0; i < 3; i++) {
            chooseTopSuppliers(supplierPicks);
        }
        System.out.println("\n");
        System.out.println("***************************************");
        System.out.println("3: Top 3 suppliers with best sales price:");
        for (Supplier s : top3Suppliers) {
            System.out.println("Supplier: "+s.getName()+"        Sales Price: "+s.saleAllPricesSum);
        }
    }

    private ArrayList<Supplier> top3Suppliers = new ArrayList<>();

    public void chooseTopSuppliers(ArrayList<Supplier> supplierPicks) {
        Supplier supplier = null;
        for (Supplier s : supplierPicks) {
            if (supplier == null || s.saleAllPricesSum > supplier.saleAllPricesSum) {
                supplier = s;
            }
        }
        top3Suppliers.add(supplier);
        supplierPicks.remove(supplier);
    }

    private ArrayList<String[]> top10products = new ArrayList<>();

    public void chooseTop() {
        Map.Entry<String, Integer> top = null;
        for (Map.Entry<String, Integer> m : this.map.entrySet()) {
            if (top == null || top.getValue() < m.getValue()) {
                top = m;
            }
        }
        String[] number=new String[2];
        if (top10products.size() < 10) {
            number[0]=top.getKey();
            number[1]=""+top.getValue();
            top10products.add(number);
        }
        this.map.remove(top.getKey());
    }

    public void populateSupplierDirectory(SupplierDirectory sd, int count) {
        for (int i = 0; i < count; i++) {
            String supplierName = faker.company().name();
            sd.newSupplier(supplierName, "General");
        }
    }

    public void populateCustomerDirectory(CustomerDirectory cd, int count) {
        for (int i = 0; i < count; i++) {
            String customerName = faker.name().fullName();
            cd.newCustomerProfile(new Person(customerName));
        }
    }

    public void populateProductCatalog(ProductCatalog pc, int count) {
        for (int i = 0; i < count; i++) {
            String productName = faker.food().fruit();
            int cp = 100 + random.nextInt(100);
            int fp = 0 + random.nextInt(50);
            int tp = this.getRandomPrice(fp, cp);
            pc.newProduct(fp, cp, tp, productName);

        }

    }

    public int getRandomPrice(int lower, int upper) {
        Random random = new Random();
        int result = 0;
        result = lower + random.nextInt(upper - lower);
        return result;
    }

}
