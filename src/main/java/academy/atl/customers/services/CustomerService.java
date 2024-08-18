package academy.atl.customers.services;

import academy.atl.customers.entities.Customer;


import java.util.List;

public interface CustomerService {

     Customer getCustomer(Integer id);
     List<Customer> getAllCustomers();
     void removeCustomer(Integer id);
     void updateCustomer(Integer id, Customer updatecustomer);
     void addCustomer(Customer customer);
     List<Customer> searchCustomer( String email, String address);

}
