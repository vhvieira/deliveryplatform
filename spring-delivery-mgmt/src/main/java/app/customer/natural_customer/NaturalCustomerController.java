package app.customer.natural_customer;

import app.util.EndpointConstants;
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
public class NaturalCustomerController {

    private NaturalCustomerService naturalCustomerService;

    @Autowired
    NaturalCustomerController(NaturalCustomerService naturalCustomerService) {
        this.naturalCustomerService = naturalCustomerService;
    }

    @GetMapping(value = API_LIST_ALL_NATURAL_CUSTOMERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<NaturalCustomer>> listAllNaturalCustomers() {
        return new ResponseEntity<>(this.naturalCustomerService.listAllNaturalCustomres(), HttpStatus.OK);
    }

    @PostMapping(value = API_NEW_NATURAL_CUSTOMER, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity addLegalCustomer(@RequestBody NaturalCustomer customer) {
        NaturalCustomer naturalCustomer = naturalCustomerService.addNaturalCustomer(customer);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_NATURAL_CUSTOMER_ID)
                .buildAndExpand(naturalCustomer.getId())
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(naturalCustomer, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = EndpointConstants.API_NATURAL_CUSTOMER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<NaturalCustomer> updateNaturalCustomer(@PathVariable("id") Long naturalCustomerId, @RequestBody NaturalCustomer naturalCustomer) {
        return new ResponseEntity<>(this.naturalCustomerService.updateNaturalCustomer(naturalCustomer), HttpStatus.OK);
    }

    @DeleteMapping(value = EndpointConstants.API_NATURAL_CUSTOMER_ID, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NaturalCustomer> deleteNaturalCustomer(@PathVariable("id") Long naturalCustomerId) {
        this.naturalCustomerService.deleteNaturalCustomer(naturalCustomerId);
        return ResponseEntity.noContent().build();
    }
}
