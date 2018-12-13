package app.delivery.dto;

import app.biker.Biker;
import app.customer.Customer;
import app.delivery.Route;
import app.enums.DeliveryStatus;
import app.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeliveryGetDTO {
    private Long id;

    private DeliveryStatus statusDelivery;

    private LocalDateTime createdAt;

    private Route route;

    private Customer customer;

    private Biker biker;

    private Payment payment;

}
