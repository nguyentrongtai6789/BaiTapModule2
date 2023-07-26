package quan_li_san_pham;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        ProductManage productManage = new ProductManage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            productManage.displayProductListFromFile();
            int choice;
            System.out.println("Menu:");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Tìm sản phẩm");
            System.out.println("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2 && choice !=3) throw new Exception("Lựa chọn không được hỗ trợ.");
                switch (choice) {
                    case 1 -> productManage.addProduct();
                    case 2 -> productManage.editProductById();
                    case 3 -> productManage.searchProductById();
                }
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
