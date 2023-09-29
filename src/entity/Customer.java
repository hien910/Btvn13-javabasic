package entity;

import constant.Type;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Inputable {
    private int id;
    private static int id_auto =10000;
    private String name;
    private String address;
    private int phone;

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId_auto() {
        return id_auto;
    }

    public static void setId_auto(int id_auto) {
        Customer.id_auto = id_auto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Customer() {
        this.id =id_auto;
        id_auto++;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.print("Nhập tên khách hàng: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập số điện thoại: ");
        do {
            try{
                this.setPhone(new Scanner(System.in).nextInt());
                break;
            }catch (InputMismatchException e1){
                System.out.println("dữ liệu không hợp lệ, nhập lại: ");
            }
        }while (true);
        System.out.println("Nhập loại khách hàng, vui lòng chọn 1 trong 3 lựa chọn dưới đây: ");
        System.out.println("1. Cá nhân");
        System.out.println("2. Đại diện cho đơn vị hành chính");
        System.out.println("3. Đại diện cho đơn vị kinh doanh");
        int n ;
        do {
            n = new Scanner(System.in).nextInt();
            if (n>0&&n<4) {
                break;
            }
            System.out.println("nhập lại");
        }while (true);
        switch (n){
            case  1:
                this.setType(Type.CA_NHAN);
                break;
            case  2:
                this.setType(Type.DAI_DIEN_DON_VI_HANH_CHINH);
                break;
            case  3:
                this.setType(Type.DAI_DIEN_DON_VI_KINH_DOANH);
                break;
        }



    }
}
