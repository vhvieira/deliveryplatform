package app.customer;

import app.enums.ContractType;
import app.enums.StatusCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = {"test"})
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
        assertNotNull("the customerRepository should be non-null",
                this.customerRepository);
    }

    @Test
    public void testFindCustomersByStatusCode() {
        List<Customer> customerList = this.customerRepository.findByStatusCode(StatusCode.A);
        assertTrue(customerList.size() != 0);
        assertEquals(new Long(1), customerList.get(0).getId());
        assertEquals(ContractType.BILLED, customerList.get(0).getContractType());

        assertEquals(new Long(2), customerList.get(1).getId());
        assertEquals(ContractType.SPONTANEOUS, customerList.get(1).getContractType());
    }

}
