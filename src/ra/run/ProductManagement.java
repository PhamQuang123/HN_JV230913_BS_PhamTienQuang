package ra.run;

import ra.bussiness.IProduct;
import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static List<Product> listProduct = new ArrayList<>();
//   public static Product product = new Product();

    public static void main(String[] args) {
        do {
            System.out.println("****************PRODUCT-T-MANAGER-MENU***************");
            System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm ");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm ");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(IProduct.scanner.nextLine());
            switch (choice) {
                case 1:
                    inputListProduct();
                    break;
                case 2:
                    displayListProduct();
                    break;
                case 3:
                    sortListProduct();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    findProductByName();
                    break;
                case 6:
                    changeProductStatusById();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }

    public static void inputListProduct() {
        System.out.println("Nhập số sản phẩm bạn cần nhập thông tin:");
        int n = Integer.parseInt(IProduct.scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputData();
            listProduct.add(product);
        }
    }

    public static void displayListProduct() {
        for (Product product : listProduct) {
            product.displayData();
        }
    }

    public static void deleteProductById() {
        System.out.println("Nhập mã sản phẩm cần xoá:");
        int inputProductId = Integer.parseInt(IProduct.scanner.nextLine());
        int indexDelete = findIndexById(inputProductId);
        if (indexDelete >= 0) {
            listProduct.remove(indexDelete);
        } else {
            System.err.println("Mã không tồn tại");
        }
    }

    public static int findIndexById(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void findProductByName() {
        System.out.println("Nhập tên sản phẩm cần tìm:");
        String inputProductName = IProduct.scanner.nextLine();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductName().equals(inputProductName)) {
                System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - Tiêu đề: %s - Mô tả: %s\n",
                        listProduct.get(i).getProductId(), listProduct.get(i).getProductName(),
                        listProduct.get(i).getTitle(), listProduct.get(i).getDescriptions());
                System.out.printf("Giá nhập: %.3f - Giá xuất: %.3f - Lợi nhuận: %.3f - Trạng thái: %s\n",
                        listProduct.get(i).getImportPrice(), listProduct.get(i).getExportPrice(),
                        listProduct.get(i).getInterest(), listProduct.get(i).isProductStatus() ? "true" : "false");
            }
        }
    }
    public  static void changeProductStatusById(){
        System.out.println("Nhập mã sản phẩm cần thay đổi trạng thái:");
        int inputProductId = Integer.parseInt(IProduct.scanner.nextLine());
        int indexChange = findIndexById(inputProductId);
       if (indexChange >=0){
           listProduct.get(indexChange).setProductStatus(!listProduct.get(indexChange).isProductStatus());
       }else {
           System.err.println("Mã không tồn tại");
       }
    }
    public static void  sortListProduct(){
        int sortField = findSortField();
        int ascOrDesc = findAscOrDesc();

        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (sortField == 1 && ascOrDesc == 1){
                    return o1.getProductName().compareTo(o2.getProductName());
                } else if (sortField == 1 && ascOrDesc == 2) {
                    return -o1.getProductName().compareTo(o2.getProductName());

                } else if (sortField == 2 && ascOrDesc == 1) {
                    int price1 = (int) o1.getExportPrice();
                    int price2 = (int) o2.getExportPrice();
                    return  price1 - price2;
                }else if (sortField == 2 && ascOrDesc == 2) {
                    int price1 = (int) o1.getExportPrice();
                    int price2 = (int) o2.getExportPrice();
                    return  -(price1 - price2);
                }else if (sortField == 3 && ascOrDesc == 1) {
                    int price1 = (int) o1.getInterest();
                    int price2 = (int) o2.getInterest();
                    return  price1 - price2;
                }else if (sortField == 3 && ascOrDesc == 2) {
                    int price1 = (int) o1.getInterest();
                    int price2 = (int) o2.getInterest();
                    return  -(price1 - price2);
                }
                return 0;
            }
        });
    }
    public static int   findSortField(){
            System.out.println("Hãy chọn trường muốn sắp xếp:");
            System.out.println("1. Tên");
            System.out.println("2. Giá bán");
            System.out.println("3. Lợi nhuận");
            System.out.println("Lựa chọn của bạn là:");
            int choice = Integer.parseInt(IProduct.scanner.nextLine());
            return choice;
    }
    public static int   findAscOrDesc(){
            System.out.println("Hãy chọn hướng sắp xếp:");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            System.out.println("Lựa chọn của bạn là: ");
            return  Integer.parseInt(IProduct.scanner.nextLine());
    }
}
