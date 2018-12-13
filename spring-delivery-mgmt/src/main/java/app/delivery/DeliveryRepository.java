package app.delivery;

import app.enums.DeliveryStatus;
import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByStatusCode(StatusCode statusCode);

    @Transactional
    @Modifying
    @Query("UPDATE Delivery d SET d.statusCode = :statusCode, d.statusDelivery = :deliveryStatus WHERE d.id = :id")
    void updateStatusCodeAndStatusDeliveryByDeliveryId(@Param("id") Long id,
                                                       @Param("statusCode") StatusCode statusCode,
                                                       @Param("deliveryStatus") DeliveryStatus deliveryStatus);
}
