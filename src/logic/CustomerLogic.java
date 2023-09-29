package logic;

import entity.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerLogic {
    private Customer[] customers;
    private int totalCustomer;

    public Customer[] getCustomers() {
        return customers;
    }

    public int getTotalCustomer() {
        return totalCustomer;
    }

    public CustomerLogic(Customer[] customers) {
        this.customers = customers;
    }

    public void addNewCustomer() {
        System.out.print("Nhập số lượng khách hàng mới: ");
        int numCustomer;
        do {
            try {
                numCustomer = new Scanner(System.in).nextInt();
                if (numCustomer> 0) {
                    break;
                }
                System.out.print("số lượng phải >0, nhập lại:");
            } catch (InputMismatchException e1) {
                System.out.print("Dữ liệu không hợp lệ, nhập lại");
            }
        } while (true);

        for (int i = 0; i <numCustomer ; i++) {
            System.out.println("nhập thông tin cho khách hàng thứ"+(i+1));
            Customer customer = new Customer();
            customer.inputInfo();
            saveCustomer(customer);

        }
        totalCustomer += numCustomer;
    }

    private void saveCustomer(Customer c) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null){
                customers[i] = c;
                break;
            }
        }
    }
     public void showCustomer(){
         for (int i = 0; i < customers.length; i++) {
             if (customers[i]!= null){
                 System.out.println(customers[i]);
             }
         }
     }
     public Customer searchByIdCustomer(int id){
        Customer ketQua = null;
         for (int i = 0; i < customers.length; i++) {
             if (customers[i]!=null && id == customers[i].getId()){
                 ketQua = customers[i];
                 break;
             }
         }
         return ketQua;
     }

}
