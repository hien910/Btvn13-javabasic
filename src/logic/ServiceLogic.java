package logic;

import entity.Customer;
import entity.Service;
import entity.ServiceDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceLogic {
    private Service[] services;
    public int totalService;

    public Service[] getServices() {
        return services;
    }

    public int getTotalService() {
        return totalService;
    }

    public ServiceLogic(Service[] services) {
        this.services = services;
    }
    public void addNewService() {
        System.out.print("Nhập số lượng dịch vụ mới: ");
        int numService;
        do {
            try {
                numService = new Scanner(System.in).nextInt();

                if (numService > 0) {
                    break;
                }
                System.out.print("số lượng phải > 0, nhập lại: ");
            } catch (InputMismatchException e1) {
                System.out.print("Dữ liệu không hợp lệ, nhập lại");
            }
        } while (true);

        for (int i = 0; i <numService ; i++) {
            System.out.println("nhập thông tin cho dịch vụ thứ "+(i+1));
            Service service = new Service();
            service.inputInfo();
            saveCustomer(service);

        }
        totalService += numService;
    }

    private void saveCustomer(Service s) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null){
                services[i] = s;
                break;
            }
        }
    }
    public void showService(){
        for (int i = 0; i < services.length; i++) {
            if (services[i]!= null){
                System.out.println(services[i]);
            }
        }
    }
    public Service searchByIdCustomer(int id){
        Service ketQua = null;
        for (int i = 0; i < services.length; i++) {
            if (services[i]!=null && id == services[i].getId()){
                ketQua = services[i];
                break;
            }
        }
        return ketQua;
    }

}
