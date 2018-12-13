package app.delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> listAllActiveDeliveries();
    Delivery getDeliveryById(Long id) throws Exception;
    Delivery addDelivery(Delivery delivery);

    Delivery updateDelivery(Delivery delivery);

    void cancelDelivery(Long id);
}
