package app.customer;

import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByStatusCode(StatusCode statusCode);

    @Query("SELECT new app.customer.CustomerCashFlow(" +
            "c.name," +
            "SUM(r.totalDue)," +
            "p.status" +
            ")" +
            " FROM Delivery AS d" +
            " LEFT JOIN d.route r" +
            " LEFT JOIN d.customer c" +
            " LEFT JOIN d.payment p" +
            " WHERE c.statusCode = 'A'" +
            " AND d.statusDelivery <> 'CANCELED'" +
            " GROUP BY c.id, p.status")
    List<CustomerCashFlow> getCustomersCashFlow();

}
