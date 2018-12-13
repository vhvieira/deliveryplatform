package app.payment;

import app.delivery.Point;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Rafael Leal on 14/10/2018.
 */
@Entity
public class MoneyPayment extends Payment{

    private BigDecimal coinChange;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "POINT_ID", foreignKey = @ForeignKey(name = "POINT_ID_FK"))
    private Point paymentPoint;

    public BigDecimal getChange() {
        return coinChange;
    }

    public void setChange(BigDecimal coinChange) {
        this.coinChange = coinChange;
    }

    public Point getPaymentPoint() {
        return paymentPoint;
    }

    public void setPaymentPoint(Point paymentPoint) {
        this.paymentPoint = paymentPoint;
    }
}
