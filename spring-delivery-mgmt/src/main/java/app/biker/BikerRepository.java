package app.biker;

import app.biker.dto.BikerSummaryDTO;
import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rafael Leal on 27/10/2018.
 */
@Repository
public interface BikerRepository extends JpaRepository<Biker, Long> {

    List<Biker> findByStatusCode(StatusCode statusCode);

    @Query("SELECT new app.biker.dto.BikerSummaryDTO(" +
            "b.fullName, " +
            "COUNT(d), " +
            "SUM(r.totalDistance), " +
            "SUM(r.totalDue)" +
            ")" +
            " FROM Delivery AS d" +
            " LEFT JOIN d.route r" +
            " LEFT JOIN d.biker b" +
            " WHERE b.statusCode = 'A'" +
            " GROUP BY b.id")
    List<BikerSummaryDTO> getAllActiveBikersSummary();

    @Transactional
    @Modifying
    @Query("UPDATE Biker b SET b.statusCode = :statusCode WHERE b.id = :bikerId")
    void updateStatusCodeByBikerId(@Param("bikerId") Long bikerId, @Param("statusCode") StatusCode statusCode);
}
