package ra.bussinessImp;

import ra.bussiness.IProduct;

import java.util.Scanner;

public class Product implements IProduct{
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        this.productId = inputProductId();
        this.productName = inputProductName();
        this.title = inputTitle();
        this.descriptions = inputDescriptions();
        this.importPrice =inputImportPrice();
        this.exportPrice = inputExportPrice();
        this.interest = this.exportPrice - this.importPrice;
        this.productStatus = inputProductStatus();
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - Tiêu đề: %s - Mô tả: %s \n",
                this.productId, this.productName, this.title, this.descriptions);
        System.out.printf("Giá nhập: %.3f - Giá xuất: %.3f - Lợi nhuận: %.3f - Trạng thái: %s\n",
                this.importPrice, this.exportPrice, this.interest, this.productStatus? "true":"false");

    }
    public int inputProductId(){
        System.out.println("Nhập mã sản phẩm:");
        int productId = Integer.parseInt(IProduct.scanner.nextLine());
        return productId;
    }
    public String inputProductName(){
        System.out.println("Nhập tên sản phẩm:");
        String productName = IProduct.scanner.nextLine();
        return productName;
    }
    public String inputTitle(){
        System.out.println("Nhập tiêu đề sản phẩm:");
        return IProduct.scanner.nextLine();
    }
    public String inputDescriptions(){
        System.out.println("Nhập mô tả sản phẩm:");
        return IProduct.scanner.nextLine();
    }
    public float inputImportPrice(){
        System.out.println("Nhập vào giá nhập của sản phẩm:");
        return Float.parseFloat(IProduct.scanner.nextLine());
    }
    public float inputExportPrice(){
        System.out.println("Nhập vào giá xuất của sản phẩm:");
        return Float.parseFloat(IProduct.scanner.nextLine());
    }
    public boolean inputProductStatus(){
        System.out.println("Nhập trạng thái của sản phẩm:");
        return Boolean.parseBoolean(IProduct.scanner.nextLine());
    }


}
