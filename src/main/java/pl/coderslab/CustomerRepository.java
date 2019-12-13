package pl.coderslab;

import pl.coderslab.beans.Customer;

import java.util.List;

//zad 3.1
public interface CustomerRepository {

    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void getCustomerList();
}
