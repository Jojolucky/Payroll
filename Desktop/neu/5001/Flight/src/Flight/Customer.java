/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

/**
 *
 * @author jojo
 */
public class Customer {

    String name;
    int customer_number;

    public Customer(String name, int customer_number) {
        this.name = name;
        this.customer_number = customer_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(int customer_number) {
        this.customer_number = customer_number;
    }

}
