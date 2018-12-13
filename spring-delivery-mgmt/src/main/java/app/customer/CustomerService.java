package app.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();

    List<CustomerCashFlow> getCustomersCashFlow();
}
