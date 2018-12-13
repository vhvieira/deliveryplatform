package app.delivery;

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
public class DeliveryController {

    private DeliveryService deliveryService;

    DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping(value = API_LIST_ALL_DELIVERIES, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Delivery>> getAllDeliveries() {
        return new ResponseEntity<>(this.deliveryService.listAllActiveDeliveries(), HttpStatus.OK);
    }

    @GetMapping(value = API_DELIVERY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Delivery> getDeliveryById(@PathVariable(value = "id") Long id) throws Exception {
        return new ResponseEntity<>(this.deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

    @PostMapping(value = API_NEW_DELIVERY, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity addDelivery(@RequestBody Delivery d) {

        Delivery delivery = deliveryService.addDelivery(d);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(API_DELIVERY_ID)
                .buildAndExpand(delivery.getId())
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(delivery, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = API_DELIVERY_ID)
    public ResponseEntity<Delivery> updateDelivery(@PathVariable("id") Long id, @RequestBody Delivery delivery) {
        return new ResponseEntity<>(this.deliveryService.updateDelivery(delivery), HttpStatus.OK);
    }

    @DeleteMapping(value = API_DELIVERY_ID)
    public ResponseEntity deleteDelivery(@PathVariable Long id) {
        this.deliveryService.cancelDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
