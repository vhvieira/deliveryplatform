package app.customer.natural_customer;

import app.customer.Customer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
@DiscriminatorValue("NATURAL")
public class NaturalCustomer extends Customer {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
