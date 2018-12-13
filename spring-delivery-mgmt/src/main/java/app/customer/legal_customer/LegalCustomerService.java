package app.customer.legal_customer;

import java.util.List;

public interface LegalCustomerService {

    List<LegalCustomer> listAllLegalCustomers();

    LegalCustomer addLegalCustomer(LegalCustomer customer);

    LegalCustomer updateLegalCustomer(LegalCustomer customer);

    void deleteLegalCustomer(Long id);
}
