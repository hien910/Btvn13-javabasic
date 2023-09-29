package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Service implements Inputable {
    private int id;
    private static int id_AutoUnit = 100;
    private String name;
    private int price;
    private String unit;

    public Service() {
        this.id = id_AutoUnit;
        id_AutoUnit++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId_AutoUnit() {
        return id_AutoUnit;
    }

    public static void setId_AutoUnit(int id_AutoUnit) {
        Service.id_AutoUnit = id_AutoUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên dịch vụ: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập giá cước: ");
        do {
            try {
                this.setPrice(new Scanner(System.in).nextInt());
                break;
            }catch (InputMismatchException e2){
                System.out.println("Dữ liệu nhập vào không đúng, nhập lại.");
            }
        } while (true);
        System.out.println("Nhập đơn vị tính: ");
        this.setUnit(new Scanner(System.in).nextLine());
//        do {
//            try {
//                this.setUnit(new Scanner(System.in).nextInt());
//                break;
//            }catch (InputMismatchException e2){
//                System.out.println("Dữ liệu nhập vào không đúng, nhập lại.");
//            }
//        } while (true);
    }
}
