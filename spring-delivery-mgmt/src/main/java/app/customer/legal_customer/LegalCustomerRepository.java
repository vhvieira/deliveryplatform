package app.customer.legal_customer;

import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LegalCustomerRepository extends JpaRepository<LegalCustomer, Long> {

    List<LegalCustomer> findAllByStatusCode(StatusCode statusCode);

    @Transactional
    @Modifying
    @Query("UPDATE LegalCustomer l SET l.statusCode = :statusCode WHERE l.id = :id")
    void updateStatusCodeByLegalCustomerId(@Param("id") Long id, @Param("statusCode") StatusCode statusCode);
}
