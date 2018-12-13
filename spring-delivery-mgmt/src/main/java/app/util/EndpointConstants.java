package app.util;

/**
 * Created by Rafael Leal on 22/10/2018.
 */
public class EndpointConstants {
    public static final String API_V1 = "/api/v1";

    //Biker endpoint
    public static final String API_LIST_ALL_BIKERS_SUMMARY = "/bikers/summary";
    public static final String API_LIST_ALL_BIKERS = "/bikers";
    public static final String API_BIKER_ID = "/biker/{id}";
    public static final String API_NEW_BIKER = "/biker/new";

    //Customer endpoint
    public static final String API_LIST_ALL_CUSTOMERS = "/customers";

    //Legal Customer endpoint
    public static final String API_LIST_ALL_LEGAL_CUSTOMERS = "/legal-customers";
    public static final String API_LEGAL_CUSTOMER_ID = "/legal-customer/{id}";
    public static final String API_NEW_LEGAL_CUSTOMER = "/legal-customer/new";

    //Natural Customer endpoint
    public static final String API_LIST_ALL_NATURAL_CUSTOMERS = "/natural-customers";
    public static final String API_NATURAL_CUSTOMER_ID = "/natural-customer/{id}";
    public static final String API_NEW_NATURAL_CUSTOMER = "/natural-customer/new";

    //Delivery endpoint
    public static final String API_LIST_ALL_DELIVERIES = "/deliveries";
    public static final String API_DELIVERY_ID = "/delivery/{id}";
    public static final String API_NEW_DELIVERY = "/delivery/new";

    public static final String API_CASH_FLOW = "/cash-flow";
}
