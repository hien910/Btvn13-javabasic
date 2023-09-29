package logic;

import entity.Bill;
import entity.Customer;
import entity.Service;

import java.util.Scanner;

public class MainLogic {
    private static CustomerLogic customerLogic;
    private ServiceLogic serviceLogic;
    private BillLogic billLogic ;

    public MainLogic() {
        Customer[] customers =new Customer[1000];
        customerLogic = new CustomerLogic(customers);

        Service[] services = new Service[100];
        serviceLogic = new ServiceLogic(services);

        Bill[] bills = new Bill[1000];
        billLogic = new BillLogic(bills, customerLogic,serviceLogic);

    }
    public  void menu(){
        while (true) {
            showMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    customerLogic.addNewCustomer();
                    customerLogic.showCustomer();
                    break;
                case 2:
                    serviceLogic.addNewService();
                    serviceLogic.showService();
                    break;
                case 3:
                    billLogic.lapHoaDon();
                    break;
                case 4:
                    billLogic.sortByName();
                    break;
                case 5:
                    billLogic.sortByQuatity();
                    break;
                case 6:
                    billLogic.thanhToan();
                    break;
                case 7:
                    return;
            }
        }
    }
    private int chooseFunction() {
        int choice = 0;
        System.out.print("Xin mời nhập lựa chọn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 7) {
                break;
            }
            System.out.print("Chức năng không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    private void showMenu() {
        System.out.println("=============PHẦN MỀM LẬP HÓA ĐƠN THANH TOÁN DỊCH VỤ============");
        System.out.println("1. Thêm danh sách khách hàng mới và in ra.");
        System.out.println("2. Thêm danh sách dịch vụ mới và in ra.");
        System.out.println("3. Lập danh sách hóa đơn và in ra");
        System.out.println("4. Sắp xếp danh sách hóa đơn theo tên khách hàng");
        System.out.println("5. Sắp xếp danh sách hóa đơn theo số lượng sử dụng");
        System.out.println("6. Lập bảng kê số tiền phải trả của mỗi khách hàng");
        System.out.println("7. Thoát");
    }


}
