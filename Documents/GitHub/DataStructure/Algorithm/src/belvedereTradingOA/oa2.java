package belvedereTradingOA;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * bear
 * eyeball,10.5,2,glass;paint
 * glass,5,0,
 * paint,4,0,
 * bear,null,4,eyeball;shirt;fur;thread
 * fur,15,2,be;yarn
 * be,100,0,
 * yarn,2,0
 * thread,13,0,
 * shirt,24,0
 *
 */

public class oa2 {
    private static DecimalFormat formatter = new DecimalFormat("0.00");
    
    public static class Product{
        public Product(String productName){
            ProductName = productName;
        }
        public Product(String productName, Double priceToPurchase, HashSet<String> inputProducts){
            ProductName = productName;
            PriceToPurchase = priceToPurchase;
            InputProducts = inputProducts;
            visited = false;
        }
        public String ProductName;
        public Double PriceToPurchase;
        public HashSet<String> InputProducts;
        public Boolean visited;

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(obj == null || obj.getClass() != this.getClass()){
                return false;
            }
            Product product = (Product) obj;
            return (product.ProductName == this.ProductName);
        }
        @Override
        public int hashCode(){
            return this.ProductName.hashCode();
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String targetProductName = "";
        HashSet<Product> allProducts = new HashSet<Product>();
        Boolean isFirstLine = true;
        while((line = in.readLine()) != null){
            if(line.equals("e")){
                break;
            }
            if(isFirstLine){
                targetProductName = line;
                isFirstLine = false;
                continue;
            }
            String[] lineSplit = line.split(",");
            allProducts.add(new Product(lineSplit[0], lineSplit[1].equals("null")? null : Double.parseDouble(lineSplit[1]),
                    lineSplit.length == 3? new HashSet<String>() : new HashSet<String>(Arrays.asList(lineSplit[3].split(";")))));
        }
        System.out.println(formatter.format(mySolution(targetProductName, allProducts)));
    }
    static Double mySolution(String targetProductName, HashSet<Product> allProducts){
        Product cur = new Product("", 0.0, new HashSet<String>());
        for(Product p : allProducts){
            if(p.ProductName.equals(targetProductName)){
                cur = p;
            }
        }
        // return condition
        if(cur.visited){
            return cur.PriceToPurchase;
        }
        if(cur.InputProducts.size() == 0){
            return cur.PriceToPurchase;
        }
        // dfs
        double total_child = 0;
        for(String p : cur.InputProducts){
            total_child += mySolution(p, allProducts);
        }
        // post order
        if(cur.PriceToPurchase == null) {
            cur.PriceToPurchase = total_child;
        }else{
            cur.PriceToPurchase = Math.min(total_child, cur.PriceToPurchase);
        }
        cur.visited = true;
        return cur.PriceToPurchase;
    }
}
