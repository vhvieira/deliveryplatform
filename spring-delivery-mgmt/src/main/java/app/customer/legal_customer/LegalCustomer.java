package app.customer.legal_customer;

import app.customer.Customer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
@DiscriminatorValue("LEGAL")
public class LegalCustomer extends Customer {

    private String socialReason;

    private String cnpj;

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
