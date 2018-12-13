package app.customer.natural_customer;

import java.util.List;

public interface NaturalCustomerService {
    List<NaturalCustomer> listAllNaturalCustomres();

    NaturalCustomer addNaturalCustomer(NaturalCustomer customer);

    void deleteNaturalCustomer(Long id);

    NaturalCustomer updateNaturalCustomer(NaturalCustomer naturalCustomer);
}
