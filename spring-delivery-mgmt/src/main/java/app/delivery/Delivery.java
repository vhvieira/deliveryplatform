package app.delivery;

import app.biker.Biker;
import app.customer.Customer;
import app.enums.DeliveryStatus;
import app.enums.StatusCode;
import app.payment.Payment;
import app.util.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_DELIVERY", nullable = false)
    @ColumnDefault("'REGISTERED'")
    private DeliveryStatus statusDelivery;

    @CreationTimestamp
    private LocalTime registeredTime;

    private LocalTime collectUpTime;

    private LocalTime handoverTime;

    private Double finalAmount;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UPDATED_AT", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROUTE_ID", foreignKey = @ForeignKey(name = "ROUTE_ID_FK"), nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", foreignKey = @ForeignKey(name = "CUSTOMER_ID_FK"), nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "BIKER_ID", foreignKey = @ForeignKey(name = "BIKER_ID_FK"), nullable = false)
    private Biker biker;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Payment payment;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "STAT_CD", nullable = false)
    @ColumnDefault("'A'")
    private StatusCode statusCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryStatus getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(DeliveryStatus statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public LocalTime getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(LocalTime registeredTime) {
        this.registeredTime = registeredTime;
    }

    public LocalTime getCollectUpTime() {
        return collectUpTime;
    }

    public void setCollectUpTime(LocalTime collectUpTime) {
        this.collectUpTime = collectUpTime;
    }

    public LocalTime getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(LocalTime handoverTime) {
        this.handoverTime = handoverTime;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Biker getBiker() {
        return biker;
    }

    public void setBiker(Biker biker) {
        this.biker = biker;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
