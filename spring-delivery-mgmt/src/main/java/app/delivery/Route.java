package app.delivery;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private BigDecimal totalDistance;

    @Column(nullable = false)
    private BigDecimal totalDue;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Point> points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(BigDecimal totalDistance) {
        this.totalDistance = totalDistance;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public BigDecimal getTotalDue() { return totalDue; }

    public void setTotalDue(BigDecimal totalDue) { this.totalDue = totalDue; }
}
