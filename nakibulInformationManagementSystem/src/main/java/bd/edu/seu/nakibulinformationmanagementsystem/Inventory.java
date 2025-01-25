package bd.edu.seu.nakibulinformationmanagementsystem;

public class Inventory {
    private String item;
    private double price;
    private int quantity;
    private String supplier;
    private double totalPrice;

    public Inventory() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Inventory(String item, double price, int quantity, String supplier, double totalPrice) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.totalPrice = totalPrice;
    }
}
