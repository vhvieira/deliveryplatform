package app.delivery;

import app.delivery.dto.DeliveryMapper;
import app.enums.DeliveryStatus;
import app.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public List<Delivery> listAllActiveDeliveries() {
        return this.deliveryRepository.findByStatusCode(StatusCode.A);
    }

    @Override
    public Delivery getDeliveryById(Long id) throws Exception {
        Optional<Delivery> optionalDelivery = this.deliveryRepository.findById(id);
        if (optionalDelivery.isPresent()) {
            return optionalDelivery.get();
        } else {
            throw new Exception("Not found");
        }
    }

    @Override
    public Delivery addDelivery(Delivery delivery) {
        delivery.setStatusCode(StatusCode.A);
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        delivery.setStatusCode(StatusCode.A);
        Delivery newDelivery = this.deliveryRepository.save(delivery);
        return newDelivery;
    }

    @Override
    public void cancelDelivery(Long id) {
        this.deliveryRepository.updateStatusCodeAndStatusDeliveryByDeliveryId(id, StatusCode.D, DeliveryStatus.CANCELED);
    }


}
