package app.customer.legal_customer;

import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalCustomerServiceImpl implements LegalCustomerService {

    @Autowired
    private LegalCustomerRepository legalCustomerRepository;


    @Override
    public List<LegalCustomer> listAllLegalCustomers() {
        return this.legalCustomerRepository.findAllByStatusCode(StatusCode.A);
    }

    @Override
    public LegalCustomer addLegalCustomer(LegalCustomer customer) {
        customer.setStatusCode(StatusCode.A);
        return this.legalCustomerRepository.save(customer);
    }

    @Override
    public LegalCustomer updateLegalCustomer(LegalCustomer customer) {
        customer.setStatusCode(StatusCode.A);
        return this.legalCustomerRepository.save(customer);
    }

    @Override
    public void deleteLegalCustomer(Long id) {
        this.legalCustomerRepository.updateStatusCodeByLegalCustomerId(id, StatusCode.D);
    }
}
