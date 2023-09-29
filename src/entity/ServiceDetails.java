package entity;

public class ServiceDetails {
    private Service service;
    private int quantity;

    public ServiceDetails(Service dichVu, int numUnit) {
        this.service =dichVu;
        this.quantity =numUnit;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ServiceDetails{" + "service=" + service + ", quantity=" + quantity + '}';
    }

}
