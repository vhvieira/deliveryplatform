package app.customer;

import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> listAllCustomers() {
        return this.customerRepository.findByStatusCode(StatusCode.A);
    }

    @Override
    public List<CustomerCashFlow> getCustomersCashFlow() {
        return this.customerRepository.getCustomersCashFlow();
    }
}
