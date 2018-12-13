package app.customer.natural_customer;

import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NaturalCustomerRepository extends JpaRepository<NaturalCustomer, Long> {

    List<NaturalCustomer> findAllByStatusCode(StatusCode statusCode);

    @Transactional
    @Modifying
    @Query("UPDATE NaturalCustomer n SET n.statusCode = :statusCode WHERE n.id = :id")
    void updateStatusCodeByNaturalCustomerId(@Param("id") Long id, @Param("statusCode") StatusCode statusCode);
}
