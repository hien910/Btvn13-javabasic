package logic;

import entity.Bill;
import entity.Customer;
import entity.Service;
import entity.ServiceDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BillLogic {
    private final CustomerLogic customerLogic;
    private final ServiceLogic serviceLogic;
    private final Bill[] bills ;


    public BillLogic(Bill[] bills, CustomerLogic customerLogic, ServiceLogic serviceLogic) {
        this.bills = bills;
        this.customerLogic = customerLogic;
        this.serviceLogic = serviceLogic;
    }
    public void lapHoaDon(){
        if (!coDuLieuChua()){
            System.out.println("chưa có dữ liệu");
            return;
        }
        System.out.print("bạn muốn lập hóa đơn cho bao nhiêu người: ");
        int numCus ;

        do {
            try{
                numCus = new Scanner(System.in).nextInt();
                if(numCus>0 && numCus <=customerLogic.getTotalCustomer()){
                    break;
                }
                System.out.println("phải là 1 số >0 và nhỏ hơn tổng số lượng khách hàng, nhập lại");
            }catch (InputMismatchException e1){
                System.out.print("dữ liệu nhập vào không đúng, nhập lại:");
            }
        }while (true);
        ServiceDetails[] serviceDetails = new ServiceDetails[numCus];


        for (int i = 0; i < numCus ; i++) {
            System.out.println("khách hàng thứ "+(i+1)+ " có id là: ");
            Customer khachHang = inputCustomer();         ////////////////

            System.out.println("khách hàng sử dụng bao nhiêu dịch vụ: ");
            int numServ ;
            do {
                try{
                    numServ = new Scanner(System.in).nextInt();
                    if(numServ>0 && numServ <6){
                        break;
                    }
                    System.out.println("phải là 1 số > 0 và < 6, nhập lại");
                }catch (InputMismatchException e1){
                    System.out.print("dữ liệu nhập vào không đúng, nhập lại:");
                }
            }while (true);
            int count =0;

            for (int j = 0; j < numServ; j++) {
                System.out.println("dịch vụ sử dụng có ID: ");
                Service dichVu =inputService();        ///////////////////
                System.out.println("Nhập số lượng (đơn vị tính là "+ dichVu.getUnit()+")");
                int numUnit = 0;
                do {
                    try {
                        numUnit = new Scanner(System.in).nextInt();
                        if (numUnit > 0) {
                            break;
                        }
                        System.out.println("Số lượng phải >0 ,vui lòng nhập lại: ");
                    }catch (InputMismatchException e2){
                        System.out.println("dữ liệu không đúng, nhập lại ");
                    }
                } while (true);
                ServiceDetails serviceDetail = new ServiceDetails(dichVu,numUnit);
                serviceDetails[count] = serviceDetail;
                count++;




                Bill bill = new Bill(khachHang,serviceDetails);
                saveBill(bill);

            }
            showBill();


        }

    }
    public void sortByName(){
        if (!coDuLieuBillChua()){
            System.out.println("chưa lập danh dách hóa đơn");
        }
        for (int i = 0; i < bills.length-1; i++) {
            if (bills[i]==null) {
                continue;
            }
            for (int j = i+1; j < bills.length; j++) {
                if (bills[j]!=null &&
                        bills[i].getCustomer().getName().compareToIgnoreCase(bills[j].getCustomer().getName())>0){

                    Bill temp = bills[i];
                    bills[i] = bills[j];
                    bills[j] =temp;
                }
            }
        }
        showBill();
    }
    public void sortByQuatity(){
        if (!coDuLieuBillChua()){
            System.out.println("chưa lập danh dách hóa đơn");
            return;
        }
        for (int i = 0; i < bills.length-1; i++) {
            if (bills[i]==null) {
                continue;
            }
            for (int j = i+1; j < bills.length; j++) {
                if (bills[j]!=null &&
                        bills[i].getServiceDetails()[i].getQuantity() <  bills[j].getServiceDetails()[i].getQuantity() ){
                    Bill temp = bills[i];
                    bills[i] = bills[j];
                    bills[j] =temp;
                }
            }
        }
        showBill();


    }
    public void thanhToan(){
        if(!coDuLieuBillChua()){
            System.out.println("chưa lập danh dách hóa đơn");
            return;
        }
        for (int i = 0; i < bills.length; i++) {
            double sum =0;
            Bill bill = bills[i];
            ServiceDetails[] serviceDetails1 = bill.getServiceDetails();
            for (int j = 0; j < serviceDetails1.length; j++) {
                sum += serviceDetails1[j].getService().getPrice() * serviceDetails1[j].getQuantity();
            }
            System.out.println("Số tiền phải trả của khách hàng "+ bill.getCustomer().getName()+ " là: "+sum);
        }

    }
    private boolean coDuLieuBillChua(){
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]!=null){
                return true;
            }
        }
        return false;
    }

    private void showBill() {
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]!=null){
                System.out.println(bills[i]);
            }
        }
    }

    private void saveBill(Bill bill) {
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] ==null){
                bills[i]=bill;
                break;
            }
        }
    }

    private Service inputService() {
        int idDichVu ;
        Service dv ;
        do {
            try{
                idDichVu = new Scanner(System.in).nextInt();
                dv = serviceLogic.searchByIdCustomer(idDichVu);
                if (dv!=null){
                    break;
                }
            }catch (InputMismatchException e1){
                System.out.println("dữ liệu nhập vào không đúng, nhập lại");
            }
        }while (true);
        return dv;
    }

    private Customer inputCustomer() {
        int idKhach;
        Customer customer ;
        do {
            try{
                idKhach = new Scanner(System.in).nextInt();
                customer = customerLogic.searchByIdCustomer(idKhach);
                if (customer!=null){
                    break;
                }
            }catch (InputMismatchException e1){
                System.out.println("dữ liệu nhập vào không đúng, nhập lại");
            }
        }while (true);
        return customer;
    }

    public boolean coDuLieuChua(){
        boolean dataCustomer =false ;
        for (int i = 0; i < customerLogic.getCustomers().length; i++) {
            if (customerLogic.getCustomers()[i]!=null){
                dataCustomer = true;
                break;
            }
        }

        boolean dataService = false;
        for (int i = 0; i < serviceLogic.getServices().length; i++) {
            if (serviceLogic.getServices()[i]!=null){
                dataService =true;
                break;
            }
        }

        return dataService&&dataCustomer;
    }


}
