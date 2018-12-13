package app.customer.natural_customer;

import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaturalCustomerServiceImpl implements NaturalCustomerService {

    @Autowired
    private NaturalCustomerRepository naturalCustomerRepository;

    @Override
    public List<NaturalCustomer> listAllNaturalCustomres() {
        return this.naturalCustomerRepository.findAllByStatusCode(StatusCode.A);
    }

    @Override
    public NaturalCustomer addNaturalCustomer(NaturalCustomer customer) {
        customer.setStatusCode(StatusCode.A);
        return this.naturalCustomerRepository.save(customer);
    }

    @Override
    public void deleteNaturalCustomer(Long id) {
        this.naturalCustomerRepository.updateStatusCodeByNaturalCustomerId(id, StatusCode.D);
    }

    @Override
    public NaturalCustomer updateNaturalCustomer(NaturalCustomer naturalCustomer) {
        naturalCustomer.setStatusCode(StatusCode.A);
        return this.naturalCustomerRepository.save(naturalCustomer);
    }
}
