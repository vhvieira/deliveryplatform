package app.customer.legal_customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static app.util.EndpointConstants.*;

@RestController
@RequestMapping(API_V1)
public class LegalCustomerController {

    private LegalCustomerService legalCustomerService;

    @Autowired
    LegalCustomerController(LegalCustomerService legalCustomerService) {
        this.legalCustomerService = legalCustomerService;
    }

    @GetMapping(value = API_LIST_ALL_LEGAL_CUSTOMERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<LegalCustomer>> listAllLegalCustomers() {
        return new ResponseEntity<>(this.legalCustomerService.listAllLegalCustomers(), HttpStatus.OK);
    }

    @PostMapping(value = API_NEW_LEGAL_CUSTOMER, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity addLegalCustomer(@RequestBody LegalCustomer customer) {
        LegalCustomer legalCustomer = legalCustomerService.addLegalCustomer(customer);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path(API_LEGAL_CUSTOMER_ID)
            .buildAndExpand(legalCustomer.getId())
            .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(legalCustomer, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = API_LEGAL_CUSTOMER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<LegalCustomer> updateLegalCustomer(@PathVariable("id") Long id, @RequestBody LegalCustomer legalCustomer) {
        return new ResponseEntity<>(this.legalCustomerService.updateLegalCustomer(legalCustomer), HttpStatus.OK);
    }

    @DeleteMapping(value = API_LEGAL_CUSTOMER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LegalCustomer> deleteLegalCustomer(@PathVariable Long id) {
        this.legalCustomerService.deleteLegalCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
