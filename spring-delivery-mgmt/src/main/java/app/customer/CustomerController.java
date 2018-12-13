package app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static app.util.EndpointConstants.*;

@RestController
@RequestMapping(API_V1)
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping(value = API_LIST_ALL_CUSTOMERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(this.customerService.listAllCustomers(), HttpStatus.OK);
    }

    @GetMapping(value = API_LIST_ALL_CUSTOMERS + API_CASH_FLOW, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<CustomerCashFlow>> getCustomersCashFlow() {
        return new ResponseEntity<>(this.customerService.getCustomersCashFlow(), HttpStatus.OK);
    }
}
