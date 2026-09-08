package SS07.BT05;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMg {
    private static List<Product> productList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.println("Hãy chọn chức năng 1 -> 5: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    del();
                    break;
                case 5:
                    System.out.println("Đã thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
        
    }

    private static void menu() {
        System.out.println("Menu:");
        System.out.println("1. Thêm mới sp");
        System.out.println("2. Hiển thị ds sp");
        System.out.println("3. Cập nhật sp");
        System.out.println("4. Xóa sp");
        System.out.println("5. Thoát");
    }
    
    private static void add() {
        System.out.print("Hãy nhập ID sp: ");
        String id = sc.nextLine();

        System.out.print("Hãy nhập tên sp: ");
        String name = sc.nextLine();

        System.out.print("Hãy nhập giá sp: ");
        BigDecimal price = new BigDecimal(sc.nextLine());

        productList.add(new Product(id, name, price));
        System.out.println("Thêm sp thành công");
    }

    private static void show() {
        System.out.println("Product list: ");

        for (Product p: productList) {
            System.out.println(p);
        }
    }

    private static void update() {
        System.out.print("Hãy nhập ID sp cần cập nhật: ");
        String id = sc.nextLine();

        Product product = findById(id);
        if (product == null) {
            System.out.println("ID không tồn tại");
            return;
        }
        System.out.print("Nhập tên mới: ");
        String newName = sc.nextLine();
        System.out.print("Hãy nhập giá mới: ");
        BigDecimal newPrice = new BigDecimal(sc.nextLine());

        product.setName(newName);
        product.setPrice(newPrice);
        System.out.println("Cập nhật thành công");
    }

    private static void del() {
        System.out.print("Hãy nhập ID cần xóa: ");
        String id = sc.nextLine();

        Product product = findById(id);
        if (product == null) {
            System.out.println("ID không tồn tại");
            return;
        } 
        productList.remove(product);
        System.out.println("Đã xóa thành công");
    }

    private static Product findById(String id) {
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        } return null;
    }
}
