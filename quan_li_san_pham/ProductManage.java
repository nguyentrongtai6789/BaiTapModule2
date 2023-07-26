package quan_li_san_pham;

import thuc_hanh_Student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    Product product1 = new Product(1, "Iphone 12", 15_000_000, "IPhone", "Hàng nguyên seal");
    Product product2 = new Product(2, "Iphone 13", 20_000_000, "IPhone", "Hàng nguyên seal");
    Product product3 = new Product(3, "Iphone 14 ProMax", 25_000_000, "IPhone", "Hàng like new 99%");
    Product product4 = new Product(4, "Samsung s22 Ultra", 27_000_000, "Samsung", "Hàng nguyên seal");
    Product product5 = new Product(5, "Oppo ZFlip 9s", 23_000_000, "Oppo", "Hàng like new 97%");
    List<Product> productList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void setProductList() {
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        writeProductListToFile(productList);
    }

    public void writeProductListToFile(List<Product> productList) {
        try {
            File file = new File("C:\\Users\\nguye\\Desktop\\product.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayProductListFromFile() {
        try {
            File file = new File("C:\\Users\\nguye\\Desktop\\product.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            System.out.println("Có " + productList.size() + " sản phẩm, danh sách như sau:");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println((i + 1) + ". " + productList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void checkId(int id) throws Exception {
        boolean check = false;
        for (Product product : productList) {
            if (product.getId() == id) {
                check = true;
                break;
            }
        }
        if (!check) throw new Exception("Id không có trong danh sách.");
    }

    public void addProduct() {
        // Lấy id mới:
        Product newProduct = new Product();
        while (true) {
            try {
                System.out.println("Bạn đang thêm mới sản phẩm trong danh sách.");
                System.out.println("Nhập id của sản phẩm: ");
                int id = Integer.parseInt(scanner.nextLine());
                for (Product product : productList) {
                    if (product.getId() == id) throw new Exception("Id này đã tồn tại.");
                }
                newProduct.setId(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // Lấy tên mới:
        System.out.println("Nhập tên của sản phẩm:");
        String name = scanner.nextLine();
        newProduct.setName(name);
        // Lấy giá mới:
        while (true) {
            try {
                System.out.println("Nhập giá cúa sản phẩm:");
                double price = Double.parseDouble(scanner.nextLine());
                newProduct.setPrice(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            }
        }
        // Lấy hãng sản xuất:
        System.out.println("Nhập tên hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        newProduct.setManufacturer(manufacturer);
        // Lấy mô tả:
        System.out.println("Nhập mô tả cho sản phẩm:");
        String description = scanner.nextLine();
        newProduct.setDescription(description);
        productList.add(newProduct);
        writeProductListToFile(productList);
        System.out.println("Bạn đã thêm mới sản phẩm xong.");
    }

    public void editProductById() {
        while (true) {
            int id = 0;
            try {
                System.out.println("Bạn đang sửa thông tin sản phẩm theo id.");
                // Lấy id và xét ngoại lệ:
                System.out.println("Nhập id của sản phẩm bạn muốn sửa:");
                id = Integer.parseInt(scanner.nextLine());
                checkId(id);// Kiểm tra id có trong list hay không
                for (Product product : productList) {
                    if (product.getId() == id) {
                        System.out.println("Nhập tên mới của sản phẩm: ");
                        String name = scanner.nextLine();
                        product.setName(name);
                        // Lấy giá mới và xét ngoại lệ:
                        while (true) {
                            try {
                                System.out.println("Nhập giá mới của sản phẩm: ");
                                double price = Double.parseDouble(scanner.nextLine());
                                product.setPrice(price);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
                            }
                        }
                        System.out.println("Nhập tên hãng sản xuất của sản phẩm: ");
                        String manufacturer = scanner.nextLine();
                        product.setManufacturer(manufacturer);
                        System.out.println("Nhập mô tả cho sản phẩm mới: ");
                        String description = scanner.nextLine();
                        product.setDescription(description);
                    }
                }
                writeProductListToFile(productList);
                System.out.println("Bạn đã sửa xong sản phẩm.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void searchProductById() {
        while (true) {
            try {
                System.out.println("Bạn đang lấy thông tin sản phẩm theo id.");
                System.out.println("Nhập vào id của sản phẩm mà bạn muốn lấy thông tin");
                int id = Integer.parseInt(scanner.nextLine());
                checkId(id);
                File file = new File("C:\\Users\\nguye\\Desktop\\product.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                productList = (List<Product>) objectInputStream.readObject();
                for (Product product : productList) {
                    if (product.getId() == id) {
                        System.out.println("Thông tin sản phẩm có id = " + id + " là: ");
                        System.out.println(product);
                        break;
                    }
                }
                System.out.println("Hoàn thành xong lấy thông tin sản phẩm.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu không đúng.");
            } catch (FileNotFoundException e) {
                System.out.println("Không tìm thấy file.");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}