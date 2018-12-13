package app.biker.dto;

import java.math.BigDecimal;

public class BikerSummaryDTO {

    private String fullName;

    private Long totalDeliveries;

    private BigDecimal totalDistance;

    private BigDecimal totalDue;

    public BikerSummaryDTO(String fullName, Long totalDeliveries, BigDecimal totalDistance, BigDecimal totalDue) {
        this.fullName = fullName;
        this.totalDeliveries = totalDeliveries;
        this.totalDistance = totalDistance;
        this.totalDue = totalDue;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(Long totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public BigDecimal getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(BigDecimal totalDistance) {
        this.totalDistance = totalDistance;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }
}
