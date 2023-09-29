package entity;

import java.util.Arrays;

public class Bill {
    private Customer customer;
    private ServiceDetails[] serviceDetails;




    public Bill(Customer khachHang, ServiceDetails[] serviceDetails) {
        this.customer =khachHang;
        this.serviceDetails = serviceDetails;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", serviceDetails=" + Arrays.toString(serviceDetails) +

                '}';
    }

//    public int getTotalService() {
//        return total;
//    }
//
//    public void setTotalService(int totalService) {
//        this.total = totalService;
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public ServiceDetails[] getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(ServiceDetails[] serviceDetails) {
        this.serviceDetails = serviceDetails;
    }



}
